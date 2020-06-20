// ILedControlInterface.aidl
package com.ledcontrol.ledcontrolservice;

// Declare any non-default types here with import statements

interface ILedControlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void ledControl(int ledId, boolean stateOn);
}
