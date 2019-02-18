package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;

public interface ProductService {

    Long create(Product product);

    Product findBy(Long id);

    Long saveShoppingCart(ShoppingCart shoppingCart);
}
