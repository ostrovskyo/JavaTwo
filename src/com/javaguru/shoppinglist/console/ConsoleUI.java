package com.javaguru.shoppinglist.console;

import java.util.Scanner;

public class ConsoleUI {

    private UserMenu menu = new UserMenu();

    public void start() {
        menu.createUserMenu();
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
