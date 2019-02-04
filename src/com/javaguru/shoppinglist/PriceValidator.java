package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class PriceValidator implements Validator {

    @Override
    public boolean validate(String str) {
        return new BigDecimal(str).compareTo(BigDecimal.ZERO) > 0;
    }
}
