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
package de.cau.cs.kieler.railsl.processor

import de.cau.cs.kieler.core.properties.IProperty
import de.cau.cs.kieler.core.properties.Property
import de.cau.cs.kieler.kicool.compilation.ExecutableContainer
import de.cau.cs.kieler.kicool.deploy.ProjectInfrastructure
import de.cau.cs.kieler.kicool.deploy.processor.AbstractSystemCompilerProcessor
import java.io.File

/**
 * @author als
 *
 */
class ScadeSimulationProcessor extends AbstractSystemCompilerProcessor<Object, ExecutableContainer> {
    
    public static val IProperty<String> FOLDER = 
        new Property<String>("de.cau.cs.kieler.railsl.compile.sim.scade.dir", "simulation")
        
    public static val IProperty<String> CONTROLLER = 
        new Property<String>("de.cau.cs.kieler.railsl.compile.sim.scade.controller", "RailController.c")
        
    static val EXE = "Executables/RailController"
    
    override getId() {
        return "de.cau.cs.kieler.railsl.compile.sim.scade"
    }
    
    override getName() {
        return "Compile SCADE Simulation"
    }
    
    override process() {
        
        val infra = ProjectInfrastructure.getProjectInfrastructure(environment)
        val base = infra.generatedCodeFolder
        val scade = new File(base, environment.getProperty(FOLDER))
        
        // Move sources
        logger.println("== Moving souce files ==")
        val dst = new File(scade, "RailwayControllerC")
        for (file : infra.sourceCodeFiles) {
            ProjectInfrastructure.copyFile(file, new File(dst, file.name), logger, true)
        }
        ProjectInfrastructure.copyFile(new File(base, environment.getProperty(CONTROLLER)), new File(dst, "RailController.c"), logger, true)
        
        logger.println
        logger.println("== Build Simulation ==")
        
        val make = newArrayList("make")
        make += "-f"
        make += "Makefile.make"
        make += EXE
        
        // Run make
        var success = make.invoke(scade)?:-1 == 0
        if (!success) {
            environment.errors.add("Make did not return success (exit value != 0)")
            logger.println("Compilation failed")
        }
        
        // Create model
        model = new RailScadeSiumlationExecutable(scade)
        
        logger.closeLog("railsl-scade.log").snapshot
        
    }
    
    static class RailScadeSiumlationExecutable extends ExecutableContainer {
        
        static var Process gui
        val File scade
    
        new(File file) {
            super(new File(file, EXE))
            scade = file
        }
        
        override getProcessBuilder() {
            startGUI();
            return super.processBuilder
        }
        
        def startGUI() {
            if (gui === null || !gui.alive) {
                val folder = new File(scade, "GUI")
                val jar = new File(folder, "modelgui-6b1.jar")
                var jarPath = jar.toString
                if (jarPath.contains(" ")) jarPath = "\"" + jarPath + "\""
                val pb = new ProcessBuilder("java", "-jar", jarPath)
                pb.directory(folder)
                gui = pb.start
            }
        }
        
    }
    
}
