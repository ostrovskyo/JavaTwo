package com.javaguru.shoppinglist.service;

public class PrintAllShoppingCartsAction implements Action {

    private static final String ACTION_NAME = "Print all Shopping Carts";

    private final ProductService productService;

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
