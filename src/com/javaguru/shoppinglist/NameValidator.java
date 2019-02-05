package com.javaguru.shoppinglist;

public class NameValidator extends AbstractValidator {

    @Override
    public boolean validate(String str) {
        if (!assertNotNull(str)) {
            throw new IllegalArgumentException("Null input!");
        } else if (str.length() < 3 || str.length() > 32) {
            throw new IllegalArgumentException("Illegal name!");
        } else return true;
    }
}
