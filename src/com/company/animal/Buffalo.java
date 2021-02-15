package com.company.animal;

public class Buffalo extends Animal {
    public static final int cost = 500;

    public Buffalo(String name, String sex, String type, String pluralType) {
        super(name, sex, type, pluralType);
        super.price = cost;
    }
}
