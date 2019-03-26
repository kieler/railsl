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
import de.cau.cs.kieler.kicool.ui.klighd.ModelReaderUtil
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.ui.IEditorPart
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.handlers.HandlerUtil
import java.lang.ProcessBuilder.Redirect

/**
 * @author sdo
 *
 */
class RailslDeployHandler extends AbstractHandler {
    
    var IEditorPart activeEditor
    val systemId = "de.cau.cs.kieler.railsl.netlist.deploy"
    var Process process
    
    override Object execute(ExecutionEvent event) throws ExecutionException {
        if (process !== null) {
            process.destroy
            println("Destroyed last process")
        }
        var shell = HandlerUtil.getActiveWorkbenchWindow(
                event).getShell()
        // Get and save active editor
        var NullProgressMonitor monitor = new NullProgressMonitor();
        activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()
        activeEditor.doSave(monitor)
        var confirmation = MessageDialog.openConfirm(shell, "Ausfuehren auf der Modellbahn",
        "Moechtest du wirklich auf der Modellbahn ausfuehren? Du solltest das nur tun, wenn du dein Programm getestet hast!");
        if (confirmation) {
            // compile model
            val eobject = ModelReaderUtil.readModelFromEditor(activeEditor)
            val context = Compile.createCompilationContext(systemId, eobject)
            var compContext = context.compile
            var ExecutableContainer executeableContainer = compContext.model as ExecutableContainer
            val processBuilder = executeableContainer.processBuilder
            processBuilder.redirectInput(Redirect.INHERIT)
            process = processBuilder.start
            
        } else {
            System.out.println("Did not execute")
            return null
        }
        return null;
    }
    
}