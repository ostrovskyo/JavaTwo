package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Category;
import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;
import java.util.Scanner;

public class CreateProductAction implements Action {

    private static final String ACTION_NAME = "Create Product";

    private final ProductService productService;

    public CreateProductAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose product category:");
        for (Category element : Category.values()) {
            System.out.println(element.getValue() + ". " + element);
        }

        int choice = Integer.valueOf(scanner.nextLine());
        Category category;
        category = Category.values()[choice];

        System.out.println("Enter product name:");
        String name = scanner.nextLine();
        System.out.println("Enter product price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());

        System.out.println("Enter product discount(%): ");
        BigDecimal discount;
        String strDiscount = scanner.nextLine();
        if (strDiscount.equals(null) || strDiscount.equals("")) {
            discount = new BigDecimal(0);
        } else {
            discount = new BigDecimal(strDiscount);
        }

        System.out.println("Enter product Description: ");
        String description = scanner.nextLine();

        ActualPriceCalculation actualPriceCalculation = new ActualPriceCalculation();
        BigDecimal actualPrice = actualPriceCalculation.calculateActualPrice(price, discount);

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDiscount(discount);
        product.setActualPrice(actualPrice);
        product.setDescription(description);
        product.setCategory(category);

        try {
            Long response = productService.create(product);
            System.out.println("Response: " + response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
