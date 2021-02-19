package com.company.animal;

/**
 * One of the specific animal classes used in the Animal Farm game
 */
public class Boar extends Animal {
    public static final int cost = 350; //cost of the animal

    /**
     * Basic constructor used to create a boar
     * @param name name of the boar
     * @param sex sex of the boar
     * @param type "Boar"
     * @param pluralType "Boars"
     */
    public Boar(String name, String sex, String type, String pluralType) {
        super(name, sex, type, pluralType);
        super.price = cost;
    }
}
