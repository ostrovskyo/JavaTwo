package com.javaguru.shoppinglist.domain;

public enum Category {
    FRESH_PRODUCE(0),
    MEAT(1),
    DAIRY(2),
    BREAD(3),
    HOUSEHOLD(4),
    HEALTH_AND_BEAUTY(5);

    public final int value;

    Category(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
