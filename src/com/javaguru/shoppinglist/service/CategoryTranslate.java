package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Category;

public class CategoryTranslate {

    private Category category;

    public Category getCategory(String ch) {
        if (ch.equals(Integer.toString(1))) {
            category = Category.FRESH_PRODUCE;
        } else if (ch.equals(Integer.toString(2))) {
            category = Category.MEAT;
        } else if (ch.equals(Integer.toString(3))) {
            category = Category.DAIRY;
        } else if (ch.equals(Integer.toString(4))) {
            category = Category.BREAD;
        } else if (ch.equals(Integer.toString(5))) {
            category = Category.HOUSEHOLD;
        } else if (ch.equals(Integer.toString(6))) {
            category = Category.HEALTH_AND_BEAUTY;
        } else throw new IllegalArgumentException("Illegal category!");
        return category;
    }
}
