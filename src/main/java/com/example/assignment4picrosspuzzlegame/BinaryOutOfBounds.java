package com.example.assignment4picrosspuzzlegame;

/**
 * This class is an extension of Exception and is here for my own custom exception that I use for the .txt
 * files number checking mechanism and to make sure it follows the format or this exception will be thrown.
 */
public class BinaryOutOfBounds extends RuntimeException {

    /**
     * gives the exception BinaryOutOfBounds and gives a message
     * @param message the message that will be displayed
     */
    public BinaryOutOfBounds (String message){
        super (message);
    }
}
