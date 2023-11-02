package org.task4;

import org.task4.exception.*;
import org.task4.model.Customer;
import org.task4.model.Product;
import org.task4.service.CustomerService;
import org.task4.service.OrderService;
import org.task4.service.ProductService;
import org.task4.service.impl.CustomerServiceImpl;
import org.task4.service.impl.OrderServiceImpl;
import org.task4.service.impl.ProductsServiceImpl;

public class App {
    public static CustomerService customerService = new CustomerServiceImpl();
    public static ProductService productService = new ProductsServiceImpl();
    public static OrderService orderService = new OrderServiceImpl();


    public static void main( String[] args ) {

        //Task1. Checking login and password
        task1();

        //Task2. Online store emulation
        task2();
    }

    public static void task1(){
        System.out.println("Task1. Checking login and password");
        try {
            if (CustomerService.isValid("user1", "password", "password")) {
                System.out.println("Login and password are valid");
            };
        } catch (WrongLoginException e){
            System.out.printf(e.getMessage());
        } catch (WrongPasswordException e){
            System.out.printf(e.getMessage());
        }
    }

    public static void task2(){
        customerService.add(new Customer("customer1"));
        customerService.add(new Customer("customer2"));
        customerService.add(new Customer("customer3"));
        customerService.add(new Customer("customer4"));
        productService.add(new Product("product1", 100.0));
        productService.add(new Product("product2", 110.0));
        productService.add(new Product("product3", 120.0));
        productService.add(new Product("product4", 130.0));
        productService.add(new Product("product5", 140.0));

        //создать массив покупателей, массив товаров;
        var customers = customerService.findAll().toArray(new Customer[0]);
        var products = productService.findAll().toArray(new Product[0]);

        System.out.println("\nTask2. Online store emulation");

        // Вызвать метод совершения покупки несколько раз таким образом,
        // чтобы заполнить массив покупок возвращаемыми значениями. Обработать исключения.
        try {
            System.out.println("Order placed: " + OrderService.makeOrder("customer2", "product3", 10));
        } catch (WrongCustomerException | WrongProductException | WrongQuantityException ex){
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println("Order placed: " + OrderService.makeOrder("customer33", "product1", 20));
        } catch (WrongCustomerException | WrongProductException | WrongQuantityException ex){
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println("Order placed: " + OrderService.makeOrder("customer4", "product4", 30));
        } catch (WrongCustomerException | WrongProductException | WrongQuantityException ex){
            System.out.println(ex.getMessage());
        }

        //Вывести в консоль итоговое количество совершённых покупок после выполнения приложения.
        System.out.println("\nTotal orders: " + orderService.findAll().size());
    }

}
