package de.cau.cs.kieler.railsl.ui.commands

import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import de.cau.cs.kieler.railsl.processor.ScadeSimulationProcessor.RailScadeSiumlationExecutable
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.Status

/**
 * @author sdo, als
 * 
 */
class RaillsSimulationhandler extends RailStartHandler {

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
            gui = (exe as RailScadeSiumlationExecutable).GUIProcessBuilder.start()
            controller = Runtime.getRuntime().exec("./" + exe.file.name, null, exe.file.parentFile)
        }
        obeserver.schedule()
        return null;
    }

}
