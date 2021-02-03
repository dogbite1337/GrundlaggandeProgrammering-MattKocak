package com.company;
import java.util.*;

public class Player {
    private static final int STARTMONEY = 1000;
    private String name;
    private int money;
    private ArrayList<ArrayList<Animal>> animalList;
    private ArrayList<Animal> maleElephant;
    private ArrayList<Animal> femaleElephant;
    private ArrayList<Animal> maleBuffalo;
    private ArrayList<Animal> femaleBuffalo;
    private ArrayList<Animal> maleBoar;
    private ArrayList<Animal> femaleBoar;
    private ArrayList<Animal> maleHare;
    private ArrayList<Animal> femaleHare;
    private ArrayList<Animal> maleMouse;
    private ArrayList<Animal> femaleMouse;
    private int hay;
    private int soy;
    private int pellets;

    public Player(String name) {
        this.name = name;
        this.money = STARTMONEY;
        animalList = new ArrayList<>();
        maleElephant = new ArrayList<>();
        animalList.add(maleElephant);
        femaleElephant = new ArrayList<>();
        animalList.add(femaleElephant);
        maleBuffalo = new ArrayList<>();
        animalList.add(maleBuffalo);
        femaleBuffalo = new ArrayList<>();
        animalList.add(femaleBuffalo);
        maleBoar = new ArrayList<>();
        animalList.add(maleBoar);
        femaleBoar = new ArrayList<>();
        animalList.add(femaleBoar);
        maleHare = new ArrayList<>();
        animalList.add(maleHare);
        femaleHare = new ArrayList<>();
        animalList.add(femaleHare);
        maleMouse = new ArrayList<>();
        animalList.add(maleMouse);
        femaleMouse = new ArrayList<>();
        animalList.add(femaleMouse);
        this.hay = 0;
        this.soy = 0;
        this.pellets = 0;
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

    public int getHay() {
        return hay;
    }

    public int getSoy() {
        return soy;
    }

    public int getPellets() {
        return pellets;
    }

    public void buyElephant(String name, String sex) {
        if (sex.equals("Male")) {
            maleElephant.add(new Elephant(name, sex, "Elephant"));
        } else {
            femaleElephant.add(new Elephant(name, sex, "Elephant"));
        }

        this.money -= Elephant.cost;
    }

    public void buyBuffalo(String name, String sex) {
        if (sex.equals("Male")) {
            maleBuffalo.add(new Buffalo(name, sex, "Buffalo"));
        } else {
            femaleBuffalo.add(new Buffalo(name, sex, "Buffalo"));
        }

        this.money -= Buffalo.cost;
    }

    public void buyBoar(String name, String sex) {
        if (sex.equals("Male")) {
            maleBoar.add(new Boar(name, sex, "Boar"));
        } else {
            femaleBoar.add(new Boar(name, sex, "Boar"));
        }

        this.money -= Boar.cost;
    }

    public void buyHare(String name, String sex) {
        if (sex.equals("Male")) {
            maleHare.add(new Hare(name, sex, "Hare"));
        } else {
            femaleHare.add(new Hare(name, sex, "Hare"));
        }

        this.money -= Hare.cost;
    }

    public void buyMouse(String name, String sex) {
        if (sex.equals("Male")) {
            maleMouse.add(new Mouse(name, sex, "Mouse"));
        } else {
            femaleMouse.add(new Mouse(name, sex, "Mouse"));
        }

        this.money -= Mouse.cost;
    }

    public void buyHay(int amount) {
        this.hay += amount;

        this.money -= (Hay.cost * amount);
    }

    public void buySoy(int amount) {
        this.soy += amount;

        this.money -= (Soy.cost * amount);
    }

    public void buyPellets(int amount) {
        this.pellets += amount;

        this.money -= (Pellets.cost * amount);
    }

    public boolean isNamePresent(String name) {
        for (ArrayList<Animal> l : animalList) {
            for (Animal a : l) {
                if (a.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }

        return false;
    }

    public List<Animal> printUnhealthyAnimals(String type) {
        ArrayList<Animal> list = new ArrayList<>();

        for (ArrayList<Animal> l : animalList) {
            if(!l.isEmpty() && l.get(0).getType().equals(type)) {
                for (Animal a : l) {
                    if (a.getHealth() != 100) {
                        list.add(a);
                        System.out.println("\"" + a.getName() + "\" the " + a.getSex().toLowerCase() + " " + a.getType().toLowerCase() + " has " + a.getHealth() + " health");
                    }
                }
            }
        }

        return list;
    }

    public void feedHay(Animal animal) {
        hay--;
        animal.increaseHealth(10);
    }

    public void feedSoy(Animal animal) {
        soy--;
        animal.increaseHealth(10);
    }

    public void feedPellets(Animal animal) {
        pellets--;
        animal.increaseHealth(10);
    }

    public ArrayList<Animal> loseHealth() {
        ArrayList<Animal> list = new ArrayList<>();
        Random rand = new Random();

        for (ArrayList<Animal> l : animalList) {
            for (Animal a : l) {
                if (a.decreaseHealth(rand.nextInt(21) + 10)) {
                    l.remove(a);
                    list.add(a);
                }
            }
        }

        return list;
    }
}
