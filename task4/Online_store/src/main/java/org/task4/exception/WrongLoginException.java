package org.task4.exception;

public class WrongLoginException extends Exception{
       public WrongLoginException(String message){
           super(message);
       }
}
