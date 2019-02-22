package com.javaguru.shoppinglist.service.actions;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.actions.Action;

import java.util.Scanner;

public class FindProductByIdAction implements Action {

    private static final String ACTION_NAME = "Find Product by id";

    private final ProductService productService;

    public FindProductByIdAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id: ");
        Long id = scanner.nextLong();
        Product response = productService.findBy(id);
        System.out.println("Response: " + response);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
