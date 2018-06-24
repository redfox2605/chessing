package com.redfox.chess.util;

public class InvalidMoveException extends Exception{


    private String message;

    public InvalidMoveException(String message) {
        this.message = message;
    }

    public String getMessage(){ return this.message;}
}
