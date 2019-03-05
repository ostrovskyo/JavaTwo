package com.javaguru.shoppinglist.service.actions;

import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintAllShoppingCartsAction implements Action {

    private static final String ACTION_NAME = "Print all Shopping Carts";

    private final ProductService productService;

    @Autowired
    public PrintAllShoppingCartsAction(ProductService productService) {
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
