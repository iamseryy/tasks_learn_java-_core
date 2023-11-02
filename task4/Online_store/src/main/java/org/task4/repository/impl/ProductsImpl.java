package org.task4.repository.impl;

import org.task4.model.Product;
import org.task4.repository.Products;

import java.util.HashSet;
import java.util.Optional;

public class ProductsImpl implements Products {
    private static HashSet<Product> products = new HashSet<>();
    private static ProductsImpl instance;

    private ProductsImpl(){}

    public static ProductsImpl getInstance(){
        if(instance == null){
            instance = new ProductsImpl();
        }

        return instance;
    }


    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public HashSet<Product> findAll() {
        return products;
    }

    @Override
    public Optional<Product> findByProductName(String name) {
        return products.stream().filter(product -> product.productName().equals(name)).findAny();
    }
}
