/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://rtsys.informatik.uni-kiel.de/kieler
 * 
 * Copyright 2019 by
 * + Kiel University
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 */
package de.cau.cs.kieler.railsl.ui.commands

import de.cau.cs.kieler.kicool.compilation.Compile
import de.cau.cs.kieler.kicool.compilation.ExecutableContainer
import de.cau.cs.kieler.kicool.environments.Environment
import de.cau.cs.kieler.kicool.ui.klighd.ModelReaderUtil
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.externaltools.internal.IExternalToolConstants
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.runtime.Status
import org.eclipse.debug.core.DebugPlugin
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy
import org.eclipse.debug.core.ILaunchManager
import org.eclipse.debug.ui.DebugUITools
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.statushandlers.StatusManager

/**
 * @author als
 */
abstract class RailStartHandler extends AbstractHandler {
    
    static val NAME = "Railway Launch"
    
    def compile(String system) {
        // Get and save active editor
        var NullProgressMonitor monitor = new NullProgressMonitor()
        val activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()
        activeEditor.doSave(monitor)
        
        // compile model
        var Environment result
        try {
            val eobject = ModelReaderUtil.readModelFromEditor(activeEditor)
            val context = Compile.createCompilationContext(system, eobject)
            result = context.compile
            
            if (context.hasErrors) {
                val status = new Status(IStatus.ERROR, "de.cau.cs.kieler.railsl", "Error(s) in railway compilation", new Throwable(context.allErrors.map[message].toSet.join("\n")))
                StatusManager.getManager().handle(status, StatusManager.SHOW.bitwiseOr(StatusManager.LOG))
                return null
            }
        } catch(Exception e) {
            val status = new Status(IStatus.ERROR, "de.cau.cs.kieler.railsl", "Exception in railway compilation", e)
            StatusManager.getManager().handle(status, StatusManager.SHOW.bitwiseOr(StatusManager.LOG))
            return null
        }
        
        return result.model as ExecutableContainer
    }
    
    def launch(ExecutableContainer exe) {
        val launch = createLaunch(IExternalToolConstants.ID_PROGRAM_LAUNCH_CONFIGURATION_TYPE)
        launch.configureExternalTool

        val commands = exe.processBuilder.command
        launch.setAttribute(IExternalToolConstants.ATTR_LOCATION, commands.head)
        
        if (commands.size > 1) {
            launch.setAttribute(IExternalToolConstants.ATTR_TOOL_ARGUMENTS, commands.drop(1).join(" "))
        }
        
        if (exe.processEnvironment !== null && !exe.processEnvironment.empty) {
            // FIXME Magic key
            launch.setAttribute("org.eclipse.debug.core.environmentVariables", exe.processEnvironment)
        }
        
        launch.setAttribute(DebugPlugin.ATTR_CAPTURE_OUTPUT, exe.console)
        
        DebugUITools.launch(launch.doSave(), ILaunchManager.RUN_MODE)
    }
    
    private def createLaunch(String type) {
        val manager = DebugPlugin.getDefault.getLaunchManager
        val launchType = manager.getLaunchConfigurationType(type)
        manager.getLaunchConfigurations(launchType).filter[NAME.equals(it.name)].forEach[it.delete]
        return launchType.newInstance(null, NAME)
    }
    
    private def configureExternalTool(ILaunchConfigurationWorkingCopy workingCopy) {
        workingCopy.setAttribute(DebugPlugin.ATTR_CAPTURE_OUTPUT, true)
        workingCopy.setAttribute(IExternalToolConstants.ATTR_SHOW_CONSOLE, true)
        workingCopy.setAttribute(IExternalToolConstants.ATTR_BUILDER_ENABLED, false)
//            workingCopy.setAttribute(IExternalToolConstants.ATTR_BUILD_SCOPE, IExternalToolConstants.BUILD_TYPE_NONE)
        workingCopy.setAttribute(IExternalToolConstants.ATTR_BUILD_SCOPE, "${none}")
        workingCopy.setAttribute(IExternalToolConstants.ATTR_LAUNCH_IN_BACKGROUND, true)
    }
}