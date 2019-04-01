package com.javaguru.shoppinglist.console;

import java.util.Scanner;

public class ConsoleUI {

    private final MainMenu menu;

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
