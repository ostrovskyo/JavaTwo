package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class PriceValidator implements Validator {

    @Override
    public boolean validate(String str) {
        if (new BigDecimal(str).compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Illegal price!");
        } else return true;
    }
}
