package com.company;

public abstract class Animal {
    protected String name;
    protected int sex;
    protected int health;

    public String getName() {
        return name;
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
