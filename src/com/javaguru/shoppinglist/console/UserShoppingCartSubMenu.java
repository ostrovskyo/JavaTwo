package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.service.Action;
import com.javaguru.shoppinglist.service.ExitAction;

import java.util.ArrayList;
import java.util.List;

public class UserShoppingCartSubMenu {

    private Action exitAction = new ExitAction();

    private List<Action> actions = new ArrayList<>();

    public void createUserShoppingCartSubMenu() {
        actions.add(saveAction);
        actions.add(exitAction);

//        actions.add(switchShoppingCartById);
//        actions.add(deleteShoppingCartById);
//        actions.add(addProductToCurrentShoppingCartById);
//        actions.add(showCurrentShoppingCartContent);
//        actions.add(showTotalPriceOfProductsInCurrentShoppingCart);
    }

    public void printMenu() {
        for (int i = 0; i < actions.size(); i++) {
            System.out.println(i + ". " + actions.get(i));
        }
    }
}
