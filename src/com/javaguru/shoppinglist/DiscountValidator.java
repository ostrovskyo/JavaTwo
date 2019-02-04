package com.javaguru.shoppinglist;

public class DiscountValidator implements Validator{

    @Override
    public boolean validate(String str) {
        return Integer.valueOf(str) >= 0 && Integer.valueOf(str) <= 100;
    }
}
