package com.company;
import java.util.*;

public class Player {
    private static final int STARTMONEY = 1000;
    private String name;
    private int money;
    private ArrayList<Elephant> maleElephant;
    private ArrayList<Elephant> femaleElephant;
    private ArrayList<Buffalo> maleBuffalo;
    private ArrayList<Buffalo> femaleBuffalo;
    private ArrayList<Boar> maleBoar;
    private ArrayList<Boar> femaleBoar;
    private ArrayList<Hare> maleHare;
    private ArrayList<Hare> femaleHare;
    private ArrayList<Mouse> maleMouse;
    private ArrayList<Mouse> femaleMouse;

    public Player(String name) {
        this.name = name;
        this.money = STARTMONEY;
        maleElephant = new ArrayList<>();
        femaleElephant = new ArrayList<>();
        maleBuffalo = new ArrayList<>();
        femaleBuffalo = new ArrayList<>();
        maleBoar = new ArrayList<>();
        femaleBoar = new ArrayList<>();
        maleHare = new ArrayList<>();
        femaleHare = new ArrayList<>();
        maleMouse = new ArrayList<>();
        femaleMouse = new ArrayList<>();
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

    public void buyElephant(String name, int sex) {
        if (sex == 1) {
            maleElephant.add(new Elephant(name, sex));
        } else {
            femaleElephant.add(new Elephant(name, sex));
        }

        this.money -= Elephant.cost;
    }

    public void buyBuffalo(String name, int sex) {
        if (sex == 1) {
            maleBuffalo.add(new Buffalo(name, sex));
        } else {
            femaleBuffalo.add(new Buffalo(name, sex));
        }

        this.money -= Buffalo.cost;
    }

    public void buyBoar(String name, int sex) {
        if (sex == 1) {
            maleBoar.add(new Boar(name, sex));
        } else {
            femaleBoar.add(new Boar(name, sex));
        }

        this.money -= Boar.cost;
    }

    public void buyHare(String name, int sex) {
        if (sex == 1) {
            maleHare.add(new Hare(name, sex));
        } else {
            femaleHare.add(new Hare(name, sex));
        }

        this.money -= Hare.cost;
    }

    public void buyMouse(String name, int sex) {
        if (sex == 1) {
            maleMouse.add(new Mouse(name, sex));
        } else {
            femaleMouse.add(new Mouse(name, sex));
        }

        this.money -= Mouse.cost;
    }
}
