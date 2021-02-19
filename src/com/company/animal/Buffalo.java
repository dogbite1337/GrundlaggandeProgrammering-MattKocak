package com.company.animal;

/**
 * One of the specific animal classes used in the Animal Farm game
 */
public class Buffalo extends Animal {
    public static final int cost = 500; //cost of the animal

    /**
     * Basic constructor used to create a buffalo
     * @param name name of the buffalo
     * @param sex sex of the buffalo
     * @param type "Buffalo"
     * @param pluralType "Buffaloes"
     */
    public Buffalo(String name, String sex, String type, String pluralType) {
        super(name, sex, type, pluralType);
        super.price = cost;
    }
}
