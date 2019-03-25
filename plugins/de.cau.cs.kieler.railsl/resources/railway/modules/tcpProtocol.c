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

#include "tcpProtocol.h"

#define READSIZE 2048

/**
 * Sends the prepared json string to the railwayD.
 *
 * @param railPi
 *    The {@code stateRailPi_t} holding the connection to the railwayD.
 * @param json
 *    Serialized json string to send. Should end with a newline.
 * @param jsonSize
 *    Length of the json string.
 */
void railwayD_sendJSONCommand(stateRailPi_t *railPi, const char *json, const size_t jsonSize) {
  // Send data through socket
  ssize_t n = send(railPi->socket, json, jsonSize, 0);
  if (n < 0)
    perror("ERROR writing to socket");
}

/**
 * Sends a single simple command (command without additional payload) to the railwayD.
 *
 * @param railPi
 *    The {@code stateRailPi_t} holding the connection to the railwayD.
 * @param command
 *    The string to be placed in the command part of the json.
 */
void railwayD_sendSimpleCommand(stateRailPi_t *railPi, const char *command) {
  // Prepare the json object to send
  JSON_Value *json_value = json_value_init_object();
  JSON_Object *json = json_value_get_object(json_value);
  json_object_set_string(json, "command", command);

  // Prepare buffer
  size_t bufsize = json_serialization_size(json_value);
  char *json_string = (char*) malloc(bufsize * sizeof(char) + 1);

  // Serialize to buffer and append newline
  json_serialize_to_buffer(json_value, json_string, bufsize);
  strcat(json_string, "\n");

  // Send data
  railwayD_sendJSONCommand(railPi, json_string, bufsize);

  json_free_serialized_string(json_string);
  json_value_free(json_value);
}


char *railwayD_awaitCommandResponse(stateRailPi_t *railPi) {
  // We don't know how long the data will be
  // Read the data in portions of READSIZE bytes
  char *msg = malloc(sizeof(char) * (READSIZE + 1));
  ssize_t readBytes = recv(railPi->socket, msg, READSIZE, 0);

  // The data might be longer than the buffer was.
  // Read more data to the end of the buffer.
  while (msg[readBytes - 1] != '\n') {
    msg = realloc(msg, sizeof(char) * (readBytes + READSIZE + 1));
    ssize_t newBytes = recv(railPi->socket, msg + readBytes, READSIZE, MSG_DONTWAIT);
    if (newBytes > 0) {
      readBytes += newBytes;
    } else{
      usleep(10);
    }
  }
  msg[readBytes] = 0;

  return msg;
}


/**
 * Signals the railwayD to connect to the railway periphery.
 *
 * @param railPi
 *    The {@code stateRailPi_t} holding the connection to the railwayD.
 */
void railwayD_connect(stateRailPi_t *railPi) {
  railwayD_sendSimpleCommand(railPi, "connect");
}

/**
 * Signals the railwayD to disconnect from the railway periphery.
 *
 * @param railPi
 *    The {@code stateRailPi_t} holding the connection to the railwayD.
 */
void railwayD_disconnect(stateRailPi_t *railPi) {
  railwayD_sendSimpleCommand(railPi, "disconnect");
}

/**
 * Internal helper to copy the name from a JSON string to a more
 * permanent place.
 */
char *copyName(const char* original) {
    size_t len = strlen(original) + 1;
    char *copy = malloc(sizeof(char) * len);
    memset(copy, '\0', len);
    strncpy(copy, original, len);

    return copy;
}

/**
 * Signals the railwayD to send its periphery config.
 *
 * @param railPi
 *    The {@code stateRailPi_t} holding the connection to the railwayD.
 */
