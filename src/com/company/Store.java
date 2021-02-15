package com.company;

import com.company.animal.*;
import com.company.food.Hay;
import com.company.food.Pellets;
import com.company.food.Soy;

import java.util.ArrayList;

public class Store {
    public static Animal buyElephant(Player player, String name, String sex) {
        Elephant e = new Elephant(name, sex, "Elephant", "Elephants");

        if (sex.equals("Male")) {
            player.getMaleElephants().add(e);
        } else {
            player.getFemaleElephants().add(e);
        }

        player.setMoney(player.getMoney() - Elephant.cost);

        return e;
    }

    public static Animal buyBuffalo(Player player, String name, String sex) {
        Buffalo b = new Buffalo(name, sex, "Buffalo", "Buffaloes");

        if (sex.equals("Male")) {
            player.getMaleBuffaloes().add(b);
        } else {
            player.getFemaleBuffaloes().add(b);
        }

        player.setMoney(player.getMoney() - Buffalo.cost);

        return b;
    }

    public static Animal buyBoar(Player player, String name, String sex) {
        Boar b = new Boar(name, sex, "Boar", "Boars");

        if (sex.equals("Male")) {
            player.getMaleBoars().add(b);
        } else {
            player.getFemaleBoars().add(b);
        }

        player.setMoney(player.getMoney() - Boar.cost);

        return b;
    }

    public static Animal buyHare(Player player, String name, String sex) {
        Hare h = new Hare(name, sex, "Hare", "Hares");

        if (sex.equals("Male")) {
            player.getMaleHares().add(h);
        } else {
            player.getFemaleHares().add(h);
        }

        player.setMoney(player.getMoney() - Hare.cost);

        return h;
    }

    public static Animal buyMouse(Player player, String name, String sex) {
        Mouse m = new Mouse(name, sex, "Mouse", "Mice");

        if (sex.equals("Male")) {
            player.getMaleMice().add(m);
        } else {
            player.getFemaleMice().add(m);
        }

        player.setMoney(player.getMoney() - Mouse.cost);

        return m;
    }

    public static void buyHay(Player player, int amount) {
        player.setHay(player.getHay() + amount);

        player.setMoney(player.getMoney() - (Hay.cost * amount));
    }

    public static void buySoy(Player player, int amount) {
        player.setSoy(player.getSoy() + amount);

        player.setMoney(player.getMoney() - (Soy.cost * amount));
    }

    public static void buyPellets(Player player, int amount) {
        player.setPellets(player.getPellets() + amount);

        player.setMoney(player.getMoney() - (Pellets.cost * amount));
    }

    public static int sellAnimal(Player player, String name) {
        for (ArrayList<Animal> l : player.getAnimalList()) {
            for (Animal a : l) {
                if (a.getName().equalsIgnoreCase(name)) {
                    player.setMoney(player.getMoney() + (int) (a.getPrice() * ((double) a.getHealth() / 100)));
                    l.remove(a);
                    return (int) (a.getPrice() * ((double) a.getHealth() / 100));
                }
            }
        }

        return 0;
    }
}
