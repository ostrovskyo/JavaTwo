package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ShoppingCart;

public class SaveAction implements Action {


    private static final String ACTION_NAME = "Save Shopping Cart";

    private final ProductService productService;

    public Long saveShoppingCart(ShoppingCart shoppingCart) {

    }

    public SaveProductAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
    }
}
