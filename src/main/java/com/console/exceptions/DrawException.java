package com.console.exceptions;

public class DrawException extends Exception {

    // Parameterless Constructor
    public DrawException() {
    }

    // Constructor that accepts a message
    public DrawException(String message) {
        super(message);
    }
}
