package com.javaguru.shoppinglist;

public abstract class AbstractValidator implements Validator {

    boolean assertNotNull(String str) {
        return str != null && !str.isEmpty();
    }
}
