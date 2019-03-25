/*
 * Railway 4.0 Client Protocol - High-Level Railway Control
 * Copyright (c) 2017 Kiel University
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

#ifndef railway40_railway_h
#define railway40_railway_h

// Include stdlib for malloc
#include <stdlib.h>
// Include common type delcarations
#include "types.h"
// Include railPi management functions
#include "railPi.h"



/**********************************************************
 *  ######  ##    ##  ######  ######## ######## ##     ## *
 * ##    ##  ##  ##  ##    ##    ##    ##       ###   ### *
 * ##         ####   ##          ##    ##       #### #### *
 *  ######     ##     ######     ##    ######   ## ### ## *
 *       ##    ##          ##    ##    ##       ##     ## *
 * ##    ##    ##    ##    ##    ##    ##       ##     ## *
 *  ######     ##     ######     ##    ######## ##     ## *
 **********************************************************/

/**
 * Initialize the control structure to communicate with a given railway.
 *
 * @param hardware
 *      The hardware description of the system.
 * @return The control structure for railway control.
 */
railway_t *railway_initsystem(stateRailway_t *hardware);

/**
 * Open all links to the railwayDs, required to operate the system,
 * with one function call. Also requests the periphery config from
 * the railwayD and stores the addressing information in the railway system.
 *
 * @param railway
 *      The initialized railway system.
 * @param hostformat
 *      printf string to use as the hostname to connect to.
 * @param portformat
 *      printf string to use as the port to connect to.
 * @return 0 on success, in case of a failure it will print an error message,
 *      return -1/errno and close all previously opened links.
 */
int railway_openlinks(railway_t *railway, char *hostformat, char *portformat);

// TODO: Legacy openlinks_udp function added for girlsday tool
int railway_openlinks_udp(railway_t *railway, char *nodeName, char *device);

/**
 * Start the system (and the control thread) after all nodelinks
 * have been registered.
 *
 * @param railway
 *      The initialized railway system.
 * @return 0 on success and -1/errno on failure.
 */
// TODO Legacy parameters added
int railway_startcontrol(railway_t *railway, int lower, int upper);

/**
 * Stop the system (and the control thread), send disconnect commands to all
 * nodes and reset them. Be careful with this option: if the the system stops
 * uncontrolled, there might be trains standing on points. A reset (or restart)
 * in this situation might force such trains off the track.
 *
 * @param railway
 *      The initialized railway system.
 * @return 0 on success and -1/errno on failure.
 */
// TODO Legacy parameters added
int railway_stopcontrol(railway_t *railway, int reset);

/**
 * Test if the system is alive. The system may shut itself down if there are
 * too many communication errors. An application should poll this flag in
 * regular intervals and react if the system is not alive any more.
 *
 * @param railway
 *      The initialized railway system.
 * @return 1 if the system is alive, 0 otherwise.
 */
int railway_alive(railway_t *railway);

/**
 * Close all nodelinks that are registered with the control system. The system
 * must be stopped for this to work, all successfully closed nodelinks will be
 * unregistered (set to NULL).
 *
 * @param railway
 *      The initialized railway system.
 * @return 0 on success and -1 on errors, errno is set by the last registered error.
 */
int railway_closelinks(railway_t *railway);

/* Destroy the control structure, free used memory. This function may only be
 * called if the system is not running. Nodelinks are not closed, this must be
 * done prior to this call by railway_closelinks or at any other time by the
 * application itself.
 *
 * @param railway
 *      The initialized railway system.
 * @return 0 on success and -1 on errors, errno is set by the last registered error.
 */
int railway_donesystem(railway_t *railway);



/***************************************************************************************
 * ##     ## ####  ######   ##     ##    ##       ######## ##     ## ######## ##       *
 * ##     ##  ##  ##    ##  ##     ##    ##       ##       ##     ## ##       ##       *
 * ##     ##  ##  ##        ##     ##    ##       ##       ##     ## ##       ##       *
 * #########  ##  ##   #### #########    ##       ######   ##     ## ######   ##       *
 * ##     ##  ##  ##    ##  ##     ##    ##       ##        ##   ##  ##       ##       *
 * ##     ##  ##  ##    ##  ##     ##    ##       ##         ## ##   ##       ##       *
 * ##     ## ####  ######   ##     ##    ######## ########    ###    ######## ######## *
 ***************************************************************************************/

