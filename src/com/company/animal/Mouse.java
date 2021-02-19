package com.company.animal;

/**
 * One of the specific animal classes used in the Animal Farm game
 */
public class Mouse extends Animal {
    public static final int cost = 50; //cost of animal

    /**
     * Basic constructor used to create a mouse
     * @param name name of the mouse
     * @param sex sex of the mouse
     * @param type "Mouse"
     * @param pluralType "Mice"
     */
    public Mouse(String name, String sex, String type, String pluralType) {
        super(name, sex, type, pluralType);
        super.price = cost;
    }
}
