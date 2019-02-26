package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.console.ConsoleUI;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.DefaultProductService;
import com.javaguru.shoppinglist.service.validation.*;

import java.util.HashSet;
import java.util.Set;

class ShoppingListApplication {

    public static void main(String[] args) {

        ProductRepository productRepository = new ProductRepository();

        ProductValidationRule productNameValidationRule = new ProductNameValidationRule();
        ProductValidationRule productUniqueNameValidationRule = new ProductUniqueNameValidationRule();
        ProductValidationRule productPriceValidationRule = new ProductPriceValidationRule();
        ProductValidationRule productDiscountValidationRule = new ProductDiscountValidationRule();
        ProductValidationRule productDiscountAvailabilityCheck = new ProductDiscountAvailabilityCheck();

        Set<ProductValidationRule> validations = new HashSet<>();
        validations.add(productNameValidationRule);
        validations.add(productUniqueNameValidationRule);
        validations.add(productPriceValidationRule);
        validations.add(productDiscountValidationRule);
        validations.add(productDiscountAvailabilityCheck);

        ProductValidationService validationService = new ProductValidationService(validations);

        DefaultProductService productService = new DefaultProductService(productRepository, validationService);




        ConsoleUI ui = new ConsoleUI();
        ui.start();
    }
}
