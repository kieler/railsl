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

import de.cau.cs.kieler.kicool.deploy.processor.AbstractSystemCompilerProcessor
import de.cau.cs.kieler.core.properties.IProperty
import de.cau.cs.kieler.core.properties.Property
import de.cau.cs.kieler.kicool.deploy.ProjectInfrastructure
import java.io.File

/**
 * @author stu121235
 *
 */
class CodeMoverProcessor extends AbstractSystemCompilerProcessor<Object, Object> {
    
    public static val IProperty<String> target = 
        new Property<String>("de.cau.cs.kieler.railsl.mover.target", "/")
    
    override getId() {
        return "de.cau.cs.kieler.railsl.deploy.codeMover"
    }
    
    override getName() {
        return "Generated Code Mover"
    }
    
    override process() {
        
        val infra = ProjectInfrastructure.getProjectInfrastructure(environment)
        val codeFiles = infra.sourceCodeFiles
        val targetString = environment.getProperty(target)?:"/"
        logger.println()
        logger.println("Moving source code files to " + targetString)
        
        val dir = infra.generatedCodeFolder
        if (dir === null) {
            logger.println("No generated code folder!")
        } else {
            for (file : codeFiles) {
                val parts = file.path.split("\\.")
                val ext = parts.get(parts.size - 1)
                ProjectInfrastructure.copyFile(file, new File(dir.absolutePath + targetString + "Controller." + ext), logger, true)
            }
        }
        logger.closeLog("railsl-codeMover.log").snapshot
        
    }
    
}