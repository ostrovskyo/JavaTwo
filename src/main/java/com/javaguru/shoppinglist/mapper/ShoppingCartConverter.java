package com.javaguru.shoppinglist.mapper;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.dto.ShoppingCartDto;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartConverter {

    public ShoppingCart convert(ShoppingCartDto shoppingCartDto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(shoppingCartDto.getId());
        shoppingCart.setName(shoppingCartDto.getName());
        return shoppingCart;
    }

    public ShoppingCartDto convert(ShoppingCart shoppingCart) {
        ShoppingCartDto shoppingCartDto = new ShoppingCartDto();
        shoppingCartDto.setId(shoppingCart.getId());
        shoppingCartDto.setName(shoppingCart.getName());
        return shoppingCartDto;
    }
}
