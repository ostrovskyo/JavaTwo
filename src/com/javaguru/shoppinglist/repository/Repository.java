package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class Repository {

    private Map<Long, Product> database = new HashMap<>();

    public Product getProductById(Long id) {
        return database.get(id);
    }

    public void insertProduct(Long id, Product product) {
        database.put(id, product);
    }
}
