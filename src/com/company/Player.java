package com.company;

public class Player {
    private static final int STARTMONEY = 1000;
    private String name;
    private int money;

    public Player(String name) {
        this.name = name;
        this.money = STARTMONEY;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
