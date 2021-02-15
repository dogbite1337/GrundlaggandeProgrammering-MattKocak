package com.company.animal;

public class Elephant extends Animal {
    public static final int cost = 700;

    public Elephant(String name, String sex, String type, String pluralType) {
        super(name, sex, type, pluralType);
        super.price = cost;
    }
}
