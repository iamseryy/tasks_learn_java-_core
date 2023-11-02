package org.task4.exception;

public class WrongQuantityException extends Exception{
    public WrongQuantityException(String message){
        super(message);
    }
}