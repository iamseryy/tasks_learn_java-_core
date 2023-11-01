package org.task4.model;

public record Order(int order, Customer customer, Product product, int quantity) {
}
