/*
 * Railway 4.0 Client Protocol - Raspberry Pi Communication
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

#include "railPi.h"


/***********************
 * Synchronization thread
 ***********************/

/**
 * Initial method for synchronization thread, invoked by
 * pthread_create().
 *
 * @param data
 *        The stateRailPi_t struct for the active railPi.
 */
void *commThread(void *data) {
  if (data == NULL) {
    fprintf(stdout, "No data for thread supplied!\n");
    return 0;
  }
  // We assume to have a stateRailPi_t struct
  // Otherwise things probably go haywire at this point
  stateRailPi_t *railPi = (stateRailPi_t *) data;

  // Okay, now we have dealt with the hassle of creating new threads,
  // we might want to take some time to think about what we are doing here.
  //
  // Our tasks are:
  // a) Connect the railPi to the arduino
  // b) Write out current state of the railway to the railwayD.
  // c) Request contact events from the railwayD.
  // d) Maybe wait a bit, the railwayD syncs the Arduinos every .2 seconds
  // e) Go back to b) if no disconnect requested
  // f) Disconnect the arduino
  //
  // So let's get to it

  railwayD_connect(railPi);

  while (railPi->run) {
    // Sync state to railwayD
    railwayD_state(railPi);
    // Read contact events
    railwayD_contacts(railPi);
    // take a nap
    usleep(100000);
  }
  railwayD_disconnect(railPi);
  
  return 0;
}



/***********************
 * Local Helpers
 ***********************/

void railPi_consolidateWrappers(stateRailPi_t *railPi, stateRailway_t *hardware) {
  // Organize the wrappers in the railway hardware wrapper for the combination of all railPis

  // Link the tracks
  for (int i = 0; i < railPi->numTracks; ++i) {
    stateTrack_t *track = railPi->tracks[i];
    // Find block id
    unsigned int b = 0;
    while (b < hardware->numTracks) {
      if (strcmp(hardware->trackNames[b], track->name) == 0) {
        track->block = b;
        break;
      }
      ++b;
    }
    track->pwm = 0;
    track->direction = 0;
    hardware->tracks[b] = track;
  }

  // Link the points, lights, gates and bells
  for (int i = 0; i < railPi->numPoints; ++i) {
    statePoint_t *point = railPi->points[i];
    // Check which kind of element is attached
    if (strncmp(point->name, "PNT_", 4) == 0) {
      unsigned int p = atoi(point->name + 4);
      hardware->points[p] = point;
    } else if (strncmp(point->name, "L_", 2) == 0) {
      unsigned int l = atoi(point->name + 2);
      hardware->lights[l] = point;
    } else if (strncmp(point->name, "Gate_", 5) == 0) {
      unsigned int g = atoi(point->name + 5);
      hardware->gates[g] = point;
    } else if (strncmp(point->name, "Bell_", 5) == 0) {
      unsigned int b = atoi(point->name + 5);
      hardware->bells[b] = point;
    }
    point->state = 0;
  }

  // Link the signals and gatesignals
  for (int i = 0; i < railPi->numSignals; ++i) {
    stateSignal_t *signal = railPi->signals[i];
    // The Name might start with 'Gate_' to indicate the gate signals
    if (strncmp(signal->name, "Gate_", 5) == 0) {
      unsigned int g = atoi(signal->name + 5);
      hardware->gateSignals[g] = signal;
    } else {
      // Seems to be a regular signal
      // Find block id
      for (unsigned int b = 0; b < hardware->numTracks; ++b) {
        if (strcmp(hardware->trackNames[b], signal->name) == 0) {
          signal->block = b;
          break;
        }
      }
      // Find a free spot in the list of signals (will be sorted later ?)
      for (unsigned int s = 0; s < hardware->numSignals; ++s) {
        if (hardware->signals[s] == NULL) {
          hardware->signals[s] = signal;
          break;
        }
      }
    }
    signal->state = 0;
  }

  // Link the contacts
  for (int i = 0; i < railPi->numContacts; ++i) {
    stateContact_t *contact = railPi->contacts[i];
    // The Name might start with 'Gate_' to indicate the gate sensors
    if (strncmp(contact->name, "Gate_", 5) == 0) {
      unsigned int g = atoi(contact->name + 5);
      hardware->gateSensors[g] = contact;
    } else {
      // Seems to be a regular contact
      // Find block id
      for (unsigned int b = 0; b < hardware->numTracks; ++b) {
        if (strcmp(hardware->trackNames[b], contact->name) == 0) {
          contact->block = b;
          break;
        }
      }
      // Find a free spot in the list of signals (will be sorted later ?)
      for (unsigned int c = 0; c < hardware->numContacts; ++c) {
        if (hardware->contacts[c] == NULL) {
          hardware->contacts[c] = contact;
          break;
        }
      }
    }
    contact->numEvents = 0;
    contact->numHandledEvents = 0;
    contact->lastEventType = 0;
  }
}

