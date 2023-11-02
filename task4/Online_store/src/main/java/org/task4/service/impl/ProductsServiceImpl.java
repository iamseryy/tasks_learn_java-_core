package org.task4.service.impl;

import org.task4.model.Product;
import org.task4.repository.Products;
import org.task4.repository.impl.ProductsImpl;
import org.task4.service.ProductService;

import java.util.HashSet;
import java.util.Optional;

public class ProductsServiceImpl implements ProductService {
    private static Products products = ProductsImpl.getInstance();

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public HashSet<Product> findAll() {
        return products.findAll();
    }

    @Override
    public Optional<Product> findByProductName(String name) {
        return products.findByProductName(name);
    }
}
