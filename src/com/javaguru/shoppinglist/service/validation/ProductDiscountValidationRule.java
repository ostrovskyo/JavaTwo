package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductDiscountValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        if (Integer.valueOf(product.getDiscount()) < 0 || Integer.valueOf(product.getDiscount()) > 100) {
            throw new IllegalArgumentException("Illegal discount!");
        }
    }
}

