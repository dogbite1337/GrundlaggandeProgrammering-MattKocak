package com.company;

import java.util.*;

public class Game {
    private int round;
    private int numPlayers;
    private LinkedList<Player> players;

    public Game () {
        System.out.println("Welcome to Animal Farm!");
        System.out.println("Enter QUIT to exit game\n");
        this.players = new LinkedList<Player>();
    }

    public void getNumPlayers() {
        Scanner scan = new Scanner(System.in);

        do {
            System.out.print("Number of players (1-4): ");

            try {
                String input = scan.nextLine();

                if (input.toLowerCase().equals("quit")) {
                    this.quit();
                }

                this.numPlayers = Integer.parseInt(input);

                if (this.numPlayers < 1 || this.numPlayers > 4) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("\nPlease enter a valid number between 1 and 4");
            }
        } while (this.numPlayers < 1 || this.numPlayers > 4);

        System.out.println("\n" + this.numPlayers + " player(s) will be playing this game\n");
    }

    public void getPlayerNames() {
        Scanner scan = new Scanner(System.in);

        for (int i = 1; i <= numPlayers; i++) {
            String input = "";

            do {
                System.out.print("Player " + i + " name: ");

                try {
                    input = scan.nextLine();

                    if (input.toLowerCase().equals("quit")) {
                        this.quit();
                        System.out.println("\n\"Quit\" cannot be used as a name");
                    }

                    if (input.isEmpty()) {
                        throw new Exception();
                    }

                    players.add(new Player(input));
                } catch (Exception e) {
                    System.out.println("\nPlease enter a name");
                }
            } while (input.isEmpty() || input.toLowerCase().equals("quit"));
        }

        System.out.println("\nThe following player(s) will be playing this game");

        for (Player player : players) {
            System.out.println(player.getName());
        }

        System.out.println("\nEach player will start with " + players.get(0).getMoney() + " coins\n");
    }

    public void getNumRounds() {
        Scanner scan = new Scanner(System.in);

        do {
            System.out.print("Number of rounds to play (5-30): ");

            try {
                String input = scan.nextLine();

                if (input.toLowerCase().equals("quit")) {
                    this.quit();
                }

                this.round = Integer.parseInt(input);

                if (this.round < 5 || this.round > 30) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("\nPlease enter a valid number between 5 and 30");
            }
        } while (this.round < 5 || this.round > 30);

        System.out.println("\nYou will be playing " + this.round + " rounds");
    }

    public void playRound() {
        for (int i = 1; i <= players.size(); i++) {
            System.out.println("\nRound " + round + ": Player " + i + "'s turn\n");
            System.out.println("Please select an action below. You are only able to complete one of the actions per round\n");
            int doneWithTurn = 0;

            while (doneWithTurn == 0) {
                int selection = this.getMainMenuSelection();

                switch (selection) {
                    case 1:
                        doneWithTurn = this.getBuyingAnimalsSelection(players.get(i - 1));
                        break;/*
                    case 2:
                        this.getBuyingFoodSelection();
                        break;
                    case 3:
                        this.getFeedingSelection();
                        break;
                    case 4:
                        this.getMatingSelection();
                        break;
                    case 5:
                        this.getSellingSelection();
                        break;*/
                    default:
                        return;
                }
            }
        }
    }

    private int getMainMenuSelection() {
        Scanner scan = new Scanner(System.in);
        int selection = 0;

        do {
            this.printMainMenu();
            System.out.print("\nWhat would you like to do: ");

            try {
                String input = scan.nextLine();

                if (input.toLowerCase().equals("quit")) {
                    this.quit();
                }

                selection = Integer.parseInt(input);

                if (selection < 1 || selection > 5) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("\nPlease select a valid menu option between 1 and 5");
            }
        } while (selection < 1 || selection > 5);

        return selection;
    }

    private void printMainMenu() {
        System.out.println("1) Buy animals");
        System.out.println("2) Buy food");
        System.out.println("3) Feed your animals");
        System.out.println("4) Mate a pair of animals");
        System.out.println("5) Sell animals");
        System.out.println("QUIT) Quit the game");
    }

    private int getBuyingAnimalsSelection(Player player) {
        Scanner scan = new Scanner(System.in);
        int selection = 0;
        int canNotGoBack = 0;

        do {
            this.printBuyingAnimalsMenu(player);
            System.out.print("\nWhat would you like to do: ");

            try {
                String input = scan.nextLine();

                selection = Integer.parseInt(input);

                if (selection < 1 || selection > 7) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("\nPlease select a valid menu option between 1 and 7");
            }

            if (selection == 6 && canNotGoBack == 1) {
                System.out.println("\nYou have already bought an animal. You cannot take other actions besides buying animals this turn.");
                selection = 0;
            }

            if (selection > 0 && selection < 6) {
                canNotGoBack = this.chooseSexAndNameAndBuy(player, selection);
            }

        } while (selection < 6 || selection > 7);

        if (selection == 6) {
            return 0;
        } else {
            return 1;
        }
    }

