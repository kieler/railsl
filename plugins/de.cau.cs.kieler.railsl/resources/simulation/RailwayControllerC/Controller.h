/*
 * Automatically generated C code by
 * KIELER SCCharts - The Key to Efficient Modeling
 *
 * http://rtsys.informatik.uni-kiel.de/kieler
 */

typedef struct {
  char contacts[48][2];
  int tracks[48][2];
  char points[30];
  int signals[48][2];
  char lights[24];
  char second;
  char crossing;
  char _g0;
  char _GO;
  char _TERM;
} TickData;

void reset(TickData* d);
void logic(TickData* d);
void tick(TickData* d);

