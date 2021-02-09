package com.company;

public abstract class Animal {
    protected int price;
    protected String name;
    protected String sex;
    protected String type;
    protected String pluralType;
    protected int health;

    public Animal(String name, String sex, String type, String pluralType) {
        this.name = name;
        this.sex = sex;
        this.type = type;
        this.pluralType = pluralType;
        this.health = 100;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getType() {
        return type;
    }

    public String getPluralType() {
        return pluralType;
    }

    public int getHealth() {
        return health;
    }

    public void increaseHealth(int inc) {
        health = Math.min(health + inc, 100);
    }

    public boolean decreaseHealth(int dec) {
        health = Math.max(health - dec, 0);

        if (health == 0) {
            return true;
        }

        return false;
    }
}
