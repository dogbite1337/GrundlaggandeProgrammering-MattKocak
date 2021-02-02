package com.company;

import java.util.Scanner;

public class GeneralGameHelper {

    public static int getPositiveNumberInRange(String prompt, int min, int max) {
        Scanner scan = new Scanner(System.in);
        int selection = 0;

        System.out.print(prompt);

        try {
            String input = scan.nextLine();

            selection = Integer.parseInt(input);

            if (selection < min || selection > max) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("\nPlease select a valid menu option between " + min + " and " + max);
            selection = 0;
        }

        return selection;
    }

    public static int getPositiveNumberInRangeQ(String prompt, int min, int max) {
        Scanner scan = new Scanner(System.in);
        int selection = 0;

        System.out.print(prompt);

        try {
            String input = scan.nextLine();

            if (input.toLowerCase().equals("quit")) {
                quit();
            }

            selection = Integer.parseInt(input);

            if (selection < min || selection > max) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("\nPlease select a valid menu option between " + min + " and " + max);
            selection = 0;
        }

        return selection;
    }

    public static String getNonEmptyString(String prompt) {
        Scanner scan = new Scanner(System.in);
        String input = "";

        System.out.print(prompt);

        try {
            input = scan.nextLine();

            if (input.toLowerCase().equals("quit")) {
                System.out.println("\n\"Quit\" cannot be used as a name");
            }

            if (input.isEmpty()) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("\nPlease enter a name");
        }

        if (input.toLowerCase().equals("quit")) {
            input = "";
        }

        return input;
    }

    public static String getNonEmptyStringQ(String prompt) {
        Scanner scan = new Scanner(System.in);
        String input = "";

        System.out.print(prompt);

        try {
            input = scan.nextLine();

            if (input.toLowerCase().equals("quit")) {
                quit();
                System.out.println("\n\"Quit\" cannot be used as a name");
            }

            if (input.isEmpty()) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("\nPlease enter a name");
        }

        if (input.toLowerCase().equals("quit")) {
            input = "";
        }

        return input;
    }

    public static String getString(String prompt) {
        Scanner scan = new Scanner(System.in);

        System.out.print(prompt);

        return scan.nextLine();
    }

    public static int getPositiveNumber(String prompt) {
        Scanner scan = new Scanner(System.in);
        int number = 0;

        System.out.print(prompt);

        try {
            String input = scan.nextLine();

            number = Integer.parseInt(input);

            if (number < 1) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("\nPlease select a valid positive number");
            number = 0;
        }

        return number;
    }

    private static void quit() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nQuitting will end the game for all players and no final score will be given. This cannot be undone");
        System.out.print("Please verify that you would like to quit the game by typing QUIT: ");

        if (scan.nextLine().toLowerCase().equals("quit")) {
            System.out.println("\nExiting the program..");
            System.exit(0);
        }
    }
}
