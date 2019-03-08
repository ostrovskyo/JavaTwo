package com.javaguru.shoppinglist.service;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ActualPriceCalculation {

    public BigDecimal calculateActualPrice(BigDecimal price, BigDecimal discount) {
        return price.subtract(price.multiply(discount).divide(BigDecimal.valueOf(100)));
    }
}
