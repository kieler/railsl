/*
 * Railway 4.0 Client Protocol - Kicking Horse Pass Mapping
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

#include "kicking.h"


/* hardware mapping tables */

static stateSignal_t* kicking_signals[SIGNALCOUNT];

static stateContact_t *kicking_contacts[CONTACTCOUNT];

static stateTrack_t* kicking_tracks[TRACKCOUNT];

static char *kicking_tracknames[TRACKCOUNT] = {
  "IC_JCT_0",  "IC_LN_0",   "IC_LN_1",   "IC_LN_2",
  "IC_LN_3",   "IC_LN_4",   "IC_LN_5",   "IC_ST_0",
  "IC_ST_1",   "IC_ST_2",   "IC_ST_3",   "IC_ST_4",
  "IO_LN_0",   "IO_LN_1",   "IO_LN_2",   "KH_LN_0",
  "KH_LN_1",   "KH_LN_2",   "KH_LN_3",   "KH_LN_4",
  "KH_LN_5",   "KH_LN_6",   "KH_LN_7",   "KH_LN_8",
  "KH_ST_0",   "KH_ST_1",   "KH_ST_2",   "KH_ST_3",
  "KH_ST_4",   "KH_ST_5",   "KH_ST_6",   "KIO_LN_0",
  "KIO_LN_1",  "OC_JCT_0",  "OC_LN_0",   "OC_LN_1",
  "OC_LN_2",   "OC_LN_3",   "OC_LN_4",   "OC_LN_5",
  "OC_ST_0",   "OC_ST_1",   "OC_ST_2",   "OC_ST_3",
  "OC_ST_4",   "OI_LN_0",   "OI_LN_1",   "OI_LN_2"
};

static statePoint_t* kicking_points[POINTCOUNT];

static stateLight_t* kicking_lights[LIGHTCOUNT];

static stateGate_t* kicking_gates[GATECOUNT];

static stateGatesensor_t *kicking_gatesensors[GATESENSORCOUNT];

static stateBell_t* kicking_bells[BELLCOUNT];

static stateGatesignal_t* kicking_gatesignals[GATECOUNT];


/* main hardware description structure */

stateRailway_t kicking = {
  RAILPICOUNT,
  TRACKCOUNT,       kicking_tracks,
                    kicking_tracknames,
  POINTCOUNT,       kicking_points,
  LIGHTCOUNT,       kicking_lights,
  SIGNALCOUNT,      kicking_signals,
  CONTACTCOUNT,     kicking_contacts,
  GATECOUNT,        kicking_gates,
  GATESENSORCOUNT,  kicking_gatesensors,
  GATECOUNT,        kicking_gatesignals,
  BELLCOUNT,        kicking_bells
};
