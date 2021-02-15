package com.company.helper;

import com.company.Player;
import com.company.Store;
import com.company.animal.*;

public class BuyingAnimalsHelper {
    public static void printBuyingAnimalsMenu(Player player) {
        System.out.println("You have " + player.getMoney() + " coins");
        System.out.println("\r\n1) Buy elephant (" + Elephant.cost + " coins)");
        System.out.println("2) Buy buffalo (" + Buffalo.cost + " coins)");
        System.out.println("3) Buy boar (" + Boar.cost + " coins)");
        System.out.println("4) Buy hare (" + Hare.cost + " coins)");
        System.out.println("5) Buy mouse (" + Mouse.cost + " coins)");
        System.out.println("6) Back to main menu");
        System.out.println("7) End turn");
    }

    public static int chooseSexAndNameAndBuy(Player player, int selection) {
        if (selection == 1 && player.getMoney() < Elephant.cost) {
            GeneralGameHelper.clear();
            GeneralGameHelper.getString("You don't have enough money to buy an elephant");
            return 0;
        } else if (selection == 1) {
            int sex = getSex("elephant");

            if (sex != 3) {
                String name = getAnimalName(player, "elephant");
                Store.buyElephant(player, name, (sex == 1) ? "Male" : "Female");
                GeneralGameHelper.clear();
                GeneralGameHelper.getString("Congratulations, you just bought " + name + " the elephant!");
                return 1;
            }

            return 0;
        } else if (selection == 2 && player.getMoney() < Buffalo.cost) {
            GeneralGameHelper.clear();
            GeneralGameHelper.getString("You don't have enough money to buy a buffalo");
            return 0;
        } else if (selection == 2) {
            int sex = getSex("buffalo");

            if (sex != 3) {
                String name = getAnimalName(player, "buffalo");
                Store.buyBuffalo(player, name, (sex == 1) ? "Male" : "Female");
                GeneralGameHelper.clear();
                GeneralGameHelper.getString("Congratulations, you just bought " + name + " the buffalo!");
                return 1;
            }

            return 0;
        } else if (selection == 3 && player.getMoney() < Boar.cost) {
            GeneralGameHelper.clear();
            GeneralGameHelper.getString("You don't have enough money to buy a boar");
            return 0;
        } else if (selection == 3) {
            int sex = getSex("boar");

            if (sex != 3) {
                String name = getAnimalName(player, "boar");
                Store.buyBoar(player, name, (sex == 1) ? "Male" : "Female");
                GeneralGameHelper.clear();
                GeneralGameHelper.getString("Congratulations, you just bought " + name + " the boar!");
                return 1;
            }

            return 0;
        } else if (selection == 4 && player.getMoney() < Hare.cost) {
            GeneralGameHelper.clear();
            GeneralGameHelper.getString("You don't have enough money to buy a hare");
            return 0;
        } else if (selection == 4) {
            int sex = getSex("hare");

            if (sex != 3) {
                String name = getAnimalName(player,"hare");
                Store.buyHare(player, name, (sex == 1) ? "Male" : "Female");
                GeneralGameHelper.clear();
                GeneralGameHelper.getString("Congratulations, you just bought " + name + " the hare!");
                return 1;
            }

            return 0;
        } else if (selection == 5 && player.getMoney() < Mouse.cost) {
            GeneralGameHelper.clear();
            GeneralGameHelper.getString("You don't have enough money to buy a mouse");
            return 0;
        } else {
            int sex = getSex("mouse");

            if (sex != 3) {
                String name = getAnimalName(player,"mouse");
                Store.buyMouse(player, name, (sex == 1) ? "Male" : "Female");
                GeneralGameHelper.clear();
                GeneralGameHelper.getString("Congratulations, you just bought " + name + " the mouse!");
                return 1;
            }

            return 0;
        }
    }

    private static int getSex(String animal) {
        int selection;

        do {
            GeneralGameHelper.clear();
            printGetSexMenu();
            selection = GeneralGameHelper.getPositiveNumberInRange("\r\nChoose " + animal + "'s sex: ", 1, 3);
        } while (selection < 1 || selection > 3);

        return selection;
    }

    private static void printGetSexMenu() {
        System.out.println("1) Male");
        System.out.println("2) Female");
        System.out.println("3) Back to previous menu");
    }

    public static String getAnimalName(Player player, String animal) {
        String name;

        do {
            GeneralGameHelper.clear();
            name = GeneralGameHelper.getNonEmptyString("Choose " + animal + "'s name: ");

            if (player.isNamePresent(name)) {
                GeneralGameHelper.clear();
                GeneralGameHelper.getString("\"" + name + "\" has already been given to another of your animals");
                name = "";
            }

        } while (name.isEmpty());

        return name;
    }
}
