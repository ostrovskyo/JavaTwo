package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;

public interface ProductService {

    Long create(Product product);

    Product findById(Long id);

    Long createShoppingCart(ShoppingCart shoppingCart);

    ShoppingCart findShoppingCartById(Long id);

    void printAllShoppingCarts();

    void deleteShoppingCartById(Long id);
}
