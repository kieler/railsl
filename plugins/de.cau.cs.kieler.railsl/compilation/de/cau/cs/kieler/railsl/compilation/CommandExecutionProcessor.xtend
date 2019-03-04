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
import java.util.List
import java.io.File

/**
 * @author stu121235
 *
 */
class CommandExecutionProcessor extends AbstractSystemCompilerProcessor<Object, Object> {
    
    public static val IProperty<String> command = 
        new Property<String>("de.cau.cs.kieler.railsl.command.com", "")
    
    public static val IProperty<String> dir =
        new Property<String>("de.cau.cs.kieler.railsl.command.dir", "")
    
    public static val IProperty<Boolean> waitForTerm =
        new Property<Boolean>("de.cau.cs.kieler.railsl.command.waitForTerm", true)
    
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
        val comString = environment.getProperty(command)?:""
        val List<String> com = comString.split(" ").toList
        val path = infra.generatedCodeFolder.absolutePath
        val file = new File(path + environment.getProperty(dir)?:"")
        if (environment.getProperty(waitForTerm)?:waitForTerm.^default) {
            com.invoke(file)        
        } else {
            com.invokeAsync(file)
        }
        
        logger.closeLog("railsl-command-execution.log").snapshot
        infra.refresh
        
    }
    
    def invokeAsync(List<String> command, File directory) {
        logger.println("Invoking command asynchronously: " + command.join(" "))
        val pb = createProcessBuilder(command, directory)
        
        try {
            pb.start
        } catch (Exception e) {
            logger.println("Error while invoking command")
            environment.errors.add("Error while invoking command")
        }
    }
    
}