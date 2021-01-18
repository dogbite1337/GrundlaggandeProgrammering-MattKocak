package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Animal Farm!\n");

        Scanner scan = new Scanner(System.in);
        int numPlayers = 0;
        int numRounds = 0;

        do {
            System.out.println("Enter QUIT to exit game");
            System.out.print("Number of players (1-4): ");

            try {
                String input = scan.nextLine();

                if (input.toLowerCase().equals("quit")) {
                    System.exit(0);
                }

                numPlayers = Integer.parseInt(input);

                if (numPlayers < 1 || numPlayers > 4) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("\nPlease enter a valid number between 1 and 4");
            }
        } while (numPlayers < 1 || numPlayers > 4);

        System.out.println("\n" + numPlayers + " player(s) will be playing this game\n");

        do {
            System.out.println("Enter QUIT to exit game");
            System.out.print("Number of rounds to play (5-30): ");

            try {
                String input = scan.nextLine();

                if (input.toLowerCase().equals("quit")) {
                    System.exit(0);
                }

                numRounds = Integer.parseInt(input);

                if (numRounds < 5 || numRounds > 30) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("\nPlease enter a valid number between 5 and 30");
            }
        } while (numRounds < 5 || numRounds > 30);

        System.out.println("\nYou will be playing " + numRounds + " rounds");

        Game game = new Game(numPlayers, numRounds);
    }
}
