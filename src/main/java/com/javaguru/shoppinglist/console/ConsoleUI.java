package com.javaguru.shoppinglist.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

//@Component
public class ConsoleUI {

    private final MainMenu menu;

//    @Autowired
    public ConsoleUI(MainMenu menu) {
        this.menu = menu;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int response = 0;

        while (response >= 0) {
            menu.printMenu();
            try {
                response = scanner.nextInt();
                menu.getAction(response).execute();
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }
}
