package org.task4.repository;


import org.task4.model.Product;
import java.util.HashSet;
import java.util.Optional;

public interface Products {
    void add(Product product);
    HashSet<Product> findAll();
    Optional<Product> findByProductName(String name);
}
