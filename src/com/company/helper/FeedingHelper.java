package com.company.helper;

import com.company.Player;
import com.company.animal.Animal;
import java.util.*;

/**
 * Contains static methods to help with feeding animals
 */
public class FeedingHelper {
    /**
     * Prints the menu used to feed animals
     * @param player Player whose turn it is
     */
    public static void printFeedingMenu(Player player) {
        System.out.print("You have " + player.getMoney() + " coins");
        if (player.getHay() != 0 || player.getSoy() != 0 || player.getPellets() != 0) {
            System.out.println(" and the following:");
            if (player.getHay() != 0) {
                System.out.println(player.getHay() + " bales of hay");
            }
            if (player.getSoy() != 0) {
                System.out.println(player.getSoy() + " bushels of soy");
            }
            if (player.getPellets() != 0) {
                System.out.println(player.getPellets() + " bags of pellets");
            }
        } else {
            System.out.println();
        }
        System.out.println("\r\n1) Feed hay to animal");
        System.out.println("2) Feed soy to animal");
        System.out.println("3) Feed pellets to animal");
        System.out.println("4) Back to main menu");
        System.out.println("5) End turn");
    }

    /**
     * Prints the animals that a player can feed and prompts them to enter the name of the animal that
     * they would like to feed
     * @param player Player whose turn it is
     * @param selection int selection from the feeding menu indicating which food the player would
     *                  like to feed their animals
     * @return 1 if an animal was fed, 0 otherwise
     */
    public static int selectAndFeedAnimal(Player player, int selection) {
        List<Animal> list = new ArrayList<>();

        String name;
        Animal animal = null;

        do {
            GeneralGameHelper.clear();

            if (selection == 1 && player.getHay() > 0) {
                System.out.println("You may feed hay to the following animals:");
                list.addAll(player.printUnhealthyAnimals("Elephant"));
                list.addAll(player.printUnhealthyAnimals("Buffalo"));
            } else if (selection == 1) {
                GeneralGameHelper.clear();
                GeneralGameHelper.getString("You don't have any hay to feed");
                return 0;
            } else if (selection == 2 && player.getSoy() > 0) {
                System.out.println("You may feed soy to the following animals:");
                list.addAll(player.printUnhealthyAnimals("Buffalo"));
                list.addAll(player.printUnhealthyAnimals("Boar"));
            } else if (selection == 2) {
                GeneralGameHelper.clear();
                GeneralGameHelper.getString("You don't have any soy to feed");
                return 0;
            } else if (player.getPellets() > 0) {
                System.out.println("You may feed pellets to the following animals:");
                list.addAll(player.printUnhealthyAnimals("Hare"));
                list.addAll(player.printUnhealthyAnimals("Mouse"));
            } else {
                GeneralGameHelper.clear();
                GeneralGameHelper.getString("You don't have any pellets to feed");
                return 0;
            }

            name = GeneralGameHelper.getString("\r\nType the name of the animal that you would like to feed: ");

            if (name.isEmpty()) {
                return 0;
            }

            boolean found = false;

            for (Animal a : list) {
                if (a.getName().equalsIgnoreCase(name)) {
                    animal = a;
                    found = true;
                    break;
                }
            }

            if (!found) {
                GeneralGameHelper.clear();
                GeneralGameHelper.getString(name + " is not an animal that could be fed. Please choose an animal that is listed");

                name = "";
            }

        } while (name.isEmpty());

        if (selection == 1) {
            player.feedHay(animal);
        } else if (selection == 2) {
            player.feedSoy(animal);
        } else {
            player.feedPellets(animal);
        }

        GeneralGameHelper.clear();
        GeneralGameHelper.getString(animal.getName() + " now has " + animal.getHealth() + " health");

        return 1;
    }
}
