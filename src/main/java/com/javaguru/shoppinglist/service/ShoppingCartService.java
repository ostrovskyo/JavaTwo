package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.dto.ShoppingCartDto;

import java.util.List;

public interface ShoppingCartService {

    ShoppingCart findById(Long shoppingCartId);

    List<ShoppingCartDto> printAllShoppingCarts();

    void deleteShoppingCartById(Long id);

}