void railwayD_config(stateRailPi_t *railPi) {
  railwayD_sendSimpleCommand(railPi, "config");
  char *config = railwayD_awaitCommandResponse(railPi);
  JSON_Value *parsed_config = json_parse_string(config);
  if (parsed_config == NULL) {
    printf("ERROR while parsing config JSON");
    return;
  }
  JSON_Object *json_config = json_value_get_object(parsed_config);
  
  // Grab configured tracks from config
  JSON_Array *json_tracks = json_object_get_array(json_config, "tracks");
  //Get the length of the array and iterate over it
  size_t tracksNum = json_array_get_count(json_tracks);
  // Make space for the track wrappers
  railPi->numTracks = tracksNum;
  railPi->tracks = malloc(sizeof(stateTrack_t *) * tracksNum);
  for (size_t t = 0; t < tracksNum; ++t) {
    // Grab the current track name
    char* trackName = copyName(json_array_get_string(json_tracks, t));
    
    // Create a wrapper for the track and store the name there.
    // The rest of the data will be validated according to the
    // railway system
    stateTrack_t *trackWrapper = malloc(sizeof(stateTrack_t));
    trackWrapper->name = trackName;
    // Store the track wrapper in the railPi struct
    railPi->tracks[t] = trackWrapper;
  }
  
  // Grab configured points from config
  JSON_Array *json_points = json_object_get_array(json_config, "points");
  //Get the length of the array and iterate over it
  size_t pointsNum = json_array_get_count(json_points);
  // Make space for the track wrappers
  railPi->numPoints = pointsNum;
  railPi->points = malloc(sizeof(statePoint_t *) * pointsNum);
  for (size_t p = 0; p < pointsNum; ++p) {
    // Grab the current track name
    char* pointName = copyName(json_array_get_string(json_points, p));
    
    // Create a wrapper for the track and store the name there.
    // The rest of the data will be validated according to the
    // railway system
    statePoint_t *pointWrapper = malloc(sizeof(statePoint_t));
    pointWrapper->name = pointName;
    // Store the track wrapper in the railPi struct
    railPi->points[p] = pointWrapper;
  }
  
  // Grab configured signals from config
  JSON_Array *json_signals = json_object_get_array(json_config, "signals");
  //Get the length of the array and iterate over it
  size_t signalsNum = json_array_get_count(json_signals);
  // Make space for the signal wrappers
  railPi->numSignals = signalsNum;
  railPi->signals = malloc(sizeof(stateSignal_t *) * signalsNum);
  for (size_t s = 0; s < signalsNum; ++s) {
    // Grab the current signal object with block and direction
    JSON_Object *signalObj = json_array_get_object(json_signals, s);
    // Grab the signal segment name
    char* signalName = copyName(json_object_get_string(signalObj, "name"));
    // Grab the number of the signal
    int signalDir = json_object_get_number(signalObj, "number");
    
    // Create a wrapper for the signal and store the name and number there.
    stateSignal_t *signalWrapper = malloc(sizeof(stateSignal_t));
    signalWrapper->name = signalName;
    signalWrapper->dir = signalDir;
    // Store the track wrapper in the railPi struct
    railPi->signals[s] = signalWrapper;
  }

  // Grab the contacts
  JSON_Array *json_contacts = json_object_get_array(json_config, "contacts");
  //Get the length of the array and iterate over it
  size_t contactsNum = json_array_get_count(json_contacts);
  // Make space for the contact wrappers
  railPi->numContacts = contactsNum;
  railPi->contacts = malloc(sizeof(stateContact_t *) * contactsNum);
  for (size_t c = 0; c < contactsNum; ++c) {
    // Grab the current contact object with block and direction
    JSON_Object *contactObj = json_array_get_object(json_contacts, c);
    // Grab the contact segment name
    char* contactName = copyName(json_object_get_string(contactObj, "name"));
    // Grab the number of the contact
    int contactNumber = json_object_get_number(contactObj, "number");
    
    // Create a wrapper for the contact and store the name and number there.
    stateContact_t *contactWrapper = malloc(sizeof(stateContact_t));
    contactWrapper->name = contactName;
    contactWrapper->number = contactNumber;
    // Store the track wrapper in the railPi struct
    railPi->contacts[c] = contactWrapper;
  }

}

stateContact_t *findContactByName(stateRailPi_t *railPi, const char *name, int number) {
  for (int i = 0; i < railPi->numContacts; ++i) {
    stateContact_t *contact = railPi->contacts[i];
    if (contact->number == number && strcmp(contact->name, name) == 0) 
      return contact;
  }
  return NULL;
}

