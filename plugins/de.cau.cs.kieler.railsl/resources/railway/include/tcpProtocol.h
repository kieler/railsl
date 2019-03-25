/*
 * Railway 4.0 Client Protocol - TCP Protocol
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

#ifndef railway40_tcpprotocol_h
#define railway40_tcpprotocol_h

// Include stdlib for malloc
#include <stdlib.h>
// Include stdio for error output
#include <stdio.h>
// Include string handling
#include <string.h>
// Include network functions
#include <sys/types.h>
#include <sys/socket.h>
// Include sleep
#include <unistd.h>

// Include header for the connection struct
#include "types.h"
// Include json handling library
#include "parson.h"

/**
 * Signals the railwayD to connect to the railway periphery.
 *
 * @param railPi
 *    The {@code railwayDConn_t} holding the connection to the railwayD.
 */
void railwayD_connect(stateRailPi_t *railPi);

/**
 * Signals the railwayD to disconnect from the railway periphery.
 *
 * @param railPi
 *    The {@code railwayDConn_t} holding the connection to the railwayD.
 */
void railwayD_disconnect(stateRailPi_t *railPi);

/**
 * Signals the railwayD to send its periphery config.
 *
 * @param railPi
 *    The {@code railwayDConn_t} holding the connection to the railwayD.
 */
void railwayD_config(stateRailPi_t *railPi);

/**
 * Signals the railwayD to send the current state of the contact events.
 *
 * @param railPi
 *    The {@code railwayDConn_t} holding the connection to the railwayD.
 */
void railwayD_contacts(stateRailPi_t *railPi);

/**
 * Sends a new railway state to  the railwayD.
 *
 * @param railPi
 *    The {@code railwayDConn_t} holding the connection to the railwayD.
 */
void railwayD_state(stateRailPi_t *railPi);

#endif
