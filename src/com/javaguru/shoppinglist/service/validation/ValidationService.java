package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.util.HashSet;
import java.util.Set;

public class ValidationService {

    private Set<ProductValidationRule> validationRuleSet = new HashSet<>();

    public ValidationService() {
        validationRuleSet.add(new ProductNameValidationRule());
        validationRuleSet.add(new ProductPriceValidationRule());
        validationRuleSet.add(new ProductDiscountValidationRule());
    }

    public void validate(Product product) {
        if (product == null) {
            throw new ProductValidationException("Product must be not null");
        }
        validationRuleSet.forEach(s -> s.validate(product));
    }
}

