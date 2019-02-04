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
        Validator priceValidator = new PriceValidator();
        Validator discountValidator = new DiscountValidator();
        Validator nameValidator = new NameValidator();

        Category category;
        System.out.println("1.FRESH_PRODUCE,\n" +
                "2.MEAT,\n" +
                "3.DAIRY,\n" +
                "4.BREAD,\n" +
                "5.HOUSEHOLD,\n" +
                "6.HEALTH_AND_BEAUTY");
        String ch = scanner.nextLine();
        if(ch.equals(Integer.toString(1))) {category = Category.FRESH_PRODUCE;}
        else if(ch.equals(Integer.toString(2))) {category = Category.MEAT;}
        else if(ch.equals(Integer.toString(3))) {category = Category.DAIRY;}
        else if(ch.equals(Integer.toString(4))) {category = Category.BREAD;}
        else if(ch.equals(Integer.toString(5))) {category = Category.HOUSEHOLD;}
        else if(ch.equals(Integer.toString(6))) {category = Category.HEALTH_AND_BEAUTY;}
        else throw new IllegalArgumentException("Illegal category!");

        System.out.println("Enter product name:");
        String name = scanner.nextLine();
        System.out.println("Enter product price: ");
        String price = scanner.nextLine();

        System.out.println("Enter product discount(%): ");
        String discount = scanner.nextLine();
        System.out.println("Enter product Description: ");
        String description = scanner.nextLine();

        if(!nameValidator.validate(name)){ throw new IllegalArgumentException("Illegal name!"); }
        if(!priceValidator.validate(price)){ throw new IllegalArgumentException("Illegal price!"); }
        if(!discountValidator.validate(discount)){ throw new IllegalArgumentException("Illegal discount!"); }

        Product product = new Product();
        product.setName(name);
        product.setPrice(new BigDecimal(price));
        product.setDiscount(Integer.valueOf(discount));
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
