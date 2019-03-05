package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductDiscountValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getDiscount().compareTo(BigDecimal.ZERO) < 0 || product.getDiscount().compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new IllegalArgumentException("Illegal discount!");
        }
    }
}

