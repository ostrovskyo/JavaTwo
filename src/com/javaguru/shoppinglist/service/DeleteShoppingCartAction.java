package com.javaguru.shoppinglist.service;

import java.util.Scanner;

public class DeleteShoppingCartAction implements Action {

    private static final String ACTION_NAME = "Delete Shopping Cart by id";

    private final ProductService productService;

    public DeleteShoppingCartAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id: ");
        Long id = scanner.nextLong();
        productService.deleteShoppingCartById(id);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
