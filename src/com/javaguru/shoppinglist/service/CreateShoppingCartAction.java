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

        System.out.println("Enter shopping cart name:");
        String name = scanner.nextLine();

        System.out.println("Enter shopping cart description:");
        String description = scanner.nextLine();

        while (choice != "1") {
            System.out.println("0. Add product to shopping cart");
            System.out.println("1. Save shopping cart");
            choice = scanner.nextLine();
            switch (choice) {
                case "0" :
                    System.out.println("Chose product \"id\" to add: ");
                    database.showAllProducts();
                    productList.add(database.getProductById(Long.valueOf(scanner.nextLine())));
                    break;
                case "1" :
                    return;
            }
        }

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setName(name);
        shoppingCart.setDescription(description);
        shoppingCart.setProductList(productList);

        try {
            Long response = productService.createShoppingCart(shoppingCart);
            System.out.println("Response: " + response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
