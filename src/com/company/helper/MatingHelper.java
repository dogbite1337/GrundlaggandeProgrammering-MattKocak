package com.company.helper;

import com.company.Player;
import com.company.Store;
import com.company.animal.*;

import java.util.*;

public class MatingHelper {
    public static void printMatingMenu() {
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
            String confirm = GeneralGameHelper.getString("\r\nConfirm that you would like to mate animals (Y/N): ");
            if (!confirm.equalsIgnoreCase("Y")) {
                return 0;
            } else {
                attemptMatingAnimals(player, selection);
                return 1;
            }
        } else {
            GeneralGameHelper.getString("\r\nYou do not have a male and a female to mate");
            return 0;
        }
    }

    private static boolean printTypeAndSex(Player player, int selection) {
        GeneralGameHelper.clear();

        if (selection == 1) {
            System.out.println("Elephants");
            System.out.println("Male: " + player.getMaleElephants().size());
            System.out.println("Female: " + player.getFemaleElephants().size());

            return player.getMaleElephants().size() > 0 && player.getFemaleElephants().size() > 0;
        } else if (selection == 2) {
            System.out.println("Buffaloes");
            System.out.println("Male: " + player.getMaleBuffaloes().size());
            System.out.println("Female: " + player.getFemaleBuffaloes().size());

            return player.getMaleBuffaloes().size() > 0 && player.getFemaleBuffaloes().size() > 0;
        } else if (selection == 3) {
            System.out.println("Boars");
            System.out.println("Male: " + player.getMaleBoars().size());
            System.out.println("Female: " + player.getFemaleBoars().size());

            return player.getMaleBoars().size() > 0 && player.getFemaleBoars().size() > 0;
        } else if (selection == 4) {
            System.out.println("Hares");
            System.out.println("Male: " + player.getMaleHares().size());
            System.out.println("Female: " + player.getFemaleHares().size());

            return player.getMaleHares().size() > 0 && player.getFemaleHares().size() > 0;
        } else {
            System.out.println("Mice");
            System.out.println("Male: " + player.getMaleMice().size());
            System.out.println("Female: " + player.getFemaleMice().size());

            return player.getMaleMice().size() > 0 && player.getFemaleMice().size() > 0;
        }
    }

    private static void attemptMatingAnimals(Player player, int selection) {
        Random rand = new Random();
        int success = rand.nextInt(2);
        GeneralGameHelper.clear();

        if (success == 1) {
            GeneralGameHelper.getString("I'm sorry, mating was unsuccessful. Your turn has ended");

            return;
        }

        int sex = rand.nextInt(2);
        String name;
        Animal baby;

        if (selection == 1) {
            GeneralGameHelper.getString("Mating your elephants was a success. Congratulations, it's a " + ((sex == 0) ? "boy" : "girl") + "!");
            name = BuyingAnimalsHelper.getAnimalName(player, "elephant");
            baby = Store.buyElephant(player, name, (sex == 0) ? "Male" : "Female");
            player.setMoney(player.getMoney() + Elephant.cost);
        } else if (selection == 2) {
            GeneralGameHelper.getString("Mating your buffaloes was a success. Congratulations, it's a " + ((sex == 0) ? "boy" : "girl") + "!");
            name = BuyingAnimalsHelper.getAnimalName(player, "buffalo");
            baby = Store.buyBuffalo(player, name, (sex == 0) ? "Male" : "Female");
            player.setMoney(player.getMoney() + Buffalo.cost);
        } else if (selection == 3) {
            GeneralGameHelper.getString("Mating your boars was a success. Congratulations, it's a " + ((sex == 0) ? "boy" : "girl") + "!");
            name = BuyingAnimalsHelper.getAnimalName(player, "boar");
            baby = Store.buyBoar(player, name, (sex == 0) ? "Male" : "Female");
            player.setMoney(player.getMoney() + Boar.cost);
        } else if (selection == 4) {
            GeneralGameHelper.getString("Mating your hares was a success. Congratulations, it's a " + ((sex == 0) ? "boy" : "girl") + "!");
            name = BuyingAnimalsHelper.getAnimalName(player, "hare");
            baby = Store.buyHare(player, name, (sex == 0) ? "Male" : "Female");
            player.setMoney(player.getMoney() + Hare.cost);
        } else {
            GeneralGameHelper.getString("Mating your mice was a success. Congratulations, it's a " + ((sex == 0) ? "boy" : "girl") + "!");
            name = BuyingAnimalsHelper.getAnimalName(player, "mouse");
            baby = Store.buyMouse(player, name, (sex == 0) ? "Male" : "Female");
            player.setMoney(player.getMoney() + Mouse.cost);
        }

        GeneralGameHelper.clear();
        GeneralGameHelper.getString("You now own " + baby.getName() + " the " + baby.getSex().toLowerCase() + " " + baby.getType().toLowerCase() + ". Your turn has ended");
    }
}
