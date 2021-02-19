package com.company.animal;

/**
 * One of the specific animal classes used in the Animal Farm game
 */
public class Elephant extends Animal {
    public static final int cost = 700; //cost of the animal

    /**
     * Basic constructor used to create a elephant
     * @param name name of the elephant
     * @param sex sex of the elephant
     * @param type "Elephant"
     * @param pluralType "Elephants"
     */
    public Elephant(String name, String sex, String type, String pluralType) {
        super(name, sex, type, pluralType);
        super.price = cost;
    }
}
