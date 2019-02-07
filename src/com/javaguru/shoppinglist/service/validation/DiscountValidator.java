package com.javaguru.shoppinglist.service.validation;

public class DiscountValidator implements Validator {

    @Override
    public boolean validate(String str) {
        if (Integer.valueOf(str) < 0 || Integer.valueOf(str) > 100) {
            throw new IllegalArgumentException("Illegal discount!");
        } else return true;
    }
}
