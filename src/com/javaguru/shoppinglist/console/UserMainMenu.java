package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.service.*;

import java.util.ArrayList;
import java.util.List;

public class UserMainMenu {

    private List<Action> actions = new ArrayList<>();
    private ProductService productService = new DefaultProductService();
    private Action exitAction = new ExitAction();
    private Action createProductAction = new CreateProductAction(productService);
    private Action findProductByIdAction = new FindProductByIdAction(productService);
    private Action createShoppingCartAction = new CreateShoppingCartAction(productService);

    public void createUserMenu() {
        actions.add(findProductByIdAction);
        actions.add(createProductAction);
        actions.add(createShoppingCartAction);
        actions.add(exitAction);
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
