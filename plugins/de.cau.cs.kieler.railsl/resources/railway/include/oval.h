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

#ifndef railway40_oval_h
#define railway40_oval_h

#include "types.h"

// Constants to define the number of individual peripheral components
#define TRACKCOUNT      4
#define POINTCOUNT      2
#define SIGNALCOUNT     2
#define CONTACTCOUNT    8

// Number of raspberry pis
#define RAILPICOUNT     1

#define C_ST_0          0
#define C_ST_1          1
#define C_LN_0          2
#define C_LN_1          3

extern stateRailway_t oval;

#endif
