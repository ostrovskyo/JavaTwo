package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.ShoppingCart;

import java.util.List;

public interface ShoppingCartRepository {

    Long insertShoppingCart(ShoppingCart shoppingCart);

    List<ShoppingCart> getAllShoppingCarts();

    ShoppingCart getShoppingCartById(Long id);

    void deleteShoppingCartById(Long id);
}
