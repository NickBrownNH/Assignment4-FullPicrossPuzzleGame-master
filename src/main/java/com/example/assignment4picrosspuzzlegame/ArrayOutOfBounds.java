package com.example.assignment4picrosspuzzlegame;

/**
 * This class is an extension of ArrayIndexOutOfBoundsException and is here for my own custom exception that I use for
 * the .txt files size exception.
 */
public class ArrayOutOfBounds extends ArrayIndexOutOfBoundsException {
    /**
     * gives the exception ArrayOutOfBounds and gives a message
     * @param message the message that will be displayed
     */
    public ArrayOutOfBounds (String message) {
        super(message);
    }
}
