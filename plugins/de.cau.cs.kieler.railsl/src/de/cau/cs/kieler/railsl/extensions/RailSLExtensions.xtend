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

import de.cau.cs.kieler.railsl.railSL.LightStatement
import de.cau.cs.kieler.railsl.railSL.CrossingStatement
import de.cau.cs.kieler.railsl.railSL.ContactWaitStatement
import de.cau.cs.kieler.railsl.railSL.ConditionalLine
import de.cau.cs.kieler.railsl.railSL.TrackStatement
import de.cau.cs.kieler.railsl.railSL.PointStatement
import java.util.ArrayList

/**
 * @author stu121235
 *
 */
class RailSLExtensions {
   
    /**
     * The speed value for slow driving
     */
    public static val SPEED_SLOW = 45;
    
    /**
     * The speed value for full speed driving
     */
    public static val SPEED_FULL = 120;
    
    
    /**
     * All the track name constants
     */
    public static val ArrayList<String> constants = newArrayList("IC_JCT_0", "IC_LN_0", "IC_LN_1", "IC_LN_2", "IC_LN_3", "IC_LN_4", "IC_LN_5", "IC_ST_0",
        "IC_ST_1", "IC_ST_2", "IC_ST_3", "IC_ST_4", "IO_LN_0", "IO_LN_1", "IO_LN_2", "KH_LN_0", "KH_LN_1", "KH_LN_2",
        "KH_LN_3", "KH_LN_4", "KH_LN_5", "KH_LN_6", "KH_LN_7", "KH_LN_8", "KH_ST_0", "KH_ST_1", "KH_ST_2", "KH_ST_3",
        "KH_ST_4", "KH_ST_5", "KH_ST_6", "KIO_LN_0", "KIO_LN_1", "OC_JCT_0", "OC_LN_0", "OC_LN_1", "OC_LN_2", "OC_LN_3",
        "OC_LN_4", "OC_LN_5", "OC_ST_0", "OC_ST_1", "OC_ST_2", "OC_ST_3", "OC_ST_4", "OI_LN_0", "OI_LN_1", "OI_LN_2")
    
    /*****************************************************************************************
     * H E L P E R   M E T H O D S ***********************************************************
     *****************************************************************************************/

    /**
     * Helper method to determine the light state
     */
    def int parseLightMode(LightStatement lStatement) {
        if (lStatement.state.equals("on")) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Helper method to determine the setting for a point
     */
    def int parsePointSetting(PointStatement spStatement) {
        if (spStatement.orientation.equals("straight")) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * Helper method to determine the speed to which a track segment should be set.
     */
    def int parseSpeed(TrackStatement stStatement) {
        if (stStatement.mode.contains("stop")) {
            return 0;
        } else if (stStatement.mode.contains("slow")) {
            return SPEED_SLOW;
        } else {
            return SPEED_FULL;
        }
    }

    /**
     * Helper method to determine the direction of travel.
     */
    def parseDirection(TrackStatement stStatement) {
        if (stStatement.mode.contains("reverse")) {
            return 2;
        } else {
            return 1;
        }
    }

    def boolean parseCrossingSetting(CrossingStatement cStatement) {
        return cStatement.mode.equals("Open")
    }

    def int parseContactIndex(ContactWaitStatement statement) {
        if(statement.contact.equals("first")) 0 else 1
    }

    def int parseContactIndex(ConditionalLine line) {
        if(line.contact.equals("first")) 0 else 1
    }

    /**
     * Helper method to translate track segment names to integers.
     * Defined according to the <Railway.h> header file.
     */
    def int parseTrackSegment(String string) {
        return switch (string) {
            case "IC_JCT_0": 0
            case "IC_LN_0": 1
            case "IC_LN_1": 2
            case "IC_LN_2": 3
            case "IC_LN_3": 4
            case "IC_LN_4": 5
            case "IC_LN_5": 6
            case "IC_ST_0": 7
            case "IC_ST_1": 8
            case "IC_ST_2": 9
            case "IC_ST_3": 10
            case "IC_ST_4": 11
            case "IO_LN_0": 12
            case "IO_LN_1": 13
            case "IO_LN_2": 14
            case "KH_LN_0": 15
            case "KH_LN_1": 16
            case "KH_LN_2": 17
            case "KH_LN_3": 18
            case "KH_LN_4": 19
            case "KH_LN_5": 20
            case "KH_LN_6": 21
            case "KH_LN_7": 22
            case "KH_LN_8": 23
            case "KH_ST_0": 24
            case "KH_ST_1": 25
            case "KH_ST_2": 26
            case "KH_ST_3": 27
            case "KH_ST_4": 28
            case "KH_ST_5": 29
            case "KH_ST_6": 30
            case "KIO_LN_0": 31
            case "KIO_LN_1": 32
            case "OC_JCT_0": 33
            case "OC_LN_0": 34
            case "OC_LN_1": 35
            case "OC_LN_2": 36
            case "OC_LN_3": 37
            case "OC_LN_4": 38
            case "OC_LN_5": 39
            case "OC_ST_0": 40
            case "OC_ST_1": 41
            case "OC_ST_2": 42
            case "OC_ST_3": 43
            case "OC_ST_4": 44
            case "OI_LN_0": 45
            case "OI_LN_1": 46
            case "OI_LN_2": 47
            default: -1
        };
    }
    
}