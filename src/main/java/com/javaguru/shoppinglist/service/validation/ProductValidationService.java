package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ProductValidationService {

    private final Set<ProductValidationRule> validationRuleSet;

    @Autowired
    public ProductValidationService(Set<ProductValidationRule> validationRuleSet) {
        this.validationRuleSet = validationRuleSet;
    }

    public void validate(ProductDto productDto) {
        if (productDto == null) {
            throw new ProductValidationException("Product must be not null");
        }
        validationRuleSet.forEach(s -> s.validate(productDto));
    }
}

