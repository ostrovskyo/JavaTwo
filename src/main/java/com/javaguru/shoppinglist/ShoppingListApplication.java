package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.config.AppConfig;
import com.javaguru.shoppinglist.console.ConsoleUI;
import com.javaguru.shoppinglist.console.MainMenu;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.repository.ShoppingCartRepository;
import com.javaguru.shoppinglist.service.DefaultProductService;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.actions.*;
import com.javaguru.shoppinglist.service.validation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ShoppingListApplication {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConsoleUI ui = context.getBean(ConsoleUI.class);
        ui.start();
    }
}
