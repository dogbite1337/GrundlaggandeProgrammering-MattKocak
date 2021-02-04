package com.company;

import java.util.*;

public class MatingHelper {
    public static void printMatingMenu() {
        GeneralGameHelper.clear();
        System.out.println("1) Mate elephants");
        System.out.println("2) Mate buffaloes");
        System.out.println("3) Mate boars");
        System.out.println("4) Mate hares");
        System.out.println("5) Mate mice");
        System.out.println("6) Go back");
    }

    public static int mateAnimals(Player player, int selection) {
        boolean canMate = printTypeAndSex(player, selection);

        if (canMate) {
            String confirm = GeneralGameHelper.getString("\nConfirm that you would like to mate animals (Y/N): ");
            if (!confirm.equalsIgnoreCase("Y")) {
                return 0;
            } else {
                attemptMatingAnimals(player, selection);
                return 1;
            }
        } else {
            GeneralGameHelper.getString("\nYou do not have a male and a female to mate");
            return 0;
        }
    }

    private static boolean printTypeAndSex(Player player, int selection) {
        GeneralGameHelper.clear();

        if (selection == 1) {
            System.out.println("Elephants:");
            System.out.println("Male: " + player.numMaleElephants());
            System.out.println("Female: " + player.numFemaleElephants());

            if (player.numMaleElephants() > 0 && player.numFemaleElephants() > 0) {
                return true;
            }
        } else if (selection == 2) {
            System.out.println("Buffaloes:");
            System.out.println("Male: " + player.numMaleBuffaloes());
            System.out.println("Female: " + player.numFemaleBuffaloes());

            if (player.numMaleBuffaloes() > 0 && player.numFemaleBuffaloes() > 0) {
                return true;
            }
        } else if (selection == 3) {
            System.out.println("Boars:");
            System.out.println("Male: " + player.numMaleBoars());
            System.out.println("Female: " + player.numFemaleBoars());

            if (player.numMaleBoars() > 0 && player.numFemaleBoars() > 0) {
                return true;
            }
        } else if (selection == 4) {
            System.out.println("Hares:");
            System.out.println("Male: " + player.numMaleHares());
            System.out.println("Female: " + player.numFemaleHares());

            if (player.numMaleHares() > 0 && player.numFemaleHares() > 0) {
                return true;
            }
        } else {
            System.out.println("Mice:");
            System.out.println("Male: " + player.numMaleMice());
            System.out.println("Female: " + player.numFemaleMice());

            if (player.numMaleMice() > 0 && player.numFemaleMice() > 0) {
                return true;
            }
        }

        return false;
    }

    private static void attemptMatingAnimals(Player player, int selection) {
        Random rand = new Random();
        int success = rand.nextInt(2);

        if (success == 1) {
            GeneralGameHelper.clear();
            System.out.print("I'm sorry, mating was unsuccessful. Your turn has ended");
            GeneralGameHelper.getString("");

            return;
        }

        GeneralGameHelper.clear();

        int sex = rand.nextInt(2);
        String name;
        Animal baby;

        if (selection == 1) {
            System.out.println("Mating your elephants was a success. Congratulations, it's a " + ((sex == 0) ? "boy" : "girl") + "!");
            name = BuyingAnimalsHelper.getAnimalName(player, "elephant");
            baby = player.buyElephant(name, (sex == 0) ? "Male" : "Female");
        } else if (selection == 2) {
            System.out.println("Mating your buffaloes was a success. Congratulations, it's a " + ((sex == 0) ? "boy" : "girl") + "!");
            name = BuyingAnimalsHelper.getAnimalName(player, "buffalo");
            baby = player.buyBuffalo(name, (sex == 0) ? "Male" : "Female");
        } else if (selection == 3) {
            System.out.println("Mating your boars was a success. Congratulations, it's a " + ((sex == 0) ? "boy" : "girl") + "!");
            name = BuyingAnimalsHelper.getAnimalName(player, "boar");
            baby = player.buyBoar(name, (sex == 0) ? "Male" : "Female");
        } else if (selection == 4) {
            System.out.println("Mating your hares was a success. Congratulations, it's a " + ((sex == 0) ? "boy" : "girl") + "!");
            name = BuyingAnimalsHelper.getAnimalName(player, "hare");
            baby = player.buyHare(name, (sex == 0) ? "Male" : "Female");
        } else {
            System.out.println("Mating your mice was a success. Congratulations, it's a " + ((sex == 0) ? "boy" : "girl") + "!");
            name = BuyingAnimalsHelper.getAnimalName(player, "mouse");
            baby = player.buyMouse(name, (sex == 0) ? "Male" : "Female");
        }

        GeneralGameHelper.clear();
        System.out.print("You now own " + baby.getName() + " the " + baby.getSex().toLowerCase() + " " + baby.getType().toLowerCase() + ". Your turn has ended");
        GeneralGameHelper.getString("");
    }
}
