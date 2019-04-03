package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.ShoppingCart;

public interface ShoppingCartRepository {

//    Long insertShoppingCart(Long id, ShoppingCart shoppingCart);
    Long insertShoppingCart(ShoppingCart shoppingCart);

    void printAllShoppingCarts();

    ShoppingCart getShoppingCartById(Long id);

    void deleteShoppingCartById(Long id);
}
