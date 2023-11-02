package org.task4.service.impl;

import org.task4.model.Order;
import org.task4.repository.Orders;
import org.task4.repository.impl.OrdersImpl;
import org.task4.service.OrderService;

import java.util.HashSet;

public class OrderServiceImpl implements OrderService {
    private static Orders orders = OrdersImpl.getInstance();

    @Override
    public void add(Order order) {
        orders.add(order);
    }

    @Override
    public HashSet<Order> findAll() {
        return orders.findAll();
    }
}
