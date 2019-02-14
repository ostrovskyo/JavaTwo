package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.repository.ProductRepository;

import java.util.Scanner;

public class CreateUserShoppingCartAction implements Action {

    private static final String ACTION_NAME = "Create ShoppingCart";

    private final ProductService productService;

    public CreateUserShoppingCartAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter shopping cart name:");
        String name = scanner.nextLine();
        System.out.println("Chose product \"id\" to add: ");

        ProductRepository datebase = new ProductRepository();
        datebase.showAllProducts();


    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
