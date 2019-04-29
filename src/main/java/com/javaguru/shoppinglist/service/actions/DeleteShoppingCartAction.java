package com.javaguru.shoppinglist.service.actions;

import com.javaguru.shoppinglist.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class DeleteShoppingCartAction implements Action {

    private static final String ACTION_NAME = "Delete Shopping Cart by id";

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public DeleteShoppingCartAction(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id: ");
        Long id = scanner.nextLong();
        shoppingCartService.deleteShoppingCartById(id);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
