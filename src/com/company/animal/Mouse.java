package com.company.animal;

public class Mouse extends Animal {
    public static final int cost = 50;

    public Mouse(String name, String sex, String type, String pluralType) {
        super(name, sex, type, pluralType);
        super.price = cost;
    }
}
