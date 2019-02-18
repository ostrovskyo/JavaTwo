package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateShoppingCartAction implements Action {

    private static final String ACTION_NAME = "Create ShoppingCart";

    private final ProductService productService;

    public CreateShoppingCartAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        String choice = "null";
        Scanner scanner = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();
        ProductRepository database = new ProductRepository();

        System.out.println("Enter Shopping Cart name:");
        String name = scanner.nextLine();

        while (choice != "1") {
            System.out.println("0. Add product to Shopping Cart");
            System.out.println("1. Save Shopping Cart");
            choice = scanner.nextLine();
            switch (choice) {
                case "0":
                    System.out.println("Chose product \"id\" to add: ");
                    database.showAllProducts();
                    productList.add(database.getProductById(Long.valueOf(scanner.nextLine())));
                    break;
                case "1":
                    ShoppingCart shoppingCart = new ShoppingCart();
                    shoppingCart.setName(name);
                    shoppingCart.setProductList(productList);
                    shoppingCart.calculateTotalPrice();

                    try {
                        Long response = productService.createShoppingCart(shoppingCart);
                        System.out.println("Response: " + response);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    return;
            }
        }
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
