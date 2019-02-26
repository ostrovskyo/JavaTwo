package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.util.HashSet;
import java.util.Set;

public class ProductValidationService {

    private Set<ProductValidationRule> validationRuleSet = new HashSet<>();

    public ProductValidationService() {
        validationRuleSet.add(new ProductNameValidationRule());
        validationRuleSet.add(new ProductPriceValidationRule());
        validationRuleSet.add(new ProductDiscountValidationRule());
        validationRuleSet.add(new ProductUniqueNameValidationRule());
        validationRuleSet.add(new ProductDiscountAvailabilityCheck());
    }

    public void validate(Product product) {
        if (product == null) {
            throw new ProductValidationException("Product must be not null");
        }
        validationRuleSet.forEach(s -> s.validate(product));
    }
}

