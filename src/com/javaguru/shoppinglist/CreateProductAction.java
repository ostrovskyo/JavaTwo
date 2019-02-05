package com.javaguru.shoppinglist;

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
        System.out.println("1.FRESH_PRODUCE");
        System.out.println("2.MEAT");
        System.out.println("3.DAIRY");
        System.out.println("4.BREAD");
        System.out.println("5.HOUSEHOLD");
        System.out.println("6.HEALTH_AND_BEAUTY");
        String ch = scanner.nextLine();
        Category category;
        if (ch.equals(Integer.toString(1))) {
            category = Category.FRESH_PRODUCE;
        } else if (ch.equals(Integer.toString(2))) {
            category = Category.MEAT;
        } else if (ch.equals(Integer.toString(3))) {
            category = Category.DAIRY;
        } else if (ch.equals(Integer.toString(4))) {
            category = Category.BREAD;
        } else if (ch.equals(Integer.toString(5))) {
            category = Category.HOUSEHOLD;
        } else if (ch.equals(Integer.toString(6))) {
            category = Category.HEALTH_AND_BEAUTY;
        } else throw new IllegalArgumentException("Illegal category!");

        System.out.println("Enter product name:");
        String name = scanner.nextLine();
        System.out.println("Enter product price: ");
        String price = scanner.nextLine();
        System.out.println("Enter product discount(%): ");
        String discount = scanner.nextLine();
        System.out.println("Enter product Description: ");
        String description = scanner.nextLine();

        Product product = new Product();
        if (new NameValidator().validate(name)) {
            product.setName(name);
        }
        if (new PriceValidator().validate(price)) {
            product.setPrice(new BigDecimal(price));
        }
        if (new DiscountValidator().validate(discount)) {
            product.setDiscount(Integer.valueOf(discount));
        }
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
