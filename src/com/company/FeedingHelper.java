package com.company;

import java.util.*;

public class FeedingHelper {
    public static void printFeedingMenu(Player player) {
        System.out.print("\nYou have " + player.getMoney() + " coins");
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
        System.out.println("\n1) Feed hay to animal");
        System.out.println("2) Feed soy to animal");
        System.out.println("3) Feed pellets to animal");
        System.out.println("4) Back to main menu");
        System.out.println("5) End turn");
    }

    public static int selectAndFeedAnimal(Player player, int selection) {
        List<Animal> list = new ArrayList<>();

        String name = "";
        Animal animal = null;

        do {
            if (selection == 1) {
                System.out.println("\nYou may feed hay to the following animals:");
                list.addAll(player.printUnhealthyAnimals("Elephant"));
                list.addAll(player.printUnhealthyAnimals("Buffalo"));
            } else if (selection == 2) {
                System.out.println("\nYou may feed soy to the following animals:");
                list.addAll(player.printUnhealthyAnimals("Buffalo"));
                list.addAll(player.printUnhealthyAnimals("Boar"));
            } else {
                System.out.println("\nYou may feed pellets to the following animals:");
                list.addAll(player.printUnhealthyAnimals("Hare"));
                list.addAll(player.printUnhealthyAnimals("Mouse"));
            }

            name = GeneralGameHelper.getString("\nType the name of the animal that you would like to feed: ");

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
                System.out.println("\n" + name + " is not an animal that could be fed. Please choose an animal that is listed");

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

        System.out.println("\n" + animal.getName() + " now has " + animal.getHealth() + " health");

        return 1;
    }
}
