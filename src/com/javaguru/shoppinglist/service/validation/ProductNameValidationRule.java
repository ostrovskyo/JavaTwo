package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductNameValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        if (product.getName().equals(null) || product.getName().equals("")) {
            throw new IllegalArgumentException("Null input!");
        } else if (product.getName().length() < 3 || product.getName().length() > 32) {
            throw new IllegalArgumentException("Illegal name!");
        }
    }
}
