package com.company;

public abstract class Animal {
    protected String name;
    protected String sex;
    protected int health;
    protected String type;

    public Animal(String name, String sex, String type) {
        this.name = name;
        this.sex = sex;
        this.type = type;
        this.health = 100;
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
