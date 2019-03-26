package de.cau.cs.kieler.railsl.ui.commands

import de.cau.cs.kieler.kicool.compilation.Compile
import de.cau.cs.kieler.kicool.compilation.ExecutableContainer
import de.cau.cs.kieler.kicool.ui.klighd.ModelReaderUtil
import java.io.File
import java.lang.ProcessBuilder.Redirect
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.ui.IEditorPart
import org.eclipse.ui.IFileEditorInput
import org.eclipse.ui.PlatformUI

/**
 * @author sdo
 *
 */
class RaillsSimulationhandler extends AbstractHandler {
    
    var IEditorPart activeEditor
    val systemId = "de.cau.cs.kieler.railsl.netlist.sim.scade"
    var Process process
    var Process process2
    
    override Object execute(ExecutionEvent event) throws ExecutionException {
        if (process !== null) {
            process.destroy
            println("Destroyed last process")
        }
        if (process2 !== null) {
            process2.destroy
            println("Destroyed last process2")
        }
        
        // Get and save active editor
        var NullProgressMonitor monitor = new NullProgressMonitor();
        activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()
        activeEditor.doSave(monitor)
        
        var IFileEditorInput input = activeEditor.getEditorInput() as IFileEditorInput
        var IFile file = input.getFile();
        var IProject activeProject = file.getProject();
        var String activeProjectName = activeProject.getName();
        
        // compile model
        val eobject = ModelReaderUtil.readModelFromEditor(activeEditor)
        val context = Compile.createCompilationContext(systemId, eobject)
        var compContext = context.compile
        var ExecutableContainer executeableContainer = compContext.model as ExecutableContainer
        val processBuilder = executeableContainer.processBuilder
        
        processBuilder.redirectInput(Redirect.INHERIT)
//        process = processBuilder.start
        var fileName = file.name.replace(".", "-")
        
        process2 = Runtime.getRuntime().exec("./Executables/RailController", null,
            new File(ResourcesPlugin.getWorkspace().getRoot().getLocation().toString() +
            "/KIELER-Temp/" + "-" + activeProjectName + "-" + fileName + "/kieler-gen/simulation")
        );
        return null;
    }
    
}
