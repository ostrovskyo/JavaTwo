package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductDiscountAvailabilityCheck implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        if (product.getPrice().compareTo(BigDecimal.valueOf(20)) < 0 && product.getDiscount().compareTo(BigDecimal.ZERO) != 0) {
            throw new IllegalArgumentException("Error!!! Discount cannot be set if price is less than 20$");
        }
    }
}
