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
import de.cau.cs.kieler.kicool.deploy.ProjectInfrastructure
import de.cau.cs.kieler.core.properties.IProperty
import de.cau.cs.kieler.core.properties.Property

/**
 * @author stu121235
 *
 */
class CommandExecutionProcessor extends AbstractSystemCompilerProcessor<Object, Object> {
    
    public static val IProperty<String> command = 
        new Property<String>("de.cau.cs.kieler.railsl.command.com", "make -f resources/Makefile.make")
    
    override getId() {
        return "de.cau.cs.kieler.railsl.deploy.command"
    }
    
    override getName() {
        return "Command Executer"
    }
    
    override process() {
        
        // Setup project infrastructure
        val infra = ProjectInfrastructure.getProjectInfrastructure(environment)
        if (infra.generatedCodeFolder === null) {
            return
        } else {
            infra.log(logger)
        }
        val com = newArrayList(environment.getProperty(command)?:command.^default)
        logger.println(com)
        com.invoke(infra.generatedCodeFolder)
        
        logger.closeLog("railsl-command-execution.log")
        infra.refresh
        
    }
    
}