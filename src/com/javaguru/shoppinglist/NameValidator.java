package com.javaguru.shoppinglist;

public class NameValidator extends AbstractValidator{

    @Override
    public boolean validate(String str) {
        if(!assertNotNull(str)){
            return false;
        }

        return str.length() > 2 && str.length() < 33;
    }
}
