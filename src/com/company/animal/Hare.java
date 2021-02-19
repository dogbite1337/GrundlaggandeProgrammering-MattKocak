package com.company.animal;

/**
 * One of the specific animal classes used in the Animal Farm game
 */
public class Hare extends Animal {
    public static final int cost = 100; //cost of the animal

    /**
     * Basic constructor used to create a hare
     * @param name name of the hare
     * @param sex sex of the hare
     * @param type "Hare"
     * @param pluralType "Hares"
     */
    public Hare(String name, String sex, String type, String pluralType) {
        super(name, sex, type, pluralType);
        super.price = cost;
    }
}
