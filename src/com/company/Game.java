package com.company;

import com.company.animal.Mouse;
import com.company.helper.*;

import java.util.*;

public class Game {
    private int totalRounds;
    private int round;
    private int numPlayers;
    private final LinkedList<Player> players;

    public Game () {
        System.out.println("Welcome to Animal Farm!");
        GeneralGameHelper.getString("Press ENTER to continue or type QUIT to exit game\r\n");
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
            GeneralGameHelper.clear();
            this.numPlayers = GeneralGameHelper.getPositiveNumberInRangeQ("Number of players (1-4): ", 1, 4);
        } while (this.numPlayers == 0);
    }

    public void getPlayerNames() {
        for (int i = 1; i <= numPlayers; i++) {
            String input;

            do {
                GeneralGameHelper.clear();
                input = GeneralGameHelper.getNonEmptyStringQ("Player " + i + " name: ");

                for (Player p : players) {
                    if (p.getName().equalsIgnoreCase(input)) {
                        GeneralGameHelper.clear();
                        GeneralGameHelper.getString(input + " was already used by another player. Please choose another name");
                        input = "";
                        break;
                    }
                }
            } while (input.isEmpty());

            players.add(new Player(input));
        }

        GeneralGameHelper.clear();

        System.out.println("The following player(s) will be playing this game");

        for (Player p : players) {
            System.out.println(p.getName());
        }

        GeneralGameHelper.getString("\r\nEach player will start with " + players.get(0).getMoney() + " coins");
    }

    public void getNumRounds() {
        do {
            GeneralGameHelper.clear();
            totalRounds = GeneralGameHelper.getPositiveNumberInRangeQ("Number of rounds to play (5-30): ", 5, 30);
        } while (totalRounds == 0);
    }

    public void playRound() {
        for (Player player : players) {
            if (!player.isPlaying()) {
                continue;
            }

            if (this.isPlayerOut(player)) {
                player.noLongerPlaying();
                GeneralGameHelper.clear();
                System.out.println("Round " + round + " of " + totalRounds + ", " + player.getName() + "'s turn");
                System.out.println("\r\nYou have no animals and don't have enough money to buy an animal");
                GeneralGameHelper.getString("You will be skipped in the remaining rounds. Your final total is " + player.getMoney() + " coins");
                continue;
            }

            if (round != 1) {
                GeneralGameHelper.clear();
                GeneralGameHelper.printPlayerSummary(player);
                GeneralGameHelper.getString("");
            }

            GeneralGameHelper.clear();
            System.out.println("Round " + round + " of " + totalRounds + ", " + player.getName() + "'s turn");
            System.out.println("\r\nPlease select an action below. You are only able to complete one of the actions per round");
            System.out.println("Printing your player summary does not count as an action\r\n");

            int doneWithTurn = 0;

            while (doneWithTurn == 0) {
                int selection = this.getMainMenuSelection();

                switch (selection) {
                    case 1:
                        doneWithTurn = this.getBuyingAnimalsSelection(player);
                        break;
                    case 2:
                        doneWithTurn = this.getBuyingFoodSelection(player);
                        break;
                    case 3:
                        doneWithTurn = this.getFeedingSelection(player);
                        break;
                    case 4:
                        doneWithTurn = this.getMatingSelection(player);
                        break;
                    case 5:
                        doneWithTurn = this.getSellingSelection(player);
                        break;
                    case 6:
                        GeneralGameHelper.clear();
                        GeneralGameHelper.printPlayerSummary(player);
                        GeneralGameHelper.getString("");
                        break;
                    default:
                        break;
                }
                GeneralGameHelper.clear();
            }
            player.loseHealth();
        }

        this.round++;
    }

    private boolean isPlayerOut(Player player) {
        return !player.hasLiveAnimals() && player.getMoney() < Mouse.cost;
    }

    private int getMainMenuSelection() {
        int selection;

        do {
            this.printMainMenu();
            selection = GeneralGameHelper.getPositiveNumberInRangeQ("\r\nWhat would you like to do: ", 1, 6);
        } while (selection == 0);

        return selection;
    }

    private void printMainMenu() {
        System.out.println("1) Buy animals");
        System.out.println("2) Buy food");
        System.out.println("3) Feed your animals");
        System.out.println("4) Mate a pair of animals");
        System.out.println("5) Sell animals");
        System.out.println("6) Print player summary");
        System.out.println("QUIT) Quit the game");
    }

    private int getBuyingAnimalsSelection(Player player) {
        int selection;
        int canNotGoBack = 0;

        do {
            GeneralGameHelper.clear();
            BuyingAnimalsHelper.printBuyingAnimalsMenu(player);

            selection = GeneralGameHelper.getPositiveNumberInRange("\r\nWhat would you like to do: ", 1, 7);

            if (selection == 6 && canNotGoBack == 1) {
                GeneralGameHelper.clear();
                GeneralGameHelper.getString("You have already bought an animal. You cannot take other actions besides buying animals this turn");
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
            GeneralGameHelper.clear();
            BuyingFoodHelper.printBuyingFoodMenu(player);

            selection = GeneralGameHelper.getPositiveNumberInRange("\r\nWhat would you like to do: ", 1, 5);

            if (selection == 4 && canNotGoBack == 1) {
                GeneralGameHelper.clear();
                GeneralGameHelper.getString("You have already bought food. You cannot take other actions besides buying food this turn");
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
            GeneralGameHelper.clear();
            FeedingHelper.printFeedingMenu(player);

            selection = GeneralGameHelper.getPositiveNumberInRange("\r\nWhat would you like to do: ", 1, 5);

            if (selection == 4 && canNotGoBack == 1) {
                GeneralGameHelper.clear();
                GeneralGameHelper.getString("You have already fed an animal. You cannot take other actions besides feeding animals this turn");
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
            GeneralGameHelper.clear();
            MatingHelper.printMatingMenu();

            selection = GeneralGameHelper.getPositiveNumberInRange("\r\nWhat would you like to do: ", 1, 6);

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
            GeneralGameHelper.clear();
            SellingHelper.printSellingMenu();

            selection = GeneralGameHelper.getPositiveNumberInRange("\r\nWhat would you like to do: ", 1, 7);

            if (selection == 6 && canNotGoBack == 1) {
                GeneralGameHelper.clear();
                GeneralGameHelper.getString("You have already sold an animal. You cannot take other actions besides selling animals this turn");
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

    public void scoreGame() {
        GeneralGameHelper.clear();
        System.out.println("You've played all " + totalRounds + " of " + totalRounds + " rounds");
        System.out.println("The animals for each player will now be liquidated and added to the player's current coin total");
        GeneralGameHelper.getString("And the final score is...");

        this.determinePlayerScoreAndSort();

        GeneralGameHelper.clear();

        int place = 1;

        while (!players.isEmpty()) {
            System.out.print("\r\n" + GeneralGameHelper.ordinalString(place) + " place: " + players.get(0).getName());

            while (players.size() > 1) {
                if (players.get(1).getMoney() == players.get(0).getMoney()) {
                    System.out.print(", " + players.get(1).getName());
                    players.remove(0);
                    place++;
                    continue;
                }
                break;
            }

            System.out.print(" (" + players.remove(0).getMoney() + " coins)");
            place++;
        }

        GeneralGameHelper.getString("");
    }

    private void determinePlayerScoreAndSort() {
        for (Player player : players) {
            player.calculateFinalScore();
        }

        for (int i = 0; i < players.size(); i++) {
            for (int j = i + 1; j < players.size(); j++) {
                if (players.get(j).getMoney() > players.get(i).getMoney()) {
                    Player temp = players.get(i);
                    players.set(i, players.get(j));
                    players.set(j, temp);
                }
            }
        }
    }

    public static String lastDialog() {
        GeneralGameHelper.clear();
        return GeneralGameHelper.getString("Would you like to play another game (Y/N)? ");
    }
}
