package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {

    private static final Map<Long, Product> database = new HashMap<>();

    public Product getProductById(Long id) {
        return database.get(id);
    }

    public void insertProduct(Long id, Product product) {
        database.put(id, product);
    }

    public Product getProductByName(String name) {
        for (Product element : database.values()) {
            if (element.getName().equals(name)) {
                return element;
            }
        }
        return null;
    }

    public void showAllProducts() {
        for (Product element : database.values()) {
            System.out.println(element);
        }
    }
}
