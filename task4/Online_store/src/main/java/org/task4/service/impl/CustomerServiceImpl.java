package org.task4.service.impl;

import org.task4.exception.WrongLoginException;
import org.task4.exception.WrongPasswordException;
import org.task4.model.Customer;
import org.task4.repository.Customers;
import org.task4.repository.impl.CustomersImpl;
import org.task4.service.CustomerService;

import java.util.HashSet;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {
    private static Customers customers = CustomersImpl.getInstance();

    @Override
    public void add(Customer customer) {
        customers.add(customer);
    }

    @Override
    public HashSet<Customer> findAll() {
        return customers.findAll();
    }

    @Override
    public Optional<Customer> findByLogin(String login) {
        return customers.findByLogin(login);
    }
}
