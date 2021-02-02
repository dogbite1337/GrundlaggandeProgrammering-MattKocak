package com.company;

public class BuyingFoodHelper {

    public static void printBuyingFoodMenu(Player player) {
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
        System.out.println("\n1) Buy hay (" + Hay.cost + " coins)");
        System.out.println("2) Buy soy (" + Soy.cost + " coins)");
        System.out.println("3) Buy pellets (" + Pellets.cost + " coins)");
        System.out.println("4) Back to main menu");
        System.out.println("5) End turn");
    }

    public static int chooseAmountAndBuy(Player player, int selection) {
        int amount;

        if (selection == 1) {
            amount = GeneralGameHelper.getPositiveNumber("\nHow many bales of hay would you like to purchase: ");

            if (amount == 0) {
                return 0;
            }

            if (amount * Hay.cost > player.getMoney()) {
                System.out.println("\nYou don't have enough money to buy " + amount * Hay.cost + " coins worth of hay");
                return 0;
            } else {
                player.buyHay(amount);
                System.out.println("\nCongratulations, you just bought " + amount + " bales of hay!");
                return 1;
            }
        } else if (selection == 2) {
            amount = GeneralGameHelper.getPositiveNumber("\nHow many bushels of soy would you like to purchase: ");

            if (amount == 0) {
                return 0;
            }

            if (amount * Soy.cost > player.getMoney()) {
                System.out.println("\nYou don't have enough money to buy " + amount * Soy.cost + " coins worth of soy");
                return 0;
            } else {
                player.buySoy(amount);
                System.out.println("\nCongratulations, you just bought " + amount + " bushels of soy!");
                return 1;
            }
        } else {
            amount = GeneralGameHelper.getPositiveNumber("\nHow many bags of pellets would you like to purchase: ");

            if (amount == 0) {
                return 0;
            }

            if (amount * Pellets.cost > player.getMoney()) {
                System.out.println("\nYou don't have enough money to buy " + amount * Pellets.cost + " coins worth of pellets");
                return 0;
            } else {
                player.buyPellets(amount);
                System.out.println("\nCongratulations, you just bought " + amount + " bags of pellets!");
                return 1;
            }
        }
    }
}
