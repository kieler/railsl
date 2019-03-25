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

#ifndef railway40_kicking_h
#define railway40_kicking_h

#include "types.h"

// Constants to define the number of individual peripheral components
#define TRACKCOUNT      48
#define POINTCOUNT      30
#define LIGHTCOUNT      24
#define SIGNALCOUNT     56
#define GATECOUNT       2
#define BELLCOUNT       1
#define CONTACTCOUNT    80
#define GATESENSORCOUNT 2

// Number of raspberry pis
#define RAILPICOUNT     4

#define IC_JCT_0  0
#define IC_LN_0   1
#define IC_LN_1   2
#define IC_LN_2   3
#define IC_LN_3   4
#define IC_LN_4   5
#define IC_LN_5   6
#define IC_ST_0   7
#define IC_ST_1   8
#define IC_ST_2   9
#define IC_ST_3   10
#define IC_ST_4   11
#define IO_LN_0   12
#define IO_LN_1   13
#define IO_LN_2   14
#define KH_LN_0   15
#define KH_LN_1   16
#define KH_LN_2   17
#define KH_LN_3   18
#define KH_LN_4   19
#define KH_LN_5   20
#define KH_LN_6   21
#define KH_LN_7   22
#define KH_LN_8   23
#define KH_ST_0   24
#define KH_ST_1   25
#define KH_ST_2   26
#define KH_ST_3   27
#define KH_ST_4   28
#define KH_ST_5   29
#define KH_ST_6   30
#define KIO_LN_0  31
#define KIO_LN_1  32
#define OC_JCT_0  33
#define OC_LN_0   34
#define OC_LN_1   35
#define OC_LN_2   36
#define OC_LN_3   37
#define OC_LN_4   38
#define OC_LN_5   39
#define OC_ST_0   40
#define OC_ST_1   41
#define OC_ST_2   42
#define OC_ST_3   43
#define OC_ST_4   44
#define OI_LN_0   45
#define OI_LN_1   46
#define OI_LN_2   47

extern stateRailway_t kicking;

#endif
