package com.javaguru.shoppinglist.service.actions;

import com.javaguru.shoppinglist.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintAllShoppingCartsAction implements Action {

    private static final String ACTION_NAME = "Print all Shopping Carts";

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public PrintAllShoppingCartsAction(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public void execute() {
        shoppingCartService.printAllShoppingCarts();
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