    private void printBuyingAnimalsMenu(Player player) {
        System.out.println("\nYou have " + player.getMoney() + " coins\n");
        System.out.println("1) Buy elephant (" + Elephant.cost + " coins)");
        System.out.println("2) Buy buffalo (" + Buffalo.cost + " coins)");
        System.out.println("3) Buy boar (" + Boar.cost + " coins)");
        System.out.println("4) Buy hare (" + Hare.cost + " coins)");
        System.out.println("5) Buy mouse (" + Mouse.cost + " coins)");
        System.out.println("6) Back to main menu");
        System.out.println("7) End turn");
    }

    private int chooseSexAndNameAndBuy(Player player, int selection) {
        if (selection == 1 && player.getMoney() < Elephant.cost) {
            System.out.println("\nYou don't have enough money to buy an elephant");
            return 0;
        } else if (selection == 1) {
            int sex = this.getSex("Elephant");

            if (sex != 3) {
                String name = this.getAnimalName("Elephant");
                player.buyElephant(name, sex);
                System.out.println("Congratulations, you just bought " + name + " the elephant!");
                return 1;
            }

            return 0;
        } else if (selection == 2 && player.getMoney() < Buffalo.cost) {
            System.out.println("\nYou don't have enough money to buy a buffalo");
            return 0;
        } else if (selection == 2) {
            int sex = this.getSex("Buffalo");

            if (sex != 3) {
                String name = this.getAnimalName("Buffalo");
                player.buyBuffalo(name, sex);
                System.out.println("\nCongratulations, you just bought " + name + " the buffalo!");
                return 1;
            }

            return 0;
        } else if (selection == 3 && player.getMoney() < Boar.cost) {
            System.out.println("\nYou don't have enough money to buy a boar");
            return 0;
        } else if (selection == 3) {
            int sex = this.getSex("Boar");

            if (sex != 3) {
                String name = this.getAnimalName("Boar");
                player.buyBoar(name, sex);
                System.out.println("\nCongratulations, you just bought " + name + " the boar!");
                return 1;
            }

            return 0;
        } else if (selection == 4 && player.getMoney() < Hare.cost) {
            System.out.println("\nYou don't have enough money to buy a hare");
            return 0;
        } else if (selection == 4) {
            int sex = this.getSex("Hare");

            if (sex != 3) {
                String name = this.getAnimalName("Hare");
                player.buyHare(name, sex);
                System.out.println("\nCongratulations, you just bought " + name + " the hare!");
                return 1;
            }

            return 0;
        } else if (selection == 5 && player.getMoney() < Mouse.cost) {
            System.out.println("\nYou don't have enough money to buy a mouse");
            return 0;
        } else if (selection == 5) {
            int sex = this.getSex("Mouse");

            if (sex != 3) {
                String name = this.getAnimalName("Mouse");
                player.buyMouse(name, sex);
                System.out.println("\nCongratulations, you just bought " + name + " the mouse!");
                return 1;
            }

            return 0;
        }

        return 0;
    }

    private int getSex(String animal) {
        System.out.println("\n1) Male");
        System.out.println("2) Female");
        System.out.println("3) Back to previous menu\n");

        Scanner scan = new Scanner(System.in);
        int selection = 0;

        do {
            System.out.print("Choose " + animal + "'s sex: ");

            try {
                String input = scan.nextLine();

                selection = Integer.parseInt(input);

                if (selection < 1 || selection > 3) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("\nPlease enter a valid number between 1 and 3");
            }
        } while (selection < 1 || selection > 3);

        return selection;
    }

    private String getAnimalName(String animal) {
        Scanner scan = new Scanner(System.in);
        String name = "";

        do {
            System.out.print("Choose " + animal + "'s name: ");

            try {
                name = scan.nextLine();

                if (name.isEmpty()) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("\nPlease enter a name");
            }
        } while (name.isEmpty());

        return name;
    }

    public int numRounds() {
        return round;
    }

    private void quit() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nQuitting will end the game for all players and no final score will be given. This cannot be undone");
        System.out.print("Please verify that you would like to quit the game by typing QUIT: ");

        if (scan.nextLine().toLowerCase().equals("quit")) {
            System.out.println("\nExiting the program..");
            System.exit(0);
        }
    }
}
