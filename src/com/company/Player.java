package com.company;
import java.util.*;

public class Player {
    private static final int STARTMONEY = 1000;
    private final String name;
    private int money;
    private final ArrayList<ArrayList<Animal>> animalList;
    private final ArrayList<Animal> maleElephant;
    private final ArrayList<Animal> femaleElephant;
    private final ArrayList<Animal> maleBuffalo;
    private final ArrayList<Animal> femaleBuffalo;
    private final ArrayList<Animal> maleBoar;
    private final ArrayList<Animal> femaleBoar;
    private final ArrayList<Animal> maleHare;
    private final ArrayList<Animal> femaleHare;
    private final ArrayList<Animal> maleMouse;
    private final ArrayList<Animal> femaleMouse;
    private final ArrayList<Animal> lastRoundsDeadAnimals;
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
        lastRoundsDeadAnimals = new ArrayList<>();
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

    public int getHay() {
        return hay;
    }

    public int getSoy() {
        return soy;
    }

    public int getPellets() {
        return pellets;
    }

    public ArrayList<Animal> getMaleElephants() {
        return maleElephant;
    }

    public ArrayList<Animal> getFemaleElephants() {
        return femaleElephant;
    }

    public ArrayList<Animal> getMaleBuffaloes() {
        return maleBuffalo;
    }

    public ArrayList<Animal> getFemaleBuffaloes() {
        return femaleBuffalo;
    }

    public ArrayList<Animal> getMaleBoars() {
        return maleBoar;
    }

    public ArrayList<Animal> getFemaleBoars() {
        return femaleBoar;
    }

    public ArrayList<Animal> getMaleHares() {
        return maleHare;
    }

    public ArrayList<Animal> getFemaleHares() {
        return femaleHare;
    }

    public ArrayList<Animal> getMaleMice() {
        return maleMouse;
    }

    public ArrayList<Animal> getFemaleMice() {
        return femaleMouse;
    }

    public ArrayList<Animal> getLastRoundsDeadAnimals() {
        return lastRoundsDeadAnimals;
    }

    public Animal getAnimal(String name) {
        for (ArrayList<Animal> l : animalList) {
            for (Animal a : l) {
                if (a.getName().equalsIgnoreCase(name)) {
                    return a;
                }
            }
        }

        return null;
    }

    public int numMaleElephants() {
        return maleElephant.size();
    }

    public int numFemaleElephants() {
        return femaleElephant.size();
    }

    public int numMaleBuffaloes() {
        return maleBuffalo.size();
    }

    public int numFemaleBuffaloes() {
        return femaleBuffalo.size();
    }

    public int numMaleBoars() {
        return maleBoar.size();
    }

    public int numFemaleBoars() {
        return femaleBoar.size();
    }

    public int numMaleHares() {
        return maleHare.size();
    }

    public int numFemaleHares() {
        return femaleHare.size();
    }

    public int numMaleMice() {
        return maleMouse.size();
    }

    public int numFemaleMice() {
        return femaleMouse.size();
    }

    public Animal buyElephant(String name, String sex) {
        Elephant e = new Elephant(name, sex, "Elephant", "Elephants");

        if (sex.equals("Male")) {
            maleElephant.add(e);
        } else {
            femaleElephant.add(e);
        }

        this.money -= Elephant.cost;

        return e;
    }

    public Animal buyBuffalo(String name, String sex) {
        Buffalo b = new Buffalo(name, sex, "Buffalo", "Buffaloes");

        if (sex.equals("Male")) {
            maleBuffalo.add(b);
        } else {
            femaleBuffalo.add(b);
        }

        this.money -= Buffalo.cost;

        return b;
    }

    public Animal buyBoar(String name, String sex) {
        Boar b = new Boar(name, sex, "Boar", "Boars");

        if (sex.equals("Male")) {
            maleBoar.add(b);
        } else {
            femaleBoar.add(b);
        }

        this.money -= Boar.cost;

        return b;
    }

    public Animal buyHare(String name, String sex) {
        Hare h = new Hare(name, sex, "Hare", "Hares");

        if (sex.equals("Male")) {
            maleHare.add(h);
        } else {
            femaleHare.add(h);
        }

        this.money -= Hare.cost;

        return h;
    }

    public Animal buyMouse(String name, String sex) {
        Mouse m = new Mouse(name, sex, "Mouse", "Mice");

        if (sex.equals("Male")) {
            maleMouse.add(m);
        } else {
            femaleMouse.add(m);
        }

        this.money -= Mouse.cost;

        return m;
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

    public void loseHealth() {
        Random rand = new Random();
        lastRoundsDeadAnimals.clear();

        for (ArrayList<Animal> l : animalList) {
            for (Animal a : l) {
                if (a.decreaseHealth(rand.nextInt(21) + 10)) {
                    l.remove(a);
                    lastRoundsDeadAnimals.add(a);
                }
            }
        }
    }

    public int sellAnimal(String name) {
        for (ArrayList<Animal> l : animalList) {
            for (Animal a : l) {
                if (a.getName().equalsIgnoreCase(name)) {
                    money += (a.getPrice() * ((double) a.getHealth() / 100));
                    l.remove(a);
                    return (int) (a.getPrice() * ((double) a.getHealth() / 100));
                }
            }
        }

        return 0;
    }

    public boolean hasLiveAnimals() {
        for (ArrayList<Animal> l : animalList) {
            if (!l.isEmpty()) {
                return true;
            }
        }

        return false;
    }

    public boolean hasFood() {
        return hay != 0 || soy != 0 || pellets != 0;
    }
}
