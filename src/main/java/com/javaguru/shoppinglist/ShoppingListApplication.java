package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.console.ConsoleUI;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.DefaultProductService;

class ShoppingListApplication {

    public static void main(String[] args) {

        ProductRepository productRepository = new ProductRepository();
        DefaultProductService defaultProductService = new DefaultProductService(productRepository);


        ConsoleUI ui = new ConsoleUI();
        ui.start();
    }
}
