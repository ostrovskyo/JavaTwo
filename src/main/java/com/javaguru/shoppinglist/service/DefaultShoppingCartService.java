package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.dto.ShoppingCartDto;
import com.javaguru.shoppinglist.mapper.ShoppingCartConverter;
import com.javaguru.shoppinglist.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultShoppingCartService implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ShoppingCartConverter shoppingCartConverter;

    @Autowired
    public DefaultShoppingCartService(ShoppingCartRepository shoppingCartRepository,
                                      ShoppingCartConverter shoppingCartConverter) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.shoppingCartConverter = shoppingCartConverter;
    }

    @Override
    public ShoppingCart findById(Long shoppingCartId) {
        return shoppingCartRepository.getShoppingCartById(shoppingCartId);
    }

    @Override
    public void deleteShoppingCartById(Long id) {
        shoppingCartRepository.deleteShoppingCartById(id);
    }

    @Override
    public List<ShoppingCartDto> printAllShoppingCarts() {
            return shoppingCartRepository.getAllShoppingCarts().stream()
                    .map(shoppingCartConverter::convert)
                    .collect(Collectors.toList());

    }
}
