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
                    System.exit(0);
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
                        System.exit(0);
                    }

                    if (input.isEmpty()) {
                        throw new Exception();
                    }

                    players.add(new Player(input));
                } catch (Exception e) {
                    System.out.println("\nPlease enter a name");
                }
            } while (input.isEmpty());
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
                    System.exit(0);
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
}
