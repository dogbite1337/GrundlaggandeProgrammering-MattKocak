package com.company.helper;

import com.company.Player;
import com.company.animal.Animal;
import com.company.animal.Elephant;
import com.company.animal.Hare;
import com.company.animal.Mouse;
import java.util.*;

/**
 * Static methods used to assist with various prompting, print, and calculation functions for gameplay
 */
public class GeneralGameHelper {
    /**
     * Prompts the user for a number in a range and returns their selection. If player enters an invalid
     * number, the player is prompted with a statement and 0 is returned
     * @param prompt String that the user is prompted with
     * @param min minimum value to be entered
     * @param max maximum value to be entered
     * @return number entered by player, 0 if an invalid String is entered
     */
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
            clear();
            System.out.print("Please select a valid menu option between " + min + " and " + max);
            getString("");
            return 0;
        }

        return selection;
    }

    /**
     * Prompts the user for a number in a range and returns their selection. If player enters an invalid
     * number, the player is prompted with a statement and 0 is returned. Takes into account that a player
     * can enter "quit" to end the game
     * @param prompt String that the user is prompted with
     * @param min minimum value to be entered
     * @param max maximum value to be entered
     * @return number entered by player, 0 if an invalid String is entered
     */
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
            clear();
            System.out.print("Please select a valid menu option between " + min + " and " + max);
            getString("");
            selection = 0;
        }

        return selection;
    }

    /**
     * Prompts user for a non-empty string. String must be 20 characters or below and cannot be "quit"
     * @param prompt String to prompt the user with
     * @return String the player entered. If "quit", an empty string, or a String longer than 20 characters
     * is entered, "" is returned.
     */
    public static String getNonEmptyString(String prompt) {
        Scanner scan = new Scanner(System.in);
        String input;

        System.out.print(prompt);

        try {
            input = scan.nextLine();

            if (input.equalsIgnoreCase("quit")) {
                clear();
                System.out.print("\"Quit\" cannot be used as a name");
                getString("");
                return "";
            }

            if (input.length() > 20) {
                throw new Exception();
            }
        } catch (Exception e) {
            clear();
            System.out.print("Cannot have a name longer than 20 characters");
            getString("");
            return "";
        }

        return input;
    }

    /**
     * Prompts user for a non-empty string. String must be 20 characters or below and cannot be "quit".
     * If "quit" is entered, the player is prompted whether thye would like to quit the game
     * @param prompt String to prompt the user with
     * @return String the player entered. If "quit", an empty string, or a String longer than 20 characters
     * is entered, "" is returned.
     */
    public static String getNonEmptyStringQ(String prompt) {
        Scanner scan = new Scanner(System.in);
        String input;

        System.out.print(prompt);

        try {
            input = scan.nextLine();

            if (input.equalsIgnoreCase("quit")) {
                quit();
                clear();
                System.out.print("\"Quit\" cannot be used as a name");
                getString("");
                return "";
            }

            if (input.length() > 20) {
                throw new Exception();
            }
        } catch (Exception e) {
            clear();
            System.out.print("Cannot have a name longer than 20 characters");
            getString("");
            return "";
        }

        return input;
    }

    /**
     * Prompts user for a string. This method can be used to display text on it's own screen, which
     * a player can then press enter to continue through
     * @param prompt String to prompt the user with
     * @return String that the user enters
     */
    public static String getString(String prompt) {
        Scanner scan = new Scanner(System.in);

        System.out.print(prompt);

        return scan.nextLine();
    }

    /**
     * Prompts a user for a positive number
     * @param prompt String to prompt user with
     * @return positive number entered by the player, 0 if an invalid String is entered
     */
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
            clear();
            System.out.print("Please select a valid positive number");
            getString("");
            return 0;
        }

        return number;
    }

    /**
     * Prints all animals with their price in a given list
     * @param list list of animals to print
     */
    public static void printAnimalListWithPrice(ArrayList<Animal> list) {
        for (Animal a : list) {
            System.out.println(a.getName() + " (" + (int) (a.getPrice() * ((double) a.getHealth()) / 100) + ")");
        }
    }

    /**
     * Prints all animals with their sex and type in a given list
     * @param list list of animals to print
     */
    public static void printAnimalListWithSexAndType(ArrayList<Animal> list) {
        for (Animal a : list) {
            System.out.println(a.getName() + " the " + a.getSex().toLowerCase() + " " + a.getType().toLowerCase());
        }
    }

    /**
     * Prints all animals with their current health and last rounds lost health in a given list
     * @param list list of animals to print
     */
    public static void printAnimalListWithHealth(ArrayList<Animal> list) {
        for (Animal a : list) {
            System.out.println(a.getName() + " - " + a.getHealth() + " (lost " + (a.getPreviousHealth() - a.getHealth()) + " health)");
        }
    }

    /**
     * Prints a given player's summary of animals that died during the previous round, a summary of their
     * animals and health, their money count, and their food count
     * @param player Player whose summary is being printed
     */
    public static void printPlayerSummary(Player player) {
        System.out.println(player.getName() + "'s player summary\r\n");

        if (player.getLastRoundsDeadAnimals().isEmpty()) {
            System.out.println("No animals died last round");
        } else {
            System.out.println("Animals that have died since last round:");
            printAnimalListWithSexAndType(player.getLastRoundsDeadAnimals());
        }

        if (player.hasLiveAnimals()) {
            System.out.println("\r\nSummary of animals that you own");
            if (!player.getMaleElephants().isEmpty() || !player.getFemaleElephants().isEmpty()) {
                System.out.println("Elephants");
                if (!player.getMaleElephants().isEmpty()) {
                    System.out.println("Male:");
                    printAnimalListWithHealth(player.getMaleElephants());
                    System.out.println();
                }
                if (!player.getFemaleElephants().isEmpty()) {
                    System.out.println("Female:");
                    printAnimalListWithHealth(player.getFemaleElephants());
                    System.out.println();
                }
            }

            if (!player.getMaleBuffaloes().isEmpty() || !player.getFemaleBuffaloes().isEmpty()) {
                System.out.println("Buffaloes");
                if (!player.getMaleBuffaloes().isEmpty()) {
                    System.out.println("Male:");
                    printAnimalListWithHealth(player.getMaleBuffaloes());
                    System.out.println();
                }
                if (!player.getFemaleBuffaloes().isEmpty()) {
                    System.out.println("Female:");
                    printAnimalListWithHealth(player.getFemaleBuffaloes());
                    System.out.println();
                }
            }

            if (!player.getMaleBoars().isEmpty() || !player.getFemaleBoars().isEmpty()) {
                System.out.println("Boars");
                if (!player.getMaleBoars().isEmpty()) {
                    System.out.println("Male:");
                    printAnimalListWithHealth(player.getMaleBoars());
                    System.out.println();
                }
                if (!player.getFemaleBoars().isEmpty()) {
                    System.out.println("Female:");
                    printAnimalListWithHealth(player.getFemaleBoars());
                    System.out.println();
                }
            }

            if (!player.getMaleHares().isEmpty() || !player.getFemaleHares().isEmpty()) {
                System.out.println("Hares");
                if (!player.getMaleHares().isEmpty()) {
                    System.out.println("Male:");
                    printAnimalListWithHealth(player.getMaleHares());
                    System.out.println();
                }
                if (!player.getFemaleHares().isEmpty()) {
                    System.out.println("Female:");
                    printAnimalListWithHealth(player.getFemaleHares());
                    System.out.println();
                }
            }

            if (!player.getMaleMice().isEmpty() || !player.getFemaleMice().isEmpty()) {
                System.out.println("Mice");
                if (!player.getMaleMice().isEmpty()) {
                    System.out.println("Male:");
                    printAnimalListWithHealth(player.getMaleMice());
                    System.out.println();
                }
                if (!player.getFemaleMice().isEmpty()) {
                    System.out.println("Female:");
                    printAnimalListWithHealth(player.getFemaleMice());
                    System.out.println();
                }
            }
        } else {
            System.out.println("\r\nYou do not own any animals\r\n");
        }

        if (player.hasFood()) {
            System.out.println("You have " + player.getHay() + " bales of hay, " + player.getSoy() + " bushels of soy, and " + player.getPellets() + " bags of pellets\r\n");
        } else {
            System.out.println("You have no food\r\n");
        }

        System.out.print("You have " + player.getMoney() + " coins");
    }

    /**
     * Returns a dummy animal from a common menu integer selection integer. This is useful for simplifying
     * methods that print generic details about selected animals
     * @param selection int that a player has selected in a menu
     * @return Animal corresponding to a common menu integer selection
     */
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

    /**
     * Determines if an animal with a given name is in a specified list
     * @param name name of animal
     * @param list animal list to search
     * @return True if animal is present, False otherwise
     */
    public static boolean isAnimalInList(String name, ArrayList<Animal> list) {
        for (Animal a : list) {
            if (a.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the ordinal string for the numbers 1, 2, 3, or 4
     * @param i integer 1, 2, 3, or 4
     * @return ordinal string of inputted int
     */
    public static String ordinalString(int i) {
        if (i == 1) {
            return "1st";
        } else if (i == 2) {
            return "2nd";
        } else if (i == 3) {
            return "3rd";
        } else {
            return "4th";
        }
    }

    /**
     * Clears the console screen
     */
    public static void clear() {
        System.out.print("\r\n".repeat(50));
    }

    /**
     * Prompts user whether or not they would like to quit the game and exits program if they confirm
     */
    private static void quit() {
        Scanner scan = new Scanner(System.in);

        GeneralGameHelper.clear();
        System.out.println("Quitting will end the game for all players and no final score will be given. This cannot be undone");
        System.out.print("Please verify that you would like to quit the game by typing QUIT: ");

        if (scan.nextLine().equalsIgnoreCase("quit")) {
            System.out.println("\nExiting the program..");
            System.exit(0);
        }
    }
}
