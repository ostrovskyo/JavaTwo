package com.javaguru.shoppinglist.service.validation;

public abstract class AbstractValidator implements Validator {

    public boolean assertNotNull(String str) {
        return str != null && !str.isEmpty();
    }
}
