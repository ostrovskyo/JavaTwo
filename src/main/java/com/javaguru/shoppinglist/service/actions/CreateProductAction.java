package com.javaguru.shoppinglist.service.actions;

import com.javaguru.shoppinglist.domain.Category;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.mapper.ProductConverter;
import com.javaguru.shoppinglist.service.ActualPriceCalculation;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class CreateProductAction implements Action {

    private static final String ACTION_NAME = "Create Product";

    private final ProductService productService;
    private final ProductConverter productConverter;

    @Autowired
    public CreateProductAction(ProductService productService, ProductConverter productConverter) {
        this.productService = productService;
        this.productConverter = productConverter;
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
        discount = lineUpDiscount(strDiscount);

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

        ProductDto productDto = productConverter.convert(product);

        try {
            Long response = productService.create(productDto);
            System.out.println("Response: " + response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private BigDecimal lineUpDiscount(String strDiscount) {
        BigDecimal discount;
        if (isDiscountFieldEmpty(strDiscount)) {
            discount = new BigDecimal(0);
        } else {
            discount = new BigDecimal(strDiscount);
        }
        return discount;
    }

    private boolean isDiscountFieldEmpty(String strDiscount) {
        return strDiscount == null || strDiscount.equals("");
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
