/*
 * Railway 4.0 Client Protocol - Type declarations
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

#ifndef railway40_types_h
#define railway40_types_h

#include <pthread.h>

/****************************************************
 * ######## ##    ## ########  ########  ######     *
 *    ##     ##  ##  ##     ## ##       ##    ##    *
 *    ##      ####   ##     ## ##       ##          *
 *    ##       ##    ########  ######    ######     *
 *    ##       ##    ##        ##             ##    *
 *    ##       ##    ##        ##       ##    ##    *
 *    ##       ##    ##        ########  ######     *
 ****************************************************/

/**
 * Stores the state of a single track segment.
 */
struct stateTrack {
  /** The block id, defined in the used header (kicking/test). */ 
  unsigned block;
  /** The user readable name of the track segment, used in JSON. */
  char *name;
  /** The current direction. Can be 0 for OFF, 1 for FWD and 2 for REV. */
  unsigned char direction;
  /* The current PWM level as a value between 0 and 255. */
  unsigned char pwm;
};
typedef struct stateTrack stateTrack_t;


/**
 * Stores the state of a signal. 
 * Can be a track signal or a gate signal.
 */
struct stateSignal {
  /** The block of the track the signal is associated with. */
  unsigned block;
  /** The human readable name of the signal, used in JSON. */
  char *name;
  /** The direction of the signal, is 1 at FWD direction, 0 at REV. */
  unsigned char dir;
  /** The current state. 0 is OFF, 1 is GREEN, 2 is YELLOW, and 3 is RED. */
  unsigned char state;
};
typedef struct stateSignal stateSignal_t;
typedef struct stateSignal stateGatesignal_t;


/**
 * Stores the state of a single switch point.
 * Is also used for all periphery attached to the relays.
 */
struct statePoint {
  /** The human readable name of the component. */
  char *name;
  /* The current state. 0 is STRAIGHT, 1 is BRANCH. */
  unsigned char state;
};
typedef struct statePoint statePoint_t;
typedef struct statePoint stateLight_t;
typedef struct statePoint stateGate_t;
typedef struct statePoint stateBell_t;

/**
 * Store the contact events
 */
struct stateContact {
  /** The block id of the track the contact is associated with. */
  unsigned block;
  /** The human readable name of the track segment, used in JSON. */
  char *name;
  /** The number of the signal, is 0 for first and 1 for second. */
  unsigned char number;
  /** The current number of events. */
  unsigned char numEvents;
  /** The number of handled events. */
  unsigned char numHandledEvents;
  /** The type of the last event */
  unsigned int lastEventType;
};
typedef struct stateContact stateContact_t;
typedef struct stateContact stateGatesensor_t;

/**
 * The combination of the entire railway state.
 */
struct railway_hardware {
  unsigned int  numRailPis;           /** Number of Raspberry PIs */
  unsigned int  numTracks;            /** Number of available tracks */
  stateTrack_t  **tracks;             /** State of all tracks */
  char          **trackNames;         /** Name mapping for tracks */
  unsigned int  numPoints;            /** Number of switch points */
  statePoint_t  **points;             /** State of all switch points */
  unsigned int  numLights;            /** Number of lights */
  stateLight_t  **lights;             /** State of all lights */
  unsigned int  numSignals;           /** Number of track signals */
  stateSignal_t **signals;            /** State of all track signals */
  unsigned int  numContacts;          /** Number of contacts */
  stateContact_t **contacts;          /** State of all contacts */
  unsigned int  numGates;             /** Number of gates */
  stateGate_t   **gates;              /** State of all gates */
  unsigned int  numGateSensors;       /** Number of gatesensors */
  stateGatesensor_t   **gateSensors;  /** State of the gate sensors */
  unsigned int  numGatesignals;       /** Number of gate signals */
  stateGatesignal_t   **gateSignals;  /** State of all gate signals */
  unsigned int  numBells;             /** Number of bells */
  stateBell_t   **bells;              /** State of all bells */
};
typedef struct railway_hardware stateRailway_t;


/**
 * Encapsulates the connection to a given
 * railway daemon as well as the state of the daemon.
 */
struct stateRailPi {
  unsigned int  railPiNumber;   /** ID of the RailPi */
  unsigned int  numTracks;      /** Number of tracks managed */
  stateTrack_t  **tracks;       /** State of the managed tracks */
  unsigned int  numPoints;      /** Number of points/periphery managed */
  statePoint_t  **points;       /** State of the points/periphery */
  unsigned int  numSignals;     /** Number of signals managed */
  stateSignal_t **signals;      /** State of the signals */
  unsigned int  numContacts;    /** Number of contacts managed */
  stateContact_t  **contacts;   /** State of the contacts */

  int           socket;         /** The network connection */
  pthread_t     thread;        /** Synchronization thread */
  unsigned char run;            /** Signal for thread termination */

};
typedef struct stateRailPi stateRailPi_t;


/**
 * Bundles the network state together with the
 * railway state as a whole usable entity.
 */
struct railway_system {
  stateRailway_t *hardware;     /** Container for the railway state */
  unsigned int   numRailPis;    /** Number of Raspberry PIs involved */
  stateRailPi_t  **railPis;     /** Network handling state for all PIs */
};
typedef struct railway_system railway_t;

#endif