// Contacts
#define NONE   0
#define FWD    1
#define REV    2
#define UNI    3

/**
 * Query if a specific contact exists.
 *
 * @param railway
 *       The railway system to work on.
 * @param block
 *       The track segment of the contact.
 * @param contact
 *       The number of the contact inside the track segment.
 *       In regards to the main travel direction, 0 is at the beginning
 *       of the segment and 1 is at the endof the segment.
 * @return 1 if the specified contact exists, 0 otherwise.
 */
int contactexists(railway_t *railway, int block, int contact);

/**
 * Read the status of one contact pair in the system. The call can return one of the constants
 * NONE - contact not triggered
 * FWD  - a train has passed the contact while driving forward
 * REV  - a train has passed the contact while driving in reverse direction
 * UNI  - contact was triggered, but the direction could not be detected (caused by
 *        unidirectional sensors, reed contact failures and too long polling intervals)
 *
 * @param railway
 *       The railway system to work on.
 * @param block
 *       The track segment of the contact.
 * @param contact
 *       The number of the contact inside the track segment.
 *       In regards to the main travel direction, 0 is at the beginning
 *       of the segment and 1 is at the endof the segment.
 * @param clear
 *       Flag to clear an event from the buffer after reading. 0 will keep the events in the
 *       buffer, a non-zero value will remove the event after reading.
 * @return One of NONE, FWD, REV or UNI as described above.
 */
unsigned getcontact(railway_t *railway, int block, int contact, int clear);

/**
 * Remove all contact events from the buffer for a given contact pair.
 *
 * @param railway
 *       The railway system to work on.
 * @param block
 *       The track segment of the contact.
 * @param contact
 *       The number of the contact inside the track segment.
 *       In regards to the main travel direction, 0 is at the beginning
 *       of the segment and 1 is at the endof the segment.
 */
void clearcontact(railway_t *railway, int block, int contact);


// Tracks
#define TOFF 0
#define TFWD 1
#define TREV 2

/**
 * Set the state of one track driver.
 *
 * @param railway
 *       The railway system to work on.
 * @param block
 *       The track segment to set.
 * @param mode
 *       Mode of the track driver, one of TOFF, TFWD, TREV.
 * @param pwm
 *       Speed setting, given as a pwm value between 0 and 255.
 */
void settrack(railway_t *railway, int track, unsigned mode, unsigned pwm);

/**
 * Get the state of one track driver.
 *
 * @param railway
 *       The railway system to work on.
 * @param block
 *       The track segment to set.
 * @param mode
 *       Pointer for returning the mode of the track driver, one of TOFF, TFWD, TREV.
 * @param pwm
 *       Pointer for returning the speed setting, given as a pwm value between 0 and 255.
 */
void gettrack(railway_t *railway, int track, unsigned *mode, unsigned *pwm);


// Signals
#define RED    4
#define YELLOW 2
#define GREEN  1

/**
 * Query if a specific block signal exists.
 *
 * @param railway
 *       The railway system to work on.
 * @param block
 *       The track segment of the signal.
 * @param signaln
 *       The number of the signal inside the track segment.
 *       In regards to the main travel direction, 0 is at the beginning
 *       of the segment (facing the reverse direction) and 1 is at the end
 *       of the segment (facing in the main direction).
 * @return 1 if the signal exists, 0 otherwise.
 */
int signalexists(railway_t *railway, int block, int signaln);

/**
 * Sets a block signal to a given color combination. Previous versions of the
 * API allowed for wildcards. This is currently not supported.
 *
 * @param railway
 *       The railway system to work on.
 * @param block
 *       The track segment of the signal.
 * @param signaln
 *       The number of the signal inside the track segment.
 *       In regards to the main travel direction, 0 is at the beginning
 *       of the segment (facing the reverse direction) and 1 is at the end
 *       of the segment (facing in the main direction).
 * @param lights
 *       bitwise OR of the constants RED, YELLOW and GREEN
 */
void setsignal(railway_t *railway, int block, int signaln, int lights);

