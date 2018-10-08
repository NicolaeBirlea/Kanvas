package com.console.exceptions;

public class IncorrectCommandException extends Exception {
    // Parameterless Constructor
    public IncorrectCommandException() {
    }

    // Constructor that accepts a message
    public IncorrectCommandException(String message) {
        super(message);
    }
}
