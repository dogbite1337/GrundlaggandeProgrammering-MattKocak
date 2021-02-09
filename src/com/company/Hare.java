package com.company;

public class Hare extends Animal {
    public static final int cost = 100;

    public Hare(String name, String sex, String type, String pluralType) {
        super(name, sex, type, pluralType);
        super.price = cost;
    }
}
