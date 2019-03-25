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
class RailwayAPIProcessor extends AbstractSystemCompilerProcessor<Object, ExecutableContainer> {
    
    public static val IProperty<String> FOLDER = 
        new Property<String>("de.cau.cs.kieler.railsl.railway.api.dir", "railway")
    
    override getId() {
        return "de.cau.cs.kieler.railsl.railway.api"
    }
    
    override getName() {
        return "Compile Railway API"
    }
    
    override process() {
        
        val infra = ProjectInfrastructure.getProjectInfrastructure(environment)
        val base = infra.generatedCodeFolder
        val api = new File(base, environment.getProperty(FOLDER))
        
        // Move sources
//        logger.println("== Moving souce files ==")
//        val dst = new File(scade, "RailwayControllerC")
//        for (file : infra.sourceCodeFiles) {
//            ProjectInfrastructure.copyFile(file, new File(dst, file.name), logger, true)
//        }
//        ProjectInfrastructure.copyFile(new File(base, environment.getProperty(CONTROLLER)), new File(dst, "RailController.c"), logger, true)
        
        logger.println
        logger.println("== Build API ==")
        
        val make = newArrayList("make")
        make += "-f"
        make += "Makefile.make"
        
        // Run make
        var success = make.invoke(api)?:-1 == 0
        if (!success) {
            environment.errors.add("Make did not return success (exit value != 0)")
            logger.println("Compilation failed")
        }
        
        logger.closeLog("railsl-api.log").snapshot
        
    }
    
}
