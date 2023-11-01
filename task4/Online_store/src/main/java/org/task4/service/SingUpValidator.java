package org.task4.service;

import org.task4.exception.WrongLoginException;
import org.task4.exception.WrongPasswordException;

public class SingUpValidator {
    public static boolean isValid(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login.length() >= 20) {
            throw new WrongLoginException("Login must be less than 20 characters");
        }

        if (password.length() >= 20) {
            throw new WrongPasswordException("Password must be less than 20 characters");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Password and confirm password are not equal");
        }

        return true;
    }
}
