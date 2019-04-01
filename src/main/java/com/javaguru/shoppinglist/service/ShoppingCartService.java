package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ShoppingCart;

public interface ShoppingCartService {

    ShoppingCart findById(Long shoppingCartId);

}
