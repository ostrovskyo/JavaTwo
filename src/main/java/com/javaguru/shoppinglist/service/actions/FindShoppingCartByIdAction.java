package com.javaguru.shoppinglist.service.actions;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class FindShoppingCartByIdAction implements Action {

    private static final String ACTION_NAME = "Find Shopping Cart by id";

    private final ProductService productService;

    @Autowired
    public FindShoppingCartByIdAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Shopping Cart id: ");
        Long id = scanner.nextLong();
        ShoppingCart response = productService.findShoppingCartById(id);
        System.out.println("Response: " + response);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
