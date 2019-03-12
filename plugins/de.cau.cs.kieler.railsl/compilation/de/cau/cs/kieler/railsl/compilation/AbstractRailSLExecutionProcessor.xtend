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
import java.util.List
import java.io.File

/**
 * @author stu121235
 *
 */
abstract class AbstractRailSLExecutionProcessor extends AbstractSystemCompilerProcessor<Object, Object> {
    
    def Process invokeAsync(List<String> command, File directory) {
        logger.println("Invoking command asynchronously: " + command.join(" "))
        val pb = createProcessBuilder(command, directory)
        
        try {
            val p = pb.start
            return p
        } catch (Exception e) {
            logger.println("Error while invoking command")
            environment.errors.add("Error while invoking command")
            return null
        }
    }
    
}