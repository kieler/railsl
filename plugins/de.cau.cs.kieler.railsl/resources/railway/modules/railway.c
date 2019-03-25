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

#include "railway.h"

#define HOSTLENGTH 256
#define PORTLENGTH 6

/**
 * Comparison function for signals, to be used in qsort()
 */
int compareSignals(const void *vSigA, const void *vSigB) {
  const stateSignal_t *sigA = *(stateSignal_t **) vSigA;
  const stateSignal_t *sigB = *(stateSignal_t **) vSigB;

  if (sigA->block < sigB->block) return -1;
  if (sigA->block > sigB->block) return 1;

  return sigA->dir - sigB->dir;
}

/**
 * Comparison function for contacts, to be used in qsort()
 */
int compareContacts(const void *vContactA, const void *vContactB) {
  const stateContact_t *contactA = *(stateContact_t **) vContactA;
  const stateContact_t *contactB = *(stateContact_t **) vContactB;
  fflush(stdout);

  if (contactA->block < contactB->block) {
    return -1;
  }
  if (contactA->block > contactB->block){
    return 1;
  } 

  return contactA->number - contactB->number;
}

/**
 * Initialize the control structure to communicate with a given railway.
 *
 * @param hardware
 *      The hardware description of the system.
 * @return The control structure for railway control.
 */
railway_t *railway_initsystem(stateRailway_t *hardware) {
  /*
   * What do I need to do here?
   * - I get passed a hardware definition.
   * - The hardware definiton has enough space for all the peripherals.
   * - The hardware definition knows how many railPis I need for the system.
   * - So I need to create enough railpi wrappers for the raspis!
   * - Do I also need to create the concrete structs for all the peripherals?
   * - No! Because I need to get the data from the raspis first, so that I
   *   can synchronize the objects for the railway state and the railpi.
   * - But do I need to do something else here? No idea!
   * - For now just get started with what we have.
   */

  // Create a wrapper struct to return later
  railway_t *railSystem = (railway_t*) malloc(sizeof(railway_t));

  // Store the hardware description in the result wrapper
  railSystem->hardware = hardware;

  // Grab the number of railPi handlers from the hardware description
  unsigned int numRailPis = hardware->numRailPis;
  // Store the number of railPis in the wrapper
  railSystem->numRailPis = numRailPis;

  // Create enough space for an array of railPi wrappers
  stateRailPi_t **railPi_ts = (stateRailPi_t**) malloc(sizeof(stateRailPi_t*) * numRailPis);
  // Store the array in the wrapper
  railSystem->railPis = railPi_ts;

  // Create a railPi wrapper for each railPi
  for (unsigned int p = 0; p < numRailPis; ++p) {
    stateRailPi_t *pi = (stateRailPi_t*) malloc(sizeof(stateRailPi_t));
    pi->railPiNumber = p;
    // Store the wrapper in the array
    railPi_ts[p] = pi;
  }

  // That's it for now, I hope
  return railSystem;
}

/**
 * Open all links to the railwayDs, required to operate the system,
 * with one function call. Also requests the periphery config from
 * the railwayD and stores the addressing information in the railway system.
 *
 * @param railway
 *      The initialized railway system.
 * @param hostformat
 *      printf string to use as the hostname to connect to. 
 *      The number of the railPi will be inserted in the string if a printf 
 *      placeholder is given.
 * @param portformat
 *      printf string to use as the port to connect to.
 *      The number of the railPi will be inserted in the string if a printf 
 *      placeholder is given.
 * @return 0 on success, in case of a failure it will print an error message,
 *      return -1/errno and close all previously opened links.
 */
int railway_openlinks(railway_t *railway, char *hostformat, char *portformat) {
  /*
   * What do I need to do here?
   * - I get a railway system.
   * - In the railway system I have wrappers for the number of railPis
   * - I need to:
   *   - Open a socket to each railPi
   *   - Request the peripheral config from the railPi
   *   - Create perihpheral wrappers for all components
   *   - Store the periphery in the railway system as well as the railPi wrapper
   */

  // Grad the number of railPis for comfort
  unsigned int numRailPis = railway->numRailPis;

  // Process each railPi individually
  for (unsigned int p = 0; p < numRailPis; ++p) {
    // Prepare the hostname from given string
    char hostStr[HOSTLENGTH];
    snprintf(hostStr, HOSTLENGTH, hostformat, p);

    // Prepare the port from given string
    char portStr[PORTLENGTH];
    snprintf(portStr, PORTLENGTH, portformat, p);

    // Connect to the pi
    railPi_connect(railway->railPis[p], hostStr, portStr);
    // Import periphery config from the pi and store it
    railPi_importPeriphery(railway->railPis[p], railway->hardware);
  }
  // Some wrappers will not be sorted after import, sort them now
  qsort(railway->hardware->signals, railway->hardware->numSignals,
    sizeof(stateSignal_t *), compareSignals);
  qsort(railway->hardware->contacts, railway->hardware->numContacts,
    sizeof(stateContact_t *), compareContacts);

  return 0;
}
// TODO: Legacy openlinks_udp function added for girlsday tool
int railway_openlinks_udp(railway_t *railway, char *nodeName, char *device) {
  return railway_openlinks(railway, "railway.rtsys.informatik.uni-kiel.de", "2001%i");
}

/**
 * Start the system (and the control thread) after all railPis
 * have been registered.
 *
 * @param railway
 *      The initialized railway system.
 * @return 0 on success and -1/errno on failure.
 */
int railway_startcontrol(railway_t *railway, int lower, int upper) {
  // What is needed here?
  // - Create a thread for each railPi to handle the regular update and polling
  // - Connect all railPis
  for (int i = 0; i < railway->numRailPis; ++i) {
    railPi_startCommThread(railway->railPis[i]);
  }

  return 0;
}

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
int railway_stopcontrol(railway_t *railway, int reset) {
  // Just shut it all down
  for (int i = 0; i < railway->numRailPis; ++i) {
    railPi_stopCommThread(railway->railPis[i]);
  }

  return 0;
}

/**
 * Test if the system is alive. The system may shut itself down if there are
 * too many communication errors. An application should poll this flag in
 * regular intervals and react if the system is not alive any more.
 *
 * @param railway
 *      The initialized railway system.
 * @return 1 if the system is alive, 0 otherwise.
 */
int railway_alive(railway_t *railway) {
  // TODO: Implement this!
  return 1;
}

/**
 * Close all nodelinks that are registered with the control system. The system
 * must be stopped for this to work, all successfully closed nodelinks will be
 * unregistered (set to NULL).
 *
 * @param railway
 *      The initialized railway system.
 * @return 0 on success and -1 on errors, errno is set by the last registered error.
 */
int railway_closelinks(railway_t *railway) {
  // Again, what is needed here?
  // * We are going to kill the communication with the railwayD.
  // * We could do an disconnect, just to be sure, 
  //   but usually the threads should deal with this.
  // * So just close the socket and be done with it?
  // * We probably want to free some memory
  for (int i = 0; i < railway->numRailPis; ++i) {
    railPi_disconnect(railway->railPis[i]);
    railPi_freePeriphery(railway->railPis[i]);
  }

  return 0;
}

/* Destroy the control structure, free used memory. This function may only be
 * called if the system is not running. Nodelinks are not closed, this must be
 * done prior to this call by railway_closelinks or at any other time by the
 * application itself.
 *
 * @param railway
 *      The initialized railway system.
 * @return 0 on success and -1 on errors, errno is set by the last registered error.
 */
int railway_donesystem(railway_t *railway) {
  // Free all railPi wrappers
  for (int i = 0; i < railway->numRailPis; ++i) {
    free(railway->railPis[i]);
  }
  free(railway->railPis);

  // The hardware is not free'd but all references are cleaned
  // The hardware wrappers were already cleaned when disconnecting the railPis.
  for (int i = 0; i < railway->hardware->numTracks; ++i) {
    railway->hardware->tracks[i] = NULL;
  }
  for (int i = 0; i < railway->hardware->numPoints; ++i) {
    railway->hardware->points[i] = NULL;
  }
  for (int i = 0; i < railway->hardware->numLights; ++i) {
    railway->hardware->lights[i] = NULL;
  }
  for (int i = 0; i < railway->hardware->numSignals; ++i) {
    railway->hardware->signals[i] = NULL;
  }
  for (int i = 0; i < railway->hardware->numContacts; ++i) {
    railway->hardware->contacts[i] = NULL;
  }
  for (int i = 0; i < railway->hardware->numGates; ++i) {
    railway->hardware->gates[i] = NULL;
  }
  for (int i = 0; i < railway->hardware->numGateSensors; ++i) {
    railway->hardware->gateSensors[i] = NULL;
  }
  for (int i = 0; i < railway->hardware->numGatesignals; ++i) {
    railway->hardware->gateSignals[i] = NULL;
  }
  for (int i = 0; i < railway->hardware->numBells; ++i) {
    railway->hardware->bells[i] = NULL;
  }

  // Free the main wrapper
  free(railway);

  return 0;
}

// ##     ## ####  ######   ##     ##    ##       ######## ##     ## ######## ##
// ##     ##  ##  ##    ##  ##     ##    ##       ##       ##     ## ##       ##
// ##     ##  ##  ##        ##     ##    ##       ##       ##     ## ##       ##
// #########  ##  ##   #### #########    ##       ######   ##     ## ######   ##
// ##     ##  ##  ##    ##  ##     ##    ##       ##        ##   ##  ##       ##
// ##     ##  ##  ##    ##  ##     ##    ##       ##         ## ##   ##       ##
// ##     ## ####  ######   ##     ##    ######## ########    ###    ######## ########

/**
 * Internal helper to find a contact using binary search
 */
stateContact_t *findContactByNumber(railway_t *railway, int block, int number) {
  stateContact_t comp = {.block = block, .number = number};
  stateContact_t *compP = &comp;
  // fprintf(stdout, "Invoking binary search for contact (%i,%i)\n", compP->block, compP->number);
  void *res = bsearch(&compP, railway->hardware->contacts,
    railway->hardware->numContacts, sizeof(stateContact_t *), compareContacts);
  return res == NULL ? NULL : *(stateContact_t **) res;
}

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
int contactexists(railway_t *railway, int block, int contact) {
  // fprintf(stdout, "Searching for contact (%i,%i)\n", block, contact);
  return findContactByNumber(railway, block, contact) != NULL;
}

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
unsigned getcontact(railway_t *railway, int block, int contact, int clear) {
  // Find the contact in the list
  stateContact_t *c = findContactByNumber(railway, block, contact);
  if (c != NULL) {
    if (c->numEvents != c->numHandledEvents) {
      unsigned lastType = c->lastEventType;
      if (clear) {
        // Mark one event as handled and clear type
        c->numHandledEvents = (c->numHandledEvents + 1) % 4;
        c->lastEventType = UNI;
      }

      return lastType;
    }
  }

  // No contact or no events
  return NONE;
}

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
void clearcontact(railway_t *railway, int block, int contact) {
  // Find the contact in the list
  stateContact_t *c = findContactByNumber(railway, block, contact);
  if (c != NULL) {
    c->numHandledEvents = c->numEvents;
    c->lastEventType = UNI;
  }
}

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
void settrack(railway_t *railway, int track, unsigned mode, unsigned pwm) {
  // Input validation
  if (track < 0 || track >= railway->hardware->numTracks) {
    // Return immediately if no valid track selected
    return;
  }
  if (mode != TOFF && mode != TFWD && mode != TREV) {
    // Return immediately if no valid mode selected
    return;
  }
  // TODO Doubled assigned speed for legacy girlsday software
  if (pwm > 127) {
    // Clamp pwm to maximum of 255;
    pwm = 255;
  } else {
    pwm = 2 * pwm;
  }
  // Grab hardware and set values directly
  railway->hardware->tracks[track]->direction = mode;
  railway->hardware->tracks[track]->pwm = pwm;
}

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
void gettrack(railway_t *railway, int track, unsigned *mode, unsigned *pwm) {
  // Input validation
  if (track < 0 || track >= railway->hardware->numTracks) {
    // Return immediately if no valid track selected
    return;
  }

  // Grab hardware and write values to pointers
  *mode = railway->hardware->tracks[track]->direction;
  // TODO Doubled assigned speed for legacy girlsday software
  *pwm = 2 * railway->hardware->tracks[track]->pwm;
}


/**
 * Internal helper to find a contact using binary search
 */
stateSignal_t *findSignalByNumber(railway_t *railway, int block, int signaln) {
  stateSignal_t comp = {.block = block, .dir = signaln};
  stateSignal_t *compP = &comp;
  void *res = bsearch(&compP, railway->hardware->signals, 
    railway->hardware->numSignals, sizeof(stateSignal_t *), compareSignals);
  return res == NULL ? NULL : *(stateSignal_t **) res;
}

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
int signalexists(railway_t *railway, int block, int signaln) {
  // Input validation
  if (block < 0 || block >= railway->hardware->numTracks) {
    return 0;
  }
  if (signaln < 0 || signaln > 1) {
    return 0;
  }

  return (findSignalByNumber(railway, block, signaln) != NULL);
}

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
void setsignal(railway_t *railway, int block, int signaln, int lights) {
  // Input validation
  if (block < 0 || block >= railway->hardware->numTracks) {
    // Ensure valid track segment
    return;
  }
  if (signaln < 0 || signaln > 1) {
    // Ensure valid signal number
    return;
  }
  if (lights < 0 || lights > (RED | YELLOW | GREEN)) {
    // Ensure valid light value
    return;
  }

  stateSignal_t *s = findSignalByNumber(railway, block, signaln);
  if (s != NULL) s->state = lights;
}

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
unsigned getsignal(railway_t *railway, int block, int signaln) {
  // Input validation
  if (block < 0 || block >= railway->hardware->numTracks) {
    // Ensure valid track segment
    return 0;
  }
  if (signaln < 0 || signaln > 1) {
    // Ensure valid signal number
    return 0;
  }

  stateSignal_t *s = findSignalByNumber(railway, block, signaln);

  return s != NULL ? s->state : 0;
}

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
void setpoint(railway_t *railway, int point, int state) {
  // Input validation
  if (point < 0 || point >= railway->hardware->numPoints) {
    // Return immediately if no valid element selected
    return;
  }
  if (state != STRAIGHT && state != BRANCH) {
    // Return immediately if no valid mode selected
    return;
  }

  // Grab hardware and set value directly
  railway->hardware->points[point]->state = state;
}

/**
 * Get the state of one point.
 *
 * @param railway
 *       The railway system to work on.
 * @param point
 *       The point number.
 * @return The current state of the point. One of STRAIGHT or BRANCH.
 */
int getpoint(railway_t *railway, int point) {
  // Input validation
  if (point < 0 || point >= railway->hardware->numPoints) {
    // Return immediately if no valid element selected
    return 0;
  }

  // Grab hardware and get value
  return railway->hardware->points[point]->state;
}

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
void setlight(railway_t *railway, int light, int state) {
  // Input validation
  if (light < 0 || light >= railway->hardware->numLights) {
    // Return immediately if no valid element selected
    return;
  }
  if (state != ON && state != OFF) {
    // Return immediately if no valid state selected
    return;
  }

  // Grab hardware and set value directly
  railway->hardware->lights[light]->state = state;
}

/**
 * Get the state of one light.
 *
 * @param railway
 *       The railway system to work on.
 * @param light
 *       The light number.
 * @return One of OFF or ON.
 */
int getlight(railway_t *railway, int light) {
  // Input validation
  if (light < 0 || light >= railway->hardware->numLights) {
    // Return immediately if no valid element selected
    return 0;
  }

  // Grab hardware and get value
  return railway->hardware->lights[light]->state;
}

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
void setgatesignal(railway_t *railway, int signaln, int lights) {
  // Input validation
  if (signaln < 0 || signaln >= railway->hardware->numGatesignals) {
    // Return immediately if no valid element selected
    return;
  }
  if (lights < 0 || lights > (RED | YELLOW | GREEN)) {
    // Ensure valid light value
    return;
  }

  // Grab hardware and set value directly
  railway->hardware->gateSignals[signaln]->state = lights;
}

