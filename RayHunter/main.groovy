#!/usr/bin/env groovy

import ChangeMachine

/**
 * Main script for handling the ChangeMachine.
 *  
 * @author Ray Hunter ray.hunter@stgconsulting.com
 */
def changeMachine = new ChangeMachine();

// handle each line of input
System.in.eachLine { line ->
  changeMachine.makeChange(line);
}
