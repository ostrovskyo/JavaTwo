package com.javaguru.shoppinglist.service.actions;

import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

public class PrintAllProductsAction implements Action{

    private static final String ACTION_NAME = "Print all Products";

    private final ProductService productService;

    @Autowired
    public PrintAllProductsAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        productService.printAllShoppingCarts();
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
