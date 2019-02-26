/*
 * Automatically generated C code by
 * KIELER SCCharts - The Key to Efficient Modeling
 *
 * http://rtsys.informatik.uni-kiel.de/kieler
 */

#include "Controller.h"

void reset(TickData* d) {
  d->_GO = 1;
  d->_TERM = 0;
}

void logic(TickData* d) {
  if (d->_GO) {
    d->tracks[25][0] = 120;
    d->tracks[25][1] = 1;
    d->signals[25][1] = 4;
    d->signals[25][0] = 1;
  }
  d->_TERM = d->_g0;
}

void tick(TickData* d) {
  logic(d);

  d->_GO = 0;
}

