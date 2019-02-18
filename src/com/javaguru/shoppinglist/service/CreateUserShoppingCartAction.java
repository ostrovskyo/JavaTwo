package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.console.UserShoppingCartSubMenu;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.repository.ShoppingCartRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateUserShoppingCartAction implements Action {

    private static final String ACTION_NAME = "Create ShoppingCart";

    private final ProductService productService;

    private UserShoppingCartSubMenu menu = new UserShoppingCartSubMenu();

    private ProductRepository productDatabase = new ProductRepository();

    private ShoppingCartRepository shoppingCartDatabase = new ShoppingCartRepository();

    public CreateUserShoppingCartAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter shopping cart name:");
        String name = scanner.nextLine();
        String choice = "null";
        List<Product> productList = new ArrayList<>();


        menu.printMenu();

//        while(!"save".equals(choice)) {
//            productDatabase.showAllProducts();
//            System.out.println("Chose product \"id\" to add: ");
//            choice = scanner.nextLine();
//            productList.add(productDatabase.getProductById(Long.valueOf(choice)));
//        }

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setName(name);
        shoppingCart.setProductList(productList);
        productService.saveShoppingCart(shoppingCart);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
