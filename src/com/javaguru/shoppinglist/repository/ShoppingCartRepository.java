package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.ShoppingCart;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCartRepository {

    private static final Map<Long, ShoppingCart> database = new HashMap<>();

    public void insertShoppingCart(Long id, ShoppingCart shoppingCart) {
        database.put(id, shoppingCart);
    }

    public void printAllShoppingCarts() {
        for (ShoppingCart element : database.values()) {
            System.out.println(element);
        }
    }

    public ShoppingCart getShoppingCartById(Long id) {
        return database.get(id);
    }

    public void deleteShoppingCartById(Long id) {
        database.remove(id);
    }
}
