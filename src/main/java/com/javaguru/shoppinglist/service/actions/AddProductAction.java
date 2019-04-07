package com.javaguru.shoppinglist.service.actions;

import com.javaguru.shoppinglist.service.ShoppingCartProductService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AddProductAction implements Action {

    private static final String ACTION_NAME = "Add product";

    private final ShoppingCartProductService shoppingCartProductService;

    public AddProductAction(ShoppingCartProductService shoppingCartProductService) {
        this.shoppingCartProductService = shoppingCartProductService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter shopping cart id:");
        Long userId = scanner.nextLong();
        System.out.println("Enter product id: ");
        Long taskId = scanner.nextLong();

        Long response = shoppingCartProductService.addProductToShoppingCart(userId, taskId);
        System.out.println("Response: " + response);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
