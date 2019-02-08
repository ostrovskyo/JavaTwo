package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.service.*;

import java.util.ArrayList;
import java.util.List;

public class UserMenu {

    private List<Action> actions = new ArrayList<>();
    private ServiceProduct productService = new ServiceDefaultProduct();
    private Action exitAction = new ExitAction();
    private Action createUserAction = new CreateProductAction(productService);
    private Action findUserByIdAction = new FindProductByIdAction(productService);

    public void createUserMenu() {
        actions.add(findUserByIdAction);
        actions.add(createUserAction);
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
