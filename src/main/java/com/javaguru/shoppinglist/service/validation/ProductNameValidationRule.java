package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductNameValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getName() == null || product.getName().equals("")) {
            throw new IllegalArgumentException("Name cannot be null!");
        } else if (product.getName().length() < 3 || product.getName().length() > 32) {
            throw new IllegalArgumentException("Illegal name!");
        }
    }
}
