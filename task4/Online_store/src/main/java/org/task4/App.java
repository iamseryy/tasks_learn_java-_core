package org.task4;

import org.task4.exception.WrongLoginException;
import org.task4.exception.WrongPasswordException;
import org.task4.service.SingUpValidator;


public class App 
{
    public static void main( String[] args ) {

        //Task1. Checking login and password
        task1();

        //Task2. Online store emulation
        task2();


    }

    public static void task1(){
        System.out.println("Task1. Checking login and password");
        try {
            if (SingUpValidator.isValid("user1", "password", "password")) {
                System.out.println("Login and password are valid");
            };
        } catch (WrongLoginException e){
            System.out.printf(e.getMessage());
        } catch (WrongPasswordException e){
            System.out.printf(e.getMessage());
        }
    }

    public static void task2(){

    }

}
