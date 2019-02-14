package com.javaguru.shoppinglist.service;

import java.math.BigDecimal;

public class ActualPriceCalculation {

    public BigDecimal calculateActualPrice(BigDecimal price, BigDecimal discount) {
        return price.subtract(price.multiply(discount).divide(BigDecimal.valueOf(100)));
    }
}
