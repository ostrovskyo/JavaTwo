package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.service.actions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MainMenu {

    private final List<Action> actions;

    @Autowired
    public MainMenu(List<Action> actions) {
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