/**
 * Get the status of one traffic light at a crossing.
 *
 * @param railway
 *       The railway system to work on.
 * @param signaln
 *       The number of the crossing signal.
 * @return The state of the crossing signal. Bitwise OR of the constants RED, YELLOW and GREEN.
 */
unsigned getgatesignal(railway_t *railway, int signaln) {
  // Input validation
  if (signaln < 0 || signaln >= railway->hardware->numGatesignals) {
    // Return immediately if no valid element selected
    return 0;
  }

  // Grab hardware and get value
  return railway->hardware->gateSignals[signaln]->state;
}

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
void setgate(railway_t *railway, int gate, int state) {
  // Input validation
  if (gate < 0 || gate >= railway->hardware->numGates) {
    // Return immediately if no valid element selected
    return;
  }
  if (state != UP && state != DOWN) {
    // Return immediately if no valid state selected
    return;
  }

  // Grab hardware and set value directly
  railway->hardware->gates[gate]->state = state;
}

/**
 * Get the state of one crossing gate.
 *
 * @param railway
 *       The railway system to work on.
 * @param gate
 *       The number of the gate.
 * @return The state. One of UP or DOWN.
 */
int getgate(railway_t *railway, int gate) {
  // Input validation
  if (gate < 0 || gate >= railway->hardware->numGates) {
    // Return immediately if no valid element selected
    return 0;
  }

  // Grab hardware and get value
  return railway->hardware->gates[gate]->state;
}

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
void setbell(railway_t *railway, int bell, int state) {
  // Input validation
  if (bell < 0 || bell >= railway->hardware->numBells) {
    // Return immediately if no valid element selected
    return;
  }
  if (state != ON && state != OFF) {
    // Return immediately if no valid state selected
    return;
  }

  // Grab hardware and set value directly
  railway->hardware->bells[bell]->state = state;
}

/**
 * Get the state of one bells.
 *
 * @param railway
 *       The railway system to work on.
 * @param bell
 *       The number of the bell.
 * @return The state. One of OFF or ON.
 */
int getbell(railway_t *railway, int bell) {
  // Input validation
  if (bell < 0 || bell >= railway->hardware->numBells) {
    // Return immediately if no valid element selected
    return 0;
  }

  // Grab hardware and get value
  return railway->hardware->bells[bell]->state;
}

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
unsigned getgatesensor(railway_t *railway, int gatesensor, int clear) {
  // Input validation
  if (gatesensor < 0 || gatesensor >= railway->hardware->numGateSensors) {
    // Return immediately if no valid element selected
    return 0;
  }

  if (railway->hardware->gateSensors[gatesensor]->numHandledEvents 
      != railway->hardware->gateSensors[gatesensor]->numEvents) {
    unsigned lastType = railway->hardware->gateSensors[gatesensor]->lastEventType;
    if (clear) {
      railway->hardware->gateSensors[gatesensor]->lastEventType = UNI;
      railway->hardware->gateSensors[gatesensor]->numHandledEvents = 
        (railway->hardware->gateSensors[gatesensor]->numHandledEvents + 1) % 4;
    }
    return lastType;
  }

  return NONE;
}

/**
 * Clears all events from the buffer of the gate sensor.
 *
 * @param railway
 *       The railway system to work on.
 * @param gatesensor
 *       The number of the gate.
 */
void cleargatesensor(railway_t *railway, int gatesensor) {
  // Input validation
  if (gatesensor < 0 || gatesensor >= railway->hardware->numGateSensors) {
    // Return immediately if no valid element selected
    return;
  }

  railway->hardware->gateSensors[gatesensor]->lastEventType = UNI;
  railway->hardware->gateSensors[gatesensor]->numHandledEvents = 
        railway->hardware->gateSensors[gatesensor]->numEvents;
}
