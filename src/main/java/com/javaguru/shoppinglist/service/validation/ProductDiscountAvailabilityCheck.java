package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductDiscountAvailabilityCheck implements ProductValidationRule {

    private static final int DISCOUNT_MARGIN = 20;

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (isPriceBehindDiscountMargin(product.getPrice())) {
            throw new IllegalArgumentException("Error!!! Discount cannot be set if price is less than 20$");
        }
    }

    private boolean isPriceBehindDiscountMargin(BigDecimal price) {
       return price.compareTo(BigDecimal.valueOf(DISCOUNT_MARGIN)) < 0 && price.compareTo(BigDecimal.ZERO) != 0;
    }
}
