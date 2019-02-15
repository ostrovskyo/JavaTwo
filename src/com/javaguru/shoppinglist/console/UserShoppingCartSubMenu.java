package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.service.*;

import java.util.ArrayList;
import java.util.List;

public class UserShoppingCartSubMenu {

    private List<Action> actions = new ArrayList<>();
    private ProductService productService = new DefaultProductService();
//    private ShoppingCartService shoppingCartService = new DefaultShoppingCartService();
//    private Action saveCurrentShoppingCart = new SaveShoppingCartAction(shoppingCartService);

    public void createUserShoppingCartSubMenu() {
//        actions.add(saveCurrentShoppingCart);
//        actions.add(switchShoppingCartById);
//        actions.add(deleteShoppingCartById);
//        actions.add(addProductToCurrentShoppingCartById);
//        actions.add(showCurrentShoppingCartContent);
//        actions.add(showTotalPriceOfProductsInCurrentShoppingCart);
//        actions.add(cancelShoppingCart);
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
