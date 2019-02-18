package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;

public interface ProductService {

    Long create(Product product);

    Product findBy(Long id);

    Long createShoppingCart(ShoppingCart shoppingCart);

    ShoppingCart selectShoppingCart(Long id);
}
