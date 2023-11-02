package org.task4.service;

import org.task4.exception.WrongCustomerException;
import org.task4.exception.WrongProductException;
import org.task4.exception.WrongQuantityException;
import org.task4.model.Order;
import org.task4.repository.Orders;
import org.task4.repository.impl.OrdersImpl;
import org.task4.service.impl.CustomerServiceImpl;
import org.task4.service.impl.ProductsServiceImpl;

import java.util.HashSet;

public interface OrderService {
    CustomerService customerService = new CustomerServiceImpl();
    ProductService productService = new ProductsServiceImpl();
    Orders orders = OrdersImpl.getInstance();

    void add(Order order);
    HashSet<Order> findAll();


    //создать статический метод “совершить покупку” со строковыми параметрами, соответствующими полям объекта заказа. .
    // Метод должен вернуть объект заказа
    static Order makeOrder(String customerLogin, String productName, int quantity) throws WrongCustomerException, WrongProductException,
            WrongQuantityException {

        var customer = customerService.findByLogin(customerLogin);
        if(customer.isEmpty()){
            throw new WrongCustomerException("Buyer not registered: " + customerLogin);
        }

        var product = productService.findByProductName(productName);
        if(product.isEmpty()){
            throw new WrongProductException("Product not found: " + productName);
        }

        if(quantity < 1){
            throw new WrongQuantityException("Wrong quantity: " + quantity);
        }

        var serial = 1;
        var lastOrder = orders.findLast();

        if (lastOrder.isPresent()){
            serial = lastOrder.get().order() + 1;
        }

        var order = new Order(serial, customer.get(), product.get(), quantity);

        orders.add(order);

        return order;
    }
}
