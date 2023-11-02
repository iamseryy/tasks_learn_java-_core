package org.task4.repository;

import org.task4.model.Customer;

import java.util.HashSet;
import java.util.Optional;

public interface Customers {
    void add(Customer customer);
    HashSet<Customer> findAll();
    Optional<Customer> findByLogin(String login);
}
