package com.javaguru.shoppinglist.service.validation;

import java.math.BigDecimal;

import com.javaguru.shoppinglist.domain.Product;

public class ProductPriceValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        if (product.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Illegal price!");
        }
    }
}
