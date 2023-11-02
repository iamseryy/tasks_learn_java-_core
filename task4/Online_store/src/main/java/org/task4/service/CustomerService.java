package org.task4.service;


import org.task4.exception.WrongLoginException;
import org.task4.exception.WrongPasswordException;
import org.task4.model.Customer;

import java.util.HashSet;
import java.util.Optional;

public interface CustomerService {
    void add(Customer customer);
    HashSet<Customer> findAll();
    Optional<Customer> findByLogin(String login);


    // Создать статический метод который принимает на вход три параметра: login, password и confirmPassword.
    static boolean isValid(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login.isEmpty()) {
            throw new WrongLoginException("Login must not be empty");
        }

        if (login.length() >= 20) {
            throw new WrongLoginException("Login must be less than 20 characters");
        }

        if (password.isEmpty()) {
            throw new WrongLoginException("Password must not be empty");
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
