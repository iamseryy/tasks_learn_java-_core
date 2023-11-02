package org.task4.repository.impl;

import org.task4.model.Customer;
import org.task4.repository.Customers;

import java.util.HashSet;
import java.util.Optional;

public class CustomersImpl implements Customers {
    private static HashSet<Customer> customers = new HashSet<>();
    private static CustomersImpl instance;

    private CustomersImpl(){}

    public static CustomersImpl getInstance(){
        if(instance == null){
            instance = new CustomersImpl();
        }

        return instance;
    }

    @Override
    public void add(Customer customer) {
        customers.add(customer);
    }

    @Override
    public HashSet<Customer> findAll() {
        return customers;
    }

    @Override
    public Optional<Customer> findByLogin(String login) {
        return customers.stream().filter(customer -> customer.login().equals(login)).findAny();
    }
}
