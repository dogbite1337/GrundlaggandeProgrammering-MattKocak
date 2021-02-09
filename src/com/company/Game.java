package com.company;

import java.util.*;

public class Game {
    private int totalRounds;
    private int round;
    private int numPlayers;
    private LinkedList<Player> players;

    public Game () {
        System.out.println("Welcome to Animal Farm!");
        System.out.println("Enter QUIT to exit game\n");
        this.players = new LinkedList<>();
        this.round = 1;
    }

    public int numRounds() {
        return totalRounds;
    }

    public int getRound() {
        return round;
    }

    public void getNumPlayers() {
        do {
            this.numPlayers = GeneralGameHelper.getPositiveNumberInRangeQ("Number of players (1-4): ", 1, 4);
        } while (this.numPlayers == 0);

        System.out.println("\n" + this.numPlayers + " player(s) will be playing this game\n");
    }

    public void getPlayerNames() {
        for (int i = 1; i <= numPlayers; i++) {
            String input;

            do {
                input = GeneralGameHelper.getNonEmptyStringQ("Player " + i + " name: ");

                for (Player p : players) {
                    if (p.getName().toLowerCase().equals(input.toLowerCase())) {
                        System.out.println("\n" + input + " was already used by another player. Please choose another name");
                        input = "";
                        break;
                    }
                }
            } while (input.isEmpty());

            players.add(new Player(input));
        }

        System.out.println("\nThe following player(s) will be playing this game");

        for (Player p : players) {
            System.out.println(p.getName());
        }

        System.out.println("\nEach player will start with " + players.get(0).getMoney() + " coins\n");
    }

    public void getNumRounds() {
        do {
            totalRounds = GeneralGameHelper.getPositiveNumberInRangeQ("Number of rounds to play (5-30): ", 5, 30);
        } while (totalRounds == 0);

        System.out.println("\nYou will be playing " + this.round + " rounds");
    }

    public void playRound() {
        for (int i = 0; i < players.size(); i++) {
            System.out.println("\nRound " + round + " of " + totalRounds + ", " + players.get(i).getName() + "'s turn");
            System.out.println("\nPlease select an action below. You are only able to complete one of the actions per round");

            players.get(i).loseHealth();

            int doneWithTurn = 0;

            while (doneWithTurn == 0) {
                int selection = this.getMainMenuSelection();

                switch (selection) {
                    case 1:
                        doneWithTurn = this.getBuyingAnimalsSelection(players.get(i));
                        break;
                    case 2:
                        doneWithTurn = this.getBuyingFoodSelection(players.get(i));
                        break;
                    case 3:
                        doneWithTurn = this.getFeedingSelection(players.get(i));
                        break;
                    case 4:
                        doneWithTurn = this.getMatingSelection(players.get(i));
                        break;
                    case 5:
                        doneWithTurn = this.getSellingSelection(players.get(i));
                        break;
                    default:
                        return;
                }
            }
        }

        this.round++;
    }

    private int getMainMenuSelection() {
        int selection;

        do {
            this.printMainMenu();
            selection = GeneralGameHelper.getPositiveNumberInRangeQ("\nWhat would you like to do: ", 1, 5);
        } while (selection == 0);

        return selection;
    }

    private void printMainMenu() {
        System.out.println("\n1) Buy animals");
        System.out.println("2) Buy food");
        System.out.println("3) Feed your animals");
        System.out.println("4) Mate a pair of animals");
        System.out.println("5) Sell animals");
        System.out.println("QUIT) Quit the game");
    }

    private int getBuyingAnimalsSelection(Player player) {
        int selection;
        int canNotGoBack = 0;

        do {
            BuyingAnimalsHelper.printBuyingAnimalsMenu(player);

            selection = GeneralGameHelper.getPositiveNumberInRange("\nWhat would you like to do: ", 1, 7);

            if (selection == 6 && canNotGoBack == 1) {
                System.out.println("\nYou have already bought an animal. You cannot take other actions besides buying animals this turn.");
                selection = 0;
            }

            if (selection > 0 && selection < 6) {
                int temp = BuyingAnimalsHelper.chooseSexAndNameAndBuy(player, selection);

                if (canNotGoBack == 0 && temp == 1) {
                    canNotGoBack = 1;
                }
            }

        } while (selection < 6);

        if (selection == 6) {
            return 0;
        } else {
            return 1;
        }
    }

    private int getBuyingFoodSelection(Player player) {
        int selection;
        int canNotGoBack = 0;

        do {
            BuyingFoodHelper.printBuyingFoodMenu(player);

            selection = GeneralGameHelper.getPositiveNumberInRange("\nWhat would you like to do: ", 1, 5);

            if (selection == 4 && canNotGoBack == 1) {
                System.out.println("\nYou have already bought food. You cannot take other actions besides buying food this turn.");
                selection = 0;
            }

            if (selection > 0 && selection < 4) {
                int temp = BuyingFoodHelper.chooseAmountAndBuy(player, selection);

                if (canNotGoBack == 0 && temp == 1) {
                    canNotGoBack = 1;
                }
            }

        } while (selection < 4);

        if (selection == 4) {
            return 0;
        } else {
            return 1;
        }
    }

    private int getFeedingSelection(Player player) {
        int selection;
        int canNotGoBack = 0;

        do {
            FeedingHelper.printFeedingMenu(player);

            selection = GeneralGameHelper.getPositiveNumberInRange("\nWhat would you like to do: ", 1, 5);

            if (selection == 4 && canNotGoBack == 1) {
                System.out.println("\nYou have already fed an animal. You cannot take other actions besides feeding animals this turn.");
                selection = 0;
            }

            if (selection > 0 && selection < 4) {
                int temp = FeedingHelper.selectAndFeedAnimal(player, selection);

                if (canNotGoBack == 0 && temp == 1) {
                    canNotGoBack = 1;
                }
            }
        } while (selection < 4);

        if (selection == 4) {
            return 0;
        } else {
            return 1;
        }
    }

    private int getMatingSelection(Player player) {
        int selection;
        int mated = 0;

        do {
            MatingHelper.printMatingMenu();

            selection = GeneralGameHelper.getPositiveNumberInRange("\nWhat would you like to do: ", 1, 6);

            if (selection > 0 && selection < 6) {
                mated = MatingHelper.mateAnimals(player, selection);
            }

        } while (selection < 6 && mated == 0);

        if (selection == 6) {
            return 0;
        } else {
            return 1;
        }
    }

    private int getSellingSelection(Player player) {
        int selection;
        int canNotGoBack = 0;

        do {
            SellingHelper.printSellingMenu();

            selection = GeneralGameHelper.getPositiveNumberInRange("\nWhat would you like to do: ", 1, 7);

            if (selection == 6 && canNotGoBack == 1) {
                System.out.println("\nYou have already sold an animal. You cannot take other actions besides selling animals this turn.");
                selection = 0;
            }

            if (selection > 0 && selection < 6) {
                int temp = SellingHelper.selectAndSellAnimal(player, selection);

                if (canNotGoBack == 0 && temp == 1) {
                    canNotGoBack = 1;
                }
            }
        } while (selection < 6);

        if (selection == 6) {
            return 0;
        } else {
            return 1;
        }
    }
}
