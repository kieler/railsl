package de.cau.cs.kieler.railsl.ui.commands

import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import de.cau.cs.kieler.railsl.processor.ScadeSimulationProcessor.RailScadeSiumlationExecutable
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.Status
import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.Files

/**
 * @author sdo, als
 * 
 */
class RaillsSimulationhandler extends RailStartHandler {

    static val charset = StandardCharsets.UTF_8;
    static val systemId = "de.cau.cs.kieler.railsl.netlist.sim.scade"
    static var Process gui
    static var Process controller
    static val obeserver = new Job("Simulation Observer") {

        override protected run(IProgressMonitor monitor) {
            synchronized(obeserver) {
                if (gui !== null && controller !== null && (!gui.alive || !controller.alive)) {
                    if (gui.alive) {
                        gui.destroy
                        println("Observer destroyed gui")
                    }
                    if (controller.alive) {
                        controller.destroy
                        println("Observer destroyed controller")
                    }
                }
            }
            schedule(1000);
            return Status.OK_STATUS;
        }
    }

    override Object execute(ExecutionEvent event) throws ExecutionException {
        synchronized(obeserver) {
            if (gui !== null && gui.alive) {
                gui.destroy
                println("Destroyed last gui")
            }
            if (controller !== null && controller.alive) {
                controller.destroy
                println("Destroyed last controller")
            }
    
            val exe = compile(systemId)
            val exeFolder = exe.file.parentFile
            val exeConfPath = new File(exeFolder, "railway.cnf").toPath
            val guiFolder = new File(exeFolder.parentFile, "GUI")
            val guiConfPath = new File(guiFolder, "modelgui.preferences").toPath
            
            // Set config
            val port = switch(System.getProperty("user.name")) {
                case "railway1": 2223
                case "railway2": 2224
                case "railway3": 2225
                case "railway4": 2226
                default: 2222
            }

            // exe conf
            var content = new String(Files.readAllBytes(exeConfPath), charset)
            content = content.replaceAll("GUIPORT = 2222", "GUIPORT = " + port)
            Files.write(exeConfPath, content.getBytes(charset))
            
            // gui conf
            content = new String(Files.readAllBytes(guiConfPath), charset)
            content = content.replaceAll("<entry key=\"port\">2222", "<entry key=\"port\">" + port)
            Files.write(guiConfPath, content.getBytes(charset))
            
            // start
            gui = (exe as RailScadeSiumlationExecutable).GUIProcessBuilder.start()
            controller = Runtime.getRuntime().exec("./" + exe.file.name, null, exe.file.parentFile)
        }
        obeserver.schedule()
        return null;
    }

}
