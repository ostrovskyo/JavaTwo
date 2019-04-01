package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultShoppingCartService implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public DefaultShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public ShoppingCart findById(Long shoppingCartId) {
        return shoppingCartRepository.getShoppingCartById(shoppingCartId);
//                .orElseThrow(() -> new NoSuchElementException("User not found, id: " + shoppingCartId));
    }
}
