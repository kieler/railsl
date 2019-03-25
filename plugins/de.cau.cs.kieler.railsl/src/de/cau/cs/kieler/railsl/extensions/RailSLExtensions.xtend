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
package de.cau.cs.kieler.railsl.extensions

import de.cau.cs.kieler.railsl.railSL.ConditionalLine
import de.cau.cs.kieler.railsl.railSL.ContactPosition
import de.cau.cs.kieler.railsl.railSL.ContactWaitStatement
import de.cau.cs.kieler.railsl.railSL.CrossingMode
import de.cau.cs.kieler.railsl.railSL.CrossingStatement
import de.cau.cs.kieler.railsl.railSL.LightMode
import de.cau.cs.kieler.railsl.railSL.LightStatement
import de.cau.cs.kieler.railsl.railSL.PointOrientation
import de.cau.cs.kieler.railsl.railSL.PointStatement
import de.cau.cs.kieler.railsl.railSL.TrackStatement

/**
 * @author stu121235
 *
 */
class RailSLExtensions {
    
    public static val SPEED_STOP = 0
   
    /**
     * The speed value for slow driving
     */
    public static val SPEED_SLOW = 45;
    
    /**
     * The speed value for full speed driving
     */
    public static val SPEED_FULL = 120;
    
    /*****************************************************************************************
     * H E L P E R   M E T H O D S ***********************************************************
     *****************************************************************************************/

    /**
     * Helper method to determine the light state
     */
    def int parseLightMode(LightStatement lStatement) {
        if (lStatement.state.equals(LightMode.ON)) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Helper method to determine the setting for a point
     */
    def int parsePointSetting(PointStatement spStatement) {
        if (spStatement.orientation.equals(PointOrientation.STRAIGHT)) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * Helper method to determine the speed to which a track segment should be set.
     */
    def int parseSpeed(TrackStatement stStatement) {
        switch (stStatement.speed) {
            case SLOW: {
                return SPEED_SLOW;
            }
            case FULL: {
                return SPEED_FULL;
            }
        	default: {
                return SPEED_STOP;
        	}
        }
    }

    /**
     * Helper method to determine the direction of travel.
     */
    def parseDirection(TrackStatement stStatement) {
        if (stStatement.reverse) {
            return 2;
        } else {
            return 1;
        }
    }

    def boolean parseCrossingSetting(CrossingStatement cStatement) {
        return cStatement.mode.equals(CrossingMode.OPEN)
    }

    def int parseContactIndex(ContactWaitStatement statement) {
        if(statement.contact.equals(ContactPosition.FIRST)) 0 else 1
    }

    def int parseContactIndex(ConditionalLine line) {
        if(line.contact.equals(ContactPosition.FIRST)) 0 else 1
    }    
}