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
    private int hay;
    private int soy;
    private int pellets;

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
        for (Elephant e : maleElephant) {
            if (e.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }

        for (Elephant e : femaleElephant) {
            if (e.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }

        for (Buffalo b : maleBuffalo) {
            if (b.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }

        for (Buffalo b : femaleBuffalo) {
            if (b.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }

        for (Boar b : maleBoar) {
            if (b.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }

        for (Boar b : femaleBoar) {
            if (b.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }

        for (Hare h : maleHare) {
            if (h.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }

        for (Hare h : femaleHare) {
            if (h.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }

        for (Mouse m : maleMouse) {
            if (m.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }

        for (Mouse m : femaleMouse) {
            if (m.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }

        return false;
    }

    public List<Animal> printUnhealthyAnimals(String type) {
        ArrayList<Animal> list = new ArrayList<>();

        if (type.equals("Elephant")) {
            for (Elephant e : maleElephant) {
                if (e.getHealth() != 100) {
                    list.add(e);
                    System.out.println("\"" + e.getName() + "\" the male elephant has " + e.getHealth() + " health");
                }
            }
            for (Elephant e : femaleElephant) {
                if (e.getHealth() != 100) {
                    list.add(e);
                    System.out.println("\"" + e.getName() + "\" the female elephant has " + e.getHealth() + " health");
                }
            }
        }

        if (type.equals("Buffalo")) {
            for (Buffalo b : maleBuffalo) {
                if (b.getHealth() != 100) {
                    list.add(b);
                    System.out.println("\"" + b.getName() + "\" the male buffalo has " + b.getHealth() + " health");
                }
            }
            for (Buffalo b : femaleBuffalo) {
                if (b.getHealth() != 100) {
                    list.add(b);
                    System.out.println("\"" + b.getName() + "\" the female buffalo has " + b.getHealth() + " health");
                }
            }
        }

        if (type.equals("Boar")) {
            for (Boar b : maleBoar) {
                if (b.getHealth() != 100) {
                    list.add(b);
                    System.out.println("\"" + b.getName() + "\" the male boar has " + b.getHealth() + " health");
                }
            }
            for (Boar b : femaleBoar) {
                if (b.getHealth() != 100) {
                    list.add(b);
                    System.out.println("\"" + b.getName() + "\" the female boar has " + b.getHealth() + " health");
                }
            }
        }

        if (type.equals("Hare")) {
            for (Hare h : maleHare) {
                if (h.getHealth() != 100) {
                    list.add(h);
                    System.out.println("\"" + h.getName() + "\" the male hare has " + h.getHealth() + " health");
                }
            }
            for (Hare h : femaleHare) {
                if (h.getHealth() != 100) {
                    list.add(h);
                    System.out.println("\"" + h.getName() + "\" the female hare has " + h.getHealth() + " health");
                }
            }
        }

        if (type.equals("Mouse")) {
            for (Mouse m : maleMouse) {
                if (m.getHealth() != 100) {
                    list.add(m);
                    System.out.println("\"" + m.getName() + "\" the male mouse has " + m.getHealth() + " health");
                }
            }
            for (Mouse m : femaleMouse) {
                if (m.getHealth() != 100) {
                    list.add(m);
                    System.out.println("\"" + m.getName() + "\" the female mouse has " + m.getHealth() + " health");
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

    public List<Animal> loseHealth() {
        List<Animal> list = new ArrayList<>();

        for (Animal a : maleElephant) {
            Random rand = new Random();
            if (a.decreaseHealth(rand.nextInt(21) + 10)) {
                maleElephant.remove(a);
                list.add(a);
            }
        }
        for (Animal a : femaleElephant) {
            Random rand = new Random();
            if (a.decreaseHealth(rand.nextInt(21) + 10)) {
                femaleElephant.remove(a);
                list.add(a);
            }
        }
        for (Animal a : maleBuffalo) {
            Random rand = new Random();
            if (a.decreaseHealth(rand.nextInt(21) + 10)) {
                maleBuffalo.remove(a);
                list.add(a);
            }
        }
        for (Animal a : femaleBuffalo) {
            Random rand = new Random();
            if (a.decreaseHealth(rand.nextInt(21) + 10)) {
                femaleBuffalo.remove(a);
                list.add(a);
            }
        }
        for (Animal a : maleBoar) {
            Random rand = new Random();
            if (a.decreaseHealth(rand.nextInt(21) + 10)) {
                maleBoar.remove(a);
                list.add(a);
            }
        }
        for (Animal a : femaleBoar) {
            Random rand = new Random();
            if (a.decreaseHealth(rand.nextInt(21) + 10)) {
                femaleBoar.remove(a);
                list.add(a);
            }
        }
        for (Animal a : maleHare) {
            Random rand = new Random();
            if (a.decreaseHealth(rand.nextInt(21) + 10)) {
                maleHare.remove(a);
                list.add(a);
            }
        }
        for (Animal a : femaleHare) {
            Random rand = new Random();
            if (a.decreaseHealth(rand.nextInt(21) + 10)) {
                femaleHare.remove(a);
                list.add(a);
            }
        }
        for (Animal a : maleMouse) {
            Random rand = new Random();
            if (a.decreaseHealth(rand.nextInt(21) + 10)) {
                maleMouse.remove(a);
                list.add(a);
            }
        }
        for (Animal a : femaleMouse) {
            Random rand = new Random();
            if (a.decreaseHealth(rand.nextInt(21) + 10)) {
                femaleMouse.remove(a);
                list.add(a);
            }
        }

        return list;
    }
}
