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

//        ProductRepository productRepository = new ProductRepository();
//
//        ShoppingCartRepository shoppingCartDatabase = new ShoppingCartRepository();
//
//        ProductValidationRule productNameValidationRule = new ProductNameValidationRule();
//        ProductValidationRule productUniqueNameValidationRule = new ProductUniqueNameValidationRule(productRepository);
//        ProductValidationRule productPriceValidationRule = new ProductPriceValidationRule();
//        ProductValidationRule productDiscountValidationRule = new ProductDiscountValidationRule();
//        ProductValidationRule productDiscountAvailabilityCheck = new ProductDiscountAvailabilityCheck();
//
//        Set<ProductValidationRule> validations = new HashSet<>();
//        validations.add(productNameValidationRule);
//        validations.add(productUniqueNameValidationRule);
//        validations.add(productPriceValidationRule);
//        validations.add(productDiscountValidationRule);
//        validations.add(productDiscountAvailabilityCheck);
//
//        ProductValidationService validationService = new ProductValidationService(validations);
//
//        ProductService productService = new DefaultProductService(productRepository, shoppingCartDatabase, validationService);
//
//        List<Action> actions = new ArrayList<>();
//
//        Action exitAction = new ExitAction();
//        Action createProductAction = new CreateProductAction(productService);
//        Action findProductByIdAction = new FindProductByIdAction(productService);
//        Action createShoppingCartAction = new CreateShoppingCartAction(productService, productRepository);
//        Action findShoppingCartByIdAction = new FindShoppingCartByIdAction(productService);
//        Action printAllShoppingCartsAction = new PrintAllShoppingCartsAction(productService);
//        Action deleteShoppingCartById = new DeleteShoppingCartAction(productService);
//
//        actions.add(findProductByIdAction);
//        actions.add(createProductAction);
//        actions.add(createShoppingCartAction);
//        actions.add(findShoppingCartByIdAction);
//        actions.add(printAllShoppingCartsAction);
//        actions.add(deleteShoppingCartById);
//        actions.add(exitAction);

//        MainMenu menu = new MainMenu(productService, actions);

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConsoleUI ui = context.getBean(ConsoleUI.class);
//        ConsoleUI ui = new ConsoleUI(menu);
        ui.start();
    }
}
