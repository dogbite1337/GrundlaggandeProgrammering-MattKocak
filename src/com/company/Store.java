package com.company;

import com.company.animal.*;
import com.company.food.Hay;
import com.company.food.Pellets;
import com.company.food.Soy;
import java.util.ArrayList;

/**
 * Static methods for buying animals, buying food, and selling animals
 */
public class Store {
    /**
     * Adds an elephant with a given name and sex to a player's animal list and subtracts the cost
     * of an elephant from the player's money field
     * @param player Player whose list the animal will be added to
     * @param name name of animal
     * @param sex sex of animal
     * @return animal that was created
     */
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

    /**
     * Adds a buffalo with a given name and sex to a player's animal list and subtracts the cost
     * of a buffalo from the player's money field
     * @param player Player whose list the animal will be added to
     * @param name name of animal
     * @param sex sex of animal
     * @return animal that was created
     */
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

    /**
     * Adds a boar with a given name and sex to a player's animal list and subtracts the cost
     * of a boar from the player's money field
     * @param player Player whose list the animal will be added to
     * @param name name of animal
     * @param sex sex of animal
     * @return animal that was created
     */
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

    /**
     * Adds a hare with a given name and sex to a player's animal list and subtracts the cost
     * of a hare from the player's money field
     * @param player Player whose list the animal will be added to
     * @param name name of animal
     * @param sex sex of animal
     * @return animal that was created
     */
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

    /**
     * Adds a mouse with a given name and sex to a player's animal list and subtracts the cost
     * of a mouse from the player's money field
     * @param player Player whose list the animal will be added to
     * @param name name of animal
     * @param sex sex of animal
     * @return animal that was created
     */
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

    /**
     * Adds a given amount of hay to a given player's hay field and subtracts the cost of that hay
     * from their money field
     * @param player Player to add hay
     * @param amount amount of hay to add to hay field
     */
    public static void buyHay(Player player, int amount) {
        player.setHay(player.getHay() + amount);

        player.setMoney(player.getMoney() - (Hay.cost * amount));
    }

    /**
     * Adds a given amount of soy to a given player's soy field and subtracts the cost of that soy
     * from their money field
     * @param player Player to add soy
     * @param amount amount of soy to add to soy field
     */
    public static void buySoy(Player player, int amount) {
        player.setSoy(player.getSoy() + amount);

        player.setMoney(player.getMoney() - (Soy.cost * amount));
    }

    /**
     * Adds a given amount of pellets to a given player's pellets field and subtracts the cost of that pellets
     * from their money field
     * @param player Player to add pellets
     * @param amount amount of pellets to add to pellets field
     */
    public static void buyPellets(Player player, int amount) {
        player.setPellets(player.getPellets() + amount);

        player.setMoney(player.getMoney() - (Pellets.cost * amount));
    }

    /**
     * Search a given player's animal lists for an animal with a specified name. The animal is then removed,
     * the animals value is calculated, and this value is added to a player's money total
     * @param player Player selling the animal
     * @param name name of the animal being sold
     * @return the value that the animal was sold for
     */
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
