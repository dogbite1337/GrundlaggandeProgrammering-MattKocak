package com.company.animal;

/**
 * Abstract class containing fields and methods used by the animal subclasses
 */
public abstract class Animal {
    protected int price; //cost of the animal
    protected String name; //name of the animal
    protected String sex; //sex of the animal
    protected String type; //String for the type of the animal (ex. Elephant)
    protected String pluralType; //String for the type of the animal in plural form (ex. Elephants)
    protected int health; //health of the animal
    protected int previousHealth; //health of the animal in the previous round

    /**
     * Basic constructor for Animal subclasses
     * @param name name of the animal
     * @param sex sex of the animal
     * @param type type of animal (ex. Elephant)
     * @param pluralType type of animal in plural form (ex. Elephants)
     */
    public Animal(String name, String sex, String type, String pluralType) {
        this.name = name;
        this.sex = sex;
        this.type = type;
        this.pluralType = pluralType;
        this.health = 100;
        this.previousHealth = 100;
    }

    /**
     * Gets the price of the animal
     * @return price of the animal
     */
    public int getPrice() {
        return price;
    }

    /**
     * Gets the name of the animal
     * @return name of the animal
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the sex of the animal
     * @return sex of the animal
     */
    public String getSex() {
        return sex;
    }

    /**
     * Gets the type of the animal (ex. Elephant)
     * @return String with the type of the animal
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the type of the animal in plural form (ex. Elephants)
     * @return String with the type of the animal in plural form
     */
    public String getPluralType() {
        return pluralType;
    }

    /**
     * Gets the current health of the animal
     * @return current health of the animal
     */
    public int getHealth() {
        return health;
    }

    /**
     * Gets the health of the animal during the previous round
     * @return health of the animal during the previous round
     */
    public int getPreviousHealth() {
        return previousHealth;
    }

    /**
     * Increases an animal's health by a given increment
     * @param inc how much to increase an animal's health
     */
    public void increaseHealth(int inc) {
        health = Math.min(health + inc, 100);
    }

    /**
     * Decreases an animal's health by a given decrement
     * @param dec how much to decrease an animal's health by
     * @return True if the animal died, False otherwise
     */
    public boolean decreaseHealth(int dec) {
        previousHealth = health;
        health = Math.max(health - dec, 0);

        return health == 0;
    }
}