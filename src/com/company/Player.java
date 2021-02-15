package com.company;
import com.company.animal.Animal;

import java.util.*;

public class Player {
    private static final int STARTMONEY = 1500;
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
    private boolean playing;

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
        this.playing = true;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int amount) {
        money = amount;
    }

    public int getHay() {
        return hay;
    }

    public void setHay(int amount) {
        hay = amount;
    }

    public int getSoy() {
        return soy;
    }

    public void setSoy(int amount) {
        soy = amount;
    }

    public int getPellets() {
        return pellets;
    }

    public void setPellets(int amount) {
        pellets = amount;
    }

    public ArrayList<ArrayList<Animal>> getAnimalList() {
        return animalList;
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

    public boolean isPlaying() {
        return playing;
    }

    public void noLongerPlaying() {
        playing = false;
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
            for (int i = 0; i < l.size(); i++) {
                if (l.get(i).decreaseHealth(rand.nextInt(21) + 10)) {
                    lastRoundsDeadAnimals.add(l.remove(i));
                    i--;
                }
            }
        }
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

    public void calculateFinalScore() {
        for (ArrayList<Animal> l : animalList) {
            while (!l.isEmpty()) {
                money += (l.get(0).getPrice() * ((double) l.get(0).getHealth() / 100));
                l.remove(0);
            }
        }
    }
}
