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

#ifndef railway40_railpi_h
#define railway40_railpi_h

#include <sys/types.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
//#include <string.h>
#include <sys/socket.h>
#include <netdb.h>
#include <pthread.h>

//#include <netinet/in.h>

#include "types.h"
#include "tcpProtocol.h"

/**
 * Connect to the given railPi.
 * 
 * @param railPi
 *        The railPi handler in question.
 * @param hostname
 *        The string to be used as the hostname. Can be either an textual hostname
 *        or an IP address (IPv4 or IPv6).
 * @param port
 *        String for the port to be used.
 */
int railPi_connect(stateRailPi_t* railPi, const char *hostname, const char *port);

/**
 * Disconnect from the given railPi.
 * 
 * @param railPi
 *        The railPi handler in question.
 */
int railPi_disconnect(stateRailPi_t* railPi);

/**
 * Request periphery config from the given railPi
 * and import the periphery into new wrappers in the railway hardware.
 *
 * @param railPi
 *        The railPi handler in question.
 * @param hardware
 *        The railway hardware wrapper used.
 */
int railPi_importPeriphery(stateRailPi_t* railPi, stateRailway_t *hardware);

/**
 * Free periphery wrappers created for this railPi.
 *
 * @param railPi
 *        The railPi handler in question.
 */
int railPi_freePeriphery(stateRailPi_t* railPi);

/**
 * Creates a synchronization thread for the railPi. The tread updates
 * the railPi with local changes and reads the contact events regularly.
 *
 * @param railPi
 *        The railPi to connect to. Thread should already exist.
 */
int railPi_startCommThread(stateRailPi_t* railPi);

/**
 * Closes and joins the synchronization thread for the railPi.
 *
 * @param railPi
 *        The railPi to disconnect.
 */
int railPi_stopCommThread(stateRailPi_t* railPi);


#endif
