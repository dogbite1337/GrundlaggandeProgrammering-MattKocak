package com.company.helper;

import com.company.Player;
import com.company.Store;
import com.company.animal.Animal;
import java.util.ArrayList;

/**
 * Contains statics methods that help with selling animals
 */
public class SellingHelper {
    /**
     * Prints the menu used to sell animals
     */
    public static void printSellingMenu() {
        System.out.println("1) Sell elephant");
        System.out.println("2) Sell buffalo");
        System.out.println("3) Sell boar");
        System.out.println("4) Sell hare");
        System.out.println("5) Sell mouse");
        System.out.println("6) Go back");
        System.out.println("7) End turn");
    }

    /**
     * Prints the animals that a player can sell of a given type and prompts the user of the name of the
     * animal that they would like to sell. Sells animal inputted
     * @param player Player whose turn it is
     * @param selection int selection from the selling menu of which type of animal will be sold
     * @return 1 if an animal was sold, 0 otherwise
     */
    public static int selectAndSellAnimal(Player player, int selection) {
        ArrayList<Animal> list = new ArrayList<>();

        String name;

        GeneralGameHelper.clear();
        System.out.println("You may sell the following " + GeneralGameHelper.getAnimalFromSelection(selection).getPluralType().toLowerCase());
        System.out.println("Male:");

        do {
            if (selection == 1) {
                GeneralGameHelper.printAnimalListWithPrice(player.getMaleElephants());
                System.out.println("\r\nFemale:");
                GeneralGameHelper.printAnimalListWithPrice(player.getFemaleElephants());
                list.addAll(player.getMaleElephants());
                list.addAll(player.getFemaleElephants());
            } else if (selection == 2) {
                GeneralGameHelper.printAnimalListWithPrice(player.getMaleBuffaloes());
                System.out.println("\r\nFemale:");
                GeneralGameHelper.printAnimalListWithPrice(player.getFemaleBuffaloes());
                list.addAll(player.getMaleBuffaloes());
                list.addAll(player.getFemaleBuffaloes());
            } else if (selection == 3) {
                GeneralGameHelper.printAnimalListWithPrice(player.getMaleBoars());
                System.out.println("\r\nFemale:");
                GeneralGameHelper.printAnimalListWithPrice(player.getFemaleBoars());
                list.addAll(player.getMaleBoars());
                list.addAll(player.getFemaleBoars());
            } else if (selection == 4) {
                GeneralGameHelper.printAnimalListWithPrice(player.getMaleHares());
                System.out.println("\r\nFemale:");
                GeneralGameHelper.printAnimalListWithPrice(player.getFemaleHares());
                list.addAll(player.getMaleHares());
                list.addAll(player.getFemaleHares());
            } else {
                GeneralGameHelper.printAnimalListWithPrice(player.getMaleMice());
                System.out.println("\r\nFemale:");
                GeneralGameHelper.printAnimalListWithPrice(player.getFemaleMice());
                list.addAll(player.getMaleMice());
                list.addAll(player.getFemaleMice());
            }

            name = GeneralGameHelper.getString("\r\nType the name of the animal that you would like to sell: ");

            if (name.isEmpty()) {
                return 0;
            }

            if (!GeneralGameHelper.isAnimalInList(name, list)) {
                GeneralGameHelper.clear();
                GeneralGameHelper.getString(name + " is not a listed animal. Please choose an animal that is listed");
                name = "";
            }
        } while (name.isEmpty());

        GeneralGameHelper.clear();
        GeneralGameHelper.getString(name + " was sold for " + Store.sellAnimal(player, name) + " coins");

        return 1;
    }
}
