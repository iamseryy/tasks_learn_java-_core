package org.task4.repository.impl;

import org.task4.model.Order;
import org.task4.repository.Orders;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrdersImpl implements Orders {
    private static HashMap<Integer, Order> orders = new HashMap<>();
    private static OrdersImpl instance;

    private OrdersImpl(){}

    public static OrdersImpl getInstance(){
        if(instance == null){
            instance = new OrdersImpl();
        }

        return instance;
    }


    @Override
    public void add(Order order) {
        orders.put(order.order(), order);
    }

    @Override
    public HashSet<Order> findAll() {
        return new HashSet<>(orders.values().stream().collect(Collectors.toSet()));
    }

    @Override
    public Optional<Order> findLast() {
        if (orders.isEmpty()) {
            return Optional.empty();
        }

        return Optional.ofNullable(orders.get(orders.size()));
    }
}
