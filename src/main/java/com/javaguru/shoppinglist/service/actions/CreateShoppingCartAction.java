package com.javaguru.shoppinglist.service.actions;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.ShoppingCartProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CreateShoppingCartAction implements Action {

    private static final String ACTION_NAME = "Create ShoppingCart";

    private final ProductService productService;

    private final ShoppingCartProductService shoppingCartProductService;

    private final ProductRepository database;

    @Autowired
    public CreateShoppingCartAction(ProductService productService, ProductRepository database, ShoppingCartProductService shoppingCartProductService) {
        this.productService = productService;
        this.database = database;
        this.shoppingCartProductService = shoppingCartProductService;
    }

    @Override
    public void execute() {
        String choice = "null";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Shopping Cart name:");
        String name = scanner.nextLine();

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setName(name);

        try {
            Long response = productService.createShoppingCart(shoppingCart);
            System.out.println("Response: " + response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        while (choice != "1") {
            System.out.println("0. Add product to Shopping Cart");
            System.out.println("1. Save Shopping Cart");
            choice = scanner.nextLine();
            switch (choice) {
                case "0":
                    System.out.println("All product list: ");
                    database.getAllProducts();
                    System.out.println("Chose product \"id\" to add: ");

                    Long productId = Long.valueOf(scanner.nextLine());
                    shoppingCartProductService.addProductToShoppingCart(shoppingCart.getId(), productId);

                    break;
                case "1":
                    return;
            }
        }
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