/**
 * Signals the railwayD to send the current state of the contact events.
 *
 * @param railPi
 *    The {@code stateRailPi_t} holding the connection to the railwayD.
 */
void railwayD_contacts(stateRailPi_t *railPi) {
  railwayD_sendSimpleCommand(railPi, "contacts");
  char *contacts_raw = railwayD_awaitCommandResponse(railPi);
  JSON_Value *parsed_contacts = json_parse_string(contacts_raw);
  if (parsed_contacts == NULL) {
    printf("ERROR while parsing contacts JSON");
    return;
  }
  JSON_Object *contactsObj = json_value_get_object(parsed_contacts);

  JSON_Array *contacts = json_object_get_array(contactsObj, "contacts");
  //Get the length of the array and iterate over it
  size_t contactsNum = json_array_get_count(contacts);
  for (int i = 0; i < contactsNum; ++i) {
    JSON_Object *contactObj = json_array_get_object(contacts, i);
    //Find contact by name and number
    stateContact_t *contactWrapper = findContactByName(railPi, 
      json_object_get_string(contactObj, "name"), 
      json_object_get_number(contactObj, "number"));

    // Store the new data
    contactWrapper->numEvents = json_object_get_number(contactObj, "count");
    contactWrapper->lastEventType = json_object_get_number(contactObj, "type");
  }
  

}

/**
 * Sends a new railway state to  the railwayD.
 *
 * @param railPi
 *    The {@code stateRailPi_t} holding the connection to the railwayD.
 */
void railwayD_state(stateRailPi_t *railPi) {
  // Prepare the json object to send
  JSON_Value *json_value = json_value_init_object();
  JSON_Object *json = json_value_get_object(json_value);
  json_object_set_string(json, "command", "status");

  // Add the tracks to the json object
  JSON_Value *json_tracks = json_value_init_array();
  JSON_Array *json_tracks_array = json_value_get_array(json_tracks);
  for(int t = 0; t < railPi->numTracks; ++t) {
    JSON_Value *json_track = json_value_init_object();
    JSON_Object *track = json_value_get_object(json_track);
    json_object_set_string(track, "name", railPi->tracks[t]->name);
    json_object_set_number(track, "direction", railPi->tracks[t]->direction);
    json_object_set_number(track, "pwm", railPi->tracks[t]->pwm);
    json_array_append_value(json_tracks_array, json_track);
  }
  json_object_set_value(json, "tracks", json_tracks);

  // Add the points to the json object
  JSON_Value *json_points = json_value_init_array();
  JSON_Array *json_points_array = json_value_get_array(json_points);
  for(int p = 0; p < railPi->numPoints; ++p) {
    JSON_Value *json_point = json_value_init_object();
    JSON_Object *point = json_value_get_object(json_point);
    json_object_set_string(point, "name", railPi->points[p]->name);
    json_object_set_number(point, "value", railPi->points[p]->state);
    json_array_append_value(json_points_array, json_point);
  }
  json_object_set_value(json, "points", json_points);

  // Add the signals to the json object
  JSON_Value *json_signals = json_value_init_array();
  JSON_Array *json_signals_array = json_value_get_array(json_signals);
  for(int s = 0; s < railPi->numSignals; ++s) {
    JSON_Value *json_signal = json_value_init_object();
    JSON_Object *signal = json_value_get_object(json_signal);
    json_object_set_string(signal, "name", railPi->signals[s]->name);
    json_object_set_number(signal, "number", railPi->signals[s]->dir);
    json_object_set_number(signal, "value", railPi->signals[s]->state);
    json_array_append_value(json_signals_array, json_signal);
  }
  json_object_set_value(json, "signals", json_signals);

  // Prepare buffer
  size_t bufsize = json_serialization_size(json_value);
  char *json_string = (char*) malloc(bufsize * sizeof(char) + 1);

  // Serialize to buffer and append newline
  json_serialize_to_buffer(json_value, json_string, bufsize);
  strcat(json_string, "\n");

  // Send data through socket
  ssize_t n = send(railPi->socket, json_string, bufsize, 0);
  if (n < 0)
    perror("ERROR writing to socket");

  json_free_serialized_string(json_string);
  json_value_free(json_value);
}
