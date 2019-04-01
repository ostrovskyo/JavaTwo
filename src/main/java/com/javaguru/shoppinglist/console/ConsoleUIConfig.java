package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.service.actions.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ConsoleUIConfig {

    private final Action createProductAction;
    private final Action createShoppingCartAction;
    private final Action deleteShoppingCartAction;
    private final Action exitAction;
    private final Action findProductByIdAction;
    private final Action findShoppingCartByIdAction;
    private final Action printAllShoppingCartsAction;

    @Autowired
    public ConsoleUIConfig(Action createProductAction, Action createShoppingCartAction, Action deleteShoppingCartAction, Action exitAction, Action findProductByIdAction, Action findShoppingCartByIdAction, Action printAllShoppingCartsAction) {
        this.createProductAction = createProductAction;
        this.createShoppingCartAction = createShoppingCartAction;
        this.deleteShoppingCartAction = deleteShoppingCartAction;
        this.exitAction = exitAction;
        this.findProductByIdAction = findProductByIdAction;
        this.findShoppingCartByIdAction = findShoppingCartByIdAction;
        this.printAllShoppingCartsAction = printAllShoppingCartsAction;
    }

    @Bean
    ConsoleUI ConsoleUI() {
        List<Action> actions = new ArrayList<>();
        actions.add(createProductAction);
        actions.add(createShoppingCartAction);
        actions.add(deleteShoppingCartAction);
        actions.add(findProductByIdAction);
        actions.add(findShoppingCartByIdAction);
        actions.add(printAllShoppingCartsAction);
        actions.add(exitAction);
        MainMenu menu = new MainMenu(actions);
        return new ConsoleUI(menu);
    }
}
