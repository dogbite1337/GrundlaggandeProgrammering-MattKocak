package com.company.helper;

import com.company.Player;
import com.company.Store;
import com.company.food.Hay;
import com.company.food.Pellets;
import com.company.food.Soy;

public class BuyingFoodHelper {

    public static void printBuyingFoodMenu(Player player) {
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
        System.out.println("\r\n1) Buy hay (" + Hay.cost + " coins)");
        System.out.println("2) Buy soy (" + Soy.cost + " coins)");
        System.out.println("3) Buy pellets (" + Pellets.cost + " coins)");
        System.out.println("4) Back to main menu");
        System.out.println("5) End turn");
    }

    public static int chooseAmountAndBuy(Player player, int selection) {
        int amount;
        GeneralGameHelper.clear();

        if (selection == 1) {
            System.out.println("Hay can be fed to elephants and buffaloes");
            amount = GeneralGameHelper.getPositiveNumber("\r\nHow many bales of hay would you like to purchase: ");

            if (amount == 0) {
                return 0;
            }

            GeneralGameHelper.clear();

            if (amount * Hay.cost > player.getMoney()) {
                GeneralGameHelper.getString("You don't have enough money to buy " + amount * Hay.cost + " coins worth of hay");
                return 0;
            } else {
                Store.buyHay(player, amount);
                GeneralGameHelper.getString("Congratulations, you just bought " + amount + " bales of hay!");
                return 1;
            }
        } else if (selection == 2) {
            System.out.println("Soy can be fed to buffaloes and boars");
            amount = GeneralGameHelper.getPositiveNumber("\r\nHow many bushels of soy would you like to purchase: ");

            if (amount == 0) {
                return 0;
            }

            GeneralGameHelper.clear();

            if (amount * Soy.cost > player.getMoney()) {
                GeneralGameHelper.getString("You don't have enough money to buy " + amount * Soy.cost + " coins worth of soy");
                return 0;
            } else {
                Store.buySoy(player, amount);
                GeneralGameHelper.getString("Congratulations, you just bought " + amount + " bushels of soy!");
                return 1;
            }
        } else {
            System.out.println("Pellets can be fed to hares and mice");
            amount = GeneralGameHelper.getPositiveNumber("\r\nHow many bags of pellets would you like to purchase: ");

            if (amount == 0) {
                return 0;
            }

            GeneralGameHelper.clear();

            if (amount * Pellets.cost > player.getMoney()) {
                GeneralGameHelper.getString("You don't have enough money to buy " + amount * Pellets.cost + " coins worth of pellets");
                return 0;
            } else {
                Store.buyPellets(player, amount);
                GeneralGameHelper.getString("Congratulations, you just bought " + amount + " bags of pellets!");
                return 1;
            }
        }
    }
}
