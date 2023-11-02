package org.task4.repository;

import org.task4.model.Order;

import java.util.HashSet;
import java.util.Optional;

public interface Orders {
    void add(Order order);
    HashSet<Order> findAll();
    Optional<Order> findLast();
}