/**
 * Read the current color combination of a signal.
 *
 * @param railway
 *       The railway system to work on.
 * @param block
 *       The track segment of the signal.
 * @param signaln
 *       The number of the signal inside the track segment.
 *       In regards to the main travel direction, 0 is at the beginning
 *       of the segment (facing the reverse direction) and 1 is at the end
 *       of the segment (facing in the main direction).
 * @return The bitwise OR combination of the constants RED, YELLOW and GREEN.
 */
unsigned getsignal(railway_t *railway, int block, int signaln);


// Points
#define STRAIGHT 0
#define BRANCH   1

/**
 * Set the state of one point.
 *
 * @param railway
 *       The railway system to work on.
 * @param point
 *       The point number.
 * @param state
 *       The new state of the point. One of STRAIGHT or BRANCH.
 */
void setpoint(railway_t *railway, int point, int state);

/**
 * Get the state of one point.
 *
 * @param railway
 *       The railway system to work on.
 * @param point
 *       The point number.
 * @return The current state of the point. One of STRAIGHT or BRANCH.
 */
int getpoint(railway_t *railway, int point);


// Lights
#define OFF 0
#define ON  1

/**
 * Set the state of one light.
 *
 * @param railway
 *       The railway system to work on.
 * @param light
 *       The light number.
 * @param state
 *       The new state. One of OFF or ON.
 */
void setlight(railway_t *railway, int light, int state);

/**
 * Get the state of one light.
 *
 * @param railway
 *       The railway system to work on.
 * @param light
 *       The light number.
 * @return One of OFF or ON.
 */
int getlight(railway_t *railway, int light);


// Crossings
#define UP    0
#define DOWN  1

/**
 * Set one traffic lights at a crossing.
 *
 * @param railway
 *       The railway system to work on.
 * @param signaln
 *       The number of the crossing signal.
 * @param lights
 *       The new state. Bitwise OR of the constants RED, YELLOW and GREEN.
 */
void setgatesignal(railway_t *railway, int signaln, int lights);

/**
 * Get the status of one traffic light at a crossing.
 *
 * @param railway
 *       The railway system to work on.
 * @param signaln
 *       The number of the crossing signal.
 * @return The state of the crossing signal. Bitwise OR of the constants RED, YELLOW and GREEN.
 */
unsigned getgatesignal(railway_t *railway, int signaln);

/**
 * Set the state of one crossing gate.
 *
 * @param railway
 *       The railway system to work on.
 * @param gate
 *       The number of the gate.
 * @param state
 *       The new state. One of UP or DOWN.
 */
void setgate(railway_t *railway, int gate, int state);

/**
 * Get the state of one crossing gate.
 *
 * @param railway
 *       The railway system to work on.
 * @param gate
 *       The number of the gate.
 * @return The state. One of UP or DOWN.
 */
int getgate(railway_t *railway, int gate);

/**
 * Set the state of one bells.
 *
 * @param railway
 *       The railway system to work on.
 * @param bell
 *       The number of the bell.
 * @param state
 *       The new state. One of OFF or ON.
 */
void setbell(railway_t *railway, int bell, int state);

/**
 * Get the state of one bells.
 *
 * @param railway
 *       The railway system to work on.
 * @param bell
 *       The number of the bell.
 * @return The state. One of OFF or ON.
 */
int getbell(railway_t *railway, int bell);

/**
 * Sensors at the gates of crossings can detect if the gate is open or the
 * boom is down, and they are used exactly like the reed contact
 * sensors. Whenever the gate is completely closed, the sensor returns a FWD
 * reading. If the boom leaves this position, the sensor reports REV. Keep in
 * mind that the gate sensors are filtered like contacts and ignore events
 * that happen too fast. So the gate must stay open or closed for a short
 * period of time before new events can be detected.
 *
 * @param railway
 *       The railway system to work on.
 * @param gatesensor
 *       The number of the gate.
 * @param clear
 *       Flag to clear an event from the buffer after reading. 0 will keep the events in the
 *       buffer, a non-zero value will remove the event after reading.
 * @return One of NONE, FWD, REV or UNI as described above.
 */
unsigned getgatesensor(railway_t *railway, int gatesensor, int clear);

/**
 * Clears all events from the buffer of the gate sensor.
 *
 * @param railway
 *       The railway system to work on.
 * @param gatesensor
 *       The number of the gate.
 */
void cleargatesensor(railway_t *railway, int gatesensor);
#endif
