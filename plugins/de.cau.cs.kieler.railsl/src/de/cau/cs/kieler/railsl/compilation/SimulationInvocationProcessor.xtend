/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://rtsys.informatik.uni-kiel.de/kieler
 * 
 * Copyright ${year} by
 * + Kiel University
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 */
package de.cau.cs.kieler.railsl.compilation

import java.util.List
import java.io.File
import de.cau.cs.kieler.kicool.deploy.ProjectInfrastructure

/**
 * @author stu121235
 *
 */
class SimulationInvocationProcessor extends AbstractRailSLExecutionProcessor {
    
    static final List<String> SIM_COMMAND = "java -jar Executables/modelgui-6b1.jar".split(" ");
    static final List<String> CONTROLLER_COMMAND = "Executables/SampleController".split(" ")
    static final String EXECUTION_DIR = "resources/"    
    
    static Process lastSimP
    static Process lastControllerP
    
    override getId() {
        return "de.cau.cs.kieler.railsl.deploy.invokeSim"
    }
    
    override getName() {
        return "RailSL Simulation Invocator"
    }
    
    override process() {
        
        lastSimP?.destroy
        lastControllerP?.destroy
        
        // Setup project infrastructure
        val infra = ProjectInfrastructure.getProjectInfrastructure(environment)
        if (infra.generatedCodeFolder === null) {
            return
        } else {
            infra.log(logger)
        }
        val path = infra.generatedCodeFolder.absolutePath + "/" + EXECUTION_DIR
        val dir = new File(path)
        
        lastSimP = invokeAsync(SIM_COMMAND, dir)
        lastControllerP = invokeAsync(CONTROLLER_COMMAND, dir)
        
        logger.closeLog("railsl-simulation-invocation.log").snapshot
        
    }
    
}