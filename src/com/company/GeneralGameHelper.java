package com.company;

import java.util.*;

public class GeneralGameHelper {

    public static int getPositiveNumberInRange(String prompt, int min, int max) {
        Scanner scan = new Scanner(System.in);
        int selection;

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
        int selection;

        System.out.print(prompt);

        try {
            String input = scan.nextLine();

            if (input.equalsIgnoreCase("quit")) {
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

            if (input.equalsIgnoreCase("quit")) {
                System.out.println("\n\"Quit\" cannot be used as a name");
            }

            if (input.isEmpty()) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("\nPlease enter a name");
        }

        if (input.equalsIgnoreCase("quit")) {
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

            if (input.equalsIgnoreCase("quit")) {
                quit();
                System.out.println("\n\"Quit\" cannot be used as a name");
            }

            if (input.isEmpty()) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("\nPlease enter a name");
        }

        if (input.equalsIgnoreCase("quit")) {
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
        int number;

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

    public static void printAnimalList(ArrayList<Animal> list) {
        for (Animal a : list) {
            System.out.println(a.getName());
        }
    }

    public static void printAnimalListWithPrice(ArrayList<Animal> list) {
        for (Animal a : list) {
            System.out.println(a.getName() + " (" + (int) (a.getPrice() * ((double) a.getHealth()) / 100) + ")");
        }
    }

    public static Animal getAnimalFromSelection(int selection) {
        if (selection == 1) {
            return new Elephant("", "Male", "Elephant", "Elephants");
        } else if (selection == 2) {
            return new Elephant("", "Male", "Buffalo", "Buffaloes");
        } else if (selection == 3) {
            return new Elephant("", "Male", "Boar", "Boars");
        } else if (selection == 4) {
            return new Hare("", "Male", "Hare", "Hares");
        } else {
            return new Mouse("", "Male", "Mouse", "Mice");
        }
    }

    public static boolean isAnimalInList(String name, ArrayList<Animal> list) {
        for (Animal a : list) {
            if (a.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }

        return false;
    }

    public static void clear() {
        System.out.print("\r\n".repeat(50));
    }

    private static void quit() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nQuitting will end the game for all players and no final score will be given. This cannot be undone");
        System.out.print("Please verify that you would like to quit the game by typing QUIT: ");

        if (scan.nextLine().equalsIgnoreCase("quit")) {
            System.out.println("\nExiting the program..");
            System.exit(0);
        }
    }
}
