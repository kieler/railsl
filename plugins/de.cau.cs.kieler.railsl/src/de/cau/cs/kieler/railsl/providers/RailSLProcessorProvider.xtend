/*
 * KIELER - Kiel Integrated Environment for Layout Eclipse RichClient
 *
 * http://rtsys.informatik.uni-kiel.de/kieler
 * 
 * Copyright 2019 by
 * + Kiel University
 *   + Department of Computer Science
 *     + Real-Time and Embedded Systems Group
 * 
 * This code is provided under the terms of the Eclipse Public License (EPL).
 */
package de.cau.cs.kieler.railsl.providers

import de.cau.cs.kieler.kicool.registration.IProcessorProvider

/**
 * Provider to make processors available to KiCool.
 * 
 * @author als
 */
class RailSLProcessorProvider implements IProcessorProvider {
    
    override getProcessors() {
        #[
            de.cau.cs.kieler.railsl.processor.RailwayAPIProcessor,
            de.cau.cs.kieler.railsl.processor.ScadeSimulationProcessor,
            de.cau.cs.kieler.railsl.compilation.RailSLTransformation
        ]
    }
    
}