/***********************
 * External Interface
 ***********************/

/**
 * Connect to the railPi with the given number in the current railway structure.
 * 
 * @param railPi
 *        The railPi handler in question.
 * @param hostname
 *        The string to be used as the hostname. Can be either an textual hostname
 *        or an IP address (IPv4 or IPv6).
 * @param port
 *        String for the port to be used.
 */
int railPi_connect(stateRailPi_t *railPi, const char *hostname, const char *port) {

#ifdef DEBUG
  fprintf(stdout, "Connecting to %s on port %s\n", hostname, port);
#endif

  struct addrinfo hints;
  struct addrinfo *infoptr;
  memset(&hints, 0, sizeof(hints));
  
  hints.ai_family = AF_UNSPEC;
  hints.ai_socktype = SOCK_STREAM;
  hints.ai_flags = AI_V4MAPPED | AI_ADDRCONFIG;

  int server = getaddrinfo(hostname, port, &hints, &infoptr);
  if (server) {
    fprintf(stderr, "ERROR, while looking up host - %s\n", gai_strerror(server));
    exit(0);
  }

  // Create TCP socket
  railPi->socket = socket(infoptr->ai_family, infoptr->ai_socktype, infoptr->ai_protocol);
  if (railPi->socket < 0)
    perror("ERROR opening socket");

  // Connect prepared socket
  if (connect(railPi->socket, infoptr->ai_addr, infoptr->ai_addrlen) < 0)
    perror("ERROR connecting");

  return 0;
}

/**
 * Disconnect from the given railPi.
 * 
 * @param railPi
 *        The railPi handler in question.
 */
int railPi_disconnect(stateRailPi_t* railPi) {
  close(railPi->socket);

  return 0;
}

/**
 * Request periphery config from the railPi specified by piNum 
 * and import the periphery into new wrappers in the railway system.
 *
 * @param railway
 *        The railway system to use for finding the railPi and storing
 *        the periphery data.
 * @param piNum
 *        Which railPi to query.
 */
int railPi_importPeriphery(stateRailPi_t* railPi, stateRailway_t *hardware) {
  // Attack plan:
  // - Let tcpprotocol deal with decoding json and creating wrappers
  // - Fill the preliminary wrappers with the data from the railway system
  
  // Read the config from the railPi.
  // This creates wrappers that are not complete, yet
  railwayD_config(railPi);

  // Fill railPi data
  railPi_consolidateWrappers(railPi, hardware);

  return 0;
}

/**
 * Free periphery wrappers created for this railPi.
 *
 * @param railPi
 *        The railPi handler in question.
 */
int railPi_freePeriphery(stateRailPi_t* railPi) {
  for (int i = 0; i < railPi->numTracks; ++i) {
    free(railPi->tracks[i]->name);
    free(railPi->tracks[i]);
  }
  free(railPi->tracks);
  for (int i = 0; i < railPi->numPoints; ++i) {
    free(railPi->points[i]->name);
    free(railPi->points[i]);
  }
  free(railPi->points);
  for (int i = 0; i < railPi->numSignals; ++i) {
    free(railPi->signals[i]->name);
    free(railPi->signals[i]);
  }
  free(railPi->signals);
  for (int i = 0; i < railPi->numContacts; ++i) {
    free(railPi->contacts[i]->name);
    free(railPi->contacts[i]);
  }
  free(railPi->contacts);

  return 0;
}

/**
 * Creates a synchronization thread for the railPi. The tread updates
 * the railPi with local changes and reads the contact events regularly.
 *
 * @param railPi
 *        The railPi to connect to. Thread should already exist.
 */
int railPi_startCommThread(stateRailPi_t* railPi) {
  // Create handler object
  pthread_t thread;
  // Set thread control to run
  railPi->run = 1;
  
  // Run it
  pthread_create(&thread, NULL, &commThread, railPi);
  railPi->thread = thread;
  return 0;
}

/**
 * Closes and joins the synchronization thread for the railPi.
 *
 * @param railPi
 *        The railPi to disconnect.
 */
int railPi_stopCommThread(stateRailPi_t* railPi) {
  // Send the termination flag
  railPi->run = 0;
  // Join the thread
  pthread_join(railPi->thread, NULL);

  return 0;
}
