package com.javaguru.shoppinglist.service.actions;

import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.actions.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class DeleteShoppingCartAction implements Action {

    private static final String ACTION_NAME = "Delete Shopping Cart by id";

    private final ProductService productService;

    @Autowired
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
