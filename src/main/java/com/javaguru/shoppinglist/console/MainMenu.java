package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.service.*;
import com.javaguru.shoppinglist.service.actions.*;

import java.util.List;

public class MainMenu {

    private final List<Action> actions;
    private final ProductService productService;

    public MainMenu(ProductService productService, List<Action> actions) {
        this.productService = productService;
        this.actions = actions;
    }

    public Action getAction(int response) {
        return actions.get(response);
    }

    public void printMenu() {
        for (int i = 0; i < actions.size(); i++) {
            System.out.println(i + ". " + actions.get(i));
        }
    }
}
