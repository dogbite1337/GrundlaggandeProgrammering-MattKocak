package com.company.animal;

public class Boar extends Animal {
    public static final int cost = 350;

    public Boar(String name, String sex, String type, String pluralType) {
        super(name, sex, type, pluralType);
        super.price = cost;
    }
}
