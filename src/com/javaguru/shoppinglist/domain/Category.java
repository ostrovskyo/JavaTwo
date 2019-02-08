package com.javaguru.shoppinglist.domain;

public enum Category {
    FRESH_PRODUCE(1),
    MEAT(2),
    DAIRY(3),
    BREAD(4),
    HOUSEHOLD(5),
    HEALTH_AND_BEAUTY(6);

    public final int value;

    Category(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
