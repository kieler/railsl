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
package de.cau.cs.kieler.railsl.ui.commands

import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.ui.handlers.HandlerUtil

/**
 * @author sdo
 *
 */
class RailslDeployHandler extends RailStartHandler {
    
    val systemId = "de.cau.cs.kieler.railsl.netlist.deploy"
    var Process process
    
    override Object execute(ExecutionEvent event) throws ExecutionException {
        if (process !== null) {
            process.destroy
            println("Destroyed last process")
        }
        var shell = HandlerUtil.getActiveWorkbenchWindow(event).getShell()
        var confirmation = MessageDialog.openConfirm(shell, "Ausführen auf der Modellbahn", "Soll das Programm wirklich auf der realen Modellbahn ausgeführt werden?");
        if (confirmation) {
            val exe = compile(systemId)
            if (exe !== null) {
                launch(exe)
            }
        }
        return null;
    }
    
}