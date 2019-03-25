# ============================================================================
#
#   Makefile for railway interface
#
#   This file creates all libraries and applications needed to operate the
#   railway system. Some variables control the compilations.
#
# ============================================================================

# target configuration
PROGRAMS=$(patsubst %.c,%,$(wildcard *.c))
LIBDIR?=$(shell pwd)/libraries
INCDIRS=include parson

# LAYOUTS=oval kicking
LAYOUTS=kicking oval

CC=gcc
CPP=g++
AR=ar
CFLAGS:=-Wall -O2 $(addprefix -I,$(INCDIRS)) -L$(LIBDIR) -fPIC -DPIC
CPPFLAGS:=-Wall -O2 $(addprefix -I,$(INCDIRS)) -L$(LIBDIR) -DLINUX -fPIC -DPIC


OBJECTS=$(sort $(patsubst %.c,%.o,$(wildcard modules/*.c)) \
	$(foreach EXT,$(LAYOUTS),modules/$(EXT).o))
LIBA=$(foreach EXT,parson railway,$(LIBDIR)/lib$(EXT).a)
LIBRARIES=$(LIBA)

# default targets

.PHONY: all clean

all:	$(LIBRARIES) $(PROGRAMS)

clean:
	rm -f $(PROGRAMS)
	rm -f $(OBJECTS)
	rm -f parson/parson.o
	rm -f $(LIBRARIES)	
	rm -f *~ */*~

# implicit rules

modules/%.o: modules/%.c include/%.h
	$(CC) $(CFLAGS) -o $@ -c $<

%: %.c $(LIBRARIES)
	$(CC) $(CFLAGS) -Wl,--rpath,$(LIBDIR) -o $@ $< -lrailway -lparson -lpthread -lm

# module dependencies

modules/tcpProtocol.o: parson/parson.h
modules/railPi.o: include/tcpProtocol.h
modules/railway.o: include/railPi.h
$(foreach EXT,$(LAYOUTS),Modules/$(EXT).o): include/railway.h

# parson

parson/parson.o: parson/parson.c parson/parson.h
	$(CC) $(CFLAGS) -o $@ -c $<

$(LIBDIR)/libparson.a: parson/parson.o
	$(AR) rcs $@ $(filter %.o,$+)

# librailway

$(LIBDIR)/librailway.a: $(OBJECTS) $(foreach EXT,$(LAYOUTS), \
		include/$(EXT).h modules/$(EXT).c)
	$(AR) rcs $@ $(filter %.o,$+)
