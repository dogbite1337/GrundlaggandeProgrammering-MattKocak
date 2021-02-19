package com.company;

import com.company.animal.Mouse;
import com.company.helper.*;
import java.util.*;

/**
 * Primary class used to conduct gameplay and keep track of players and rounds
 */
public class Game {
    private int totalRounds; //Number of total rounds that will be played
    private int round; //Current game's round being played
    private int numPlayers; //Number of players playing a game
    private LinkedList<Player> players; //List of players playing a game

    /**
     * Starts gameplay upon construction
     */
    public Game () {
        this.gamePlay();
    }

    /**
     * Primary Game method that plays a game from start to finish and continues to do so while players
     * choose to play more games
     */
    private void gamePlay() {
        do {
            GeneralGameHelper.clear();
            System.out.println("Welcome to Animal Farm!");
            GeneralGameHelper.getString("Press ENTER to continue or type QUIT to exit game");

            this.players = new LinkedList<>();
            this.round = 1;

            this.getNumPlayers();
            this.getPlayerNames();
            this.getNumRounds();

            while (totalRounds - round >= 0) {
                this.playRound();
            }

            GeneralGameHelper.getString("That concludes the final round. A summary for each player will now be printed");
            for (Player p : players) {
                GeneralGameHelper.clear();
                GeneralGameHelper.printPlayerSummary(p);
                GeneralGameHelper.getString("");
            }

            this.scoreGame();
        } while (lastDialog().equalsIgnoreCase("Y"));
    }

    /**
     * Asks user for number of players in game and sets this field in Game
     */
    private void getNumPlayers() {
        do {
            GeneralGameHelper.clear();
            this.numPlayers = GeneralGameHelper.getPositiveNumberInRangeQ("Number of players (1-4): ", 1, 4);
        } while (this.numPlayers == 0);
    }

    /**
     * Asks users for player names and adds it to the players list in Game
     */
    private void getPlayerNames() {
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

    /**
     * Asks user for number of rounds to play and sets this field in Game
     */
    private void getNumRounds() {
        do {
            GeneralGameHelper.clear();
            totalRounds = GeneralGameHelper.getPositiveNumberInRangeQ("Number of rounds to play (5-30): ", 5, 30);
        } while (totalRounds == 0);
    }

    /**
     * Primary method used so that a player can play a game round and choose various actions
     */
    private void playRound() {
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

    /**
     * Determines if a player has any animals and, if not, if they don't have enough money to buy an animal.
     * A player is considered "out" if these conditions are met
     * @param player Player being evaluated
     * @return True if conditions are met, False otherwise
     */
    private boolean isPlayerOut(Player player) {
        return !player.hasLiveAnimals() && player.getMoney() < Mouse.cost;
    }

    /**
     * Used to print a round's main menu and get a player's selection from that menu
     * @return int containing the player's main menu selection
     */
    private int getMainMenuSelection() {
        int selection;

        do {
            this.printMainMenu();
            selection = GeneralGameHelper.getPositiveNumberInRangeQ("\r\nWhat would you like to do: ", 1, 6);
        } while (selection == 0);

        return selection;
    }

    /**
     * Prints a round's main menu
     */
    private void printMainMenu() {
        System.out.println("1) Buy animals");
        System.out.println("2) Buy food");
        System.out.println("3) Feed your animals");
        System.out.println("4) Mate a pair of animals");
        System.out.println("5) Sell animals");
        System.out.println("6) Print player summary");
        System.out.println("QUIT) Quit the game");
    }

    /**
     * Prints buying animals menu and gets the player's selection
     * @param player Player playing this round
     * @return 1 if player bought an animal, 0 otherwise
     */
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

    /**
     * Prints buying food menu and gets the player's selection
     * @param player Player playing this round
     * @return 1 if player bought food, 0 otherwise
     */
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

    /**
     * Prints feeding animals menu and gets the player's selection
     * @param player Player playing this round
     * @return 1 if player fed an animal, 0 otherwise
     */
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

    /**
     * Prints mating animals menu and gets the player's selection
     * @param player Player playing this round
     * @return 1 if player attempted to mate an animal, 0 otherwise
     */
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

    /**
     * Prints selling animals menu and gets the player's selection
     * @param player Player playing this round
     * @return 1 if player sold an animal, 0 otherwise
     */
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

    /**
     * Calculates each player's final coin score and displays it to the users
     */
    private void scoreGame() {
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

    /**
     * Calculates each player's final coin score and orders the players list in descending order
     */
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

    /**
     * Prompts players as to whether they want to play another game and gets their response
     * @return string signifying whether or not players want to play another game
     */
    private static String lastDialog() {
        GeneralGameHelper.clear();
        return GeneralGameHelper.getString("Would you like to play another game (Y/N)? ");
    }
}
