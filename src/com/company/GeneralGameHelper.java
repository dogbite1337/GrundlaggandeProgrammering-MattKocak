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

    public static void printAnimalListWithSexAndType(ArrayList<Animal> list) {
        for (Animal a : list) {
            System.out.println(a.getName() + " the " + a.getSex().toLowerCase() + " " + a.getType().toLowerCase());
        }
    }

    public static void printAnimalListWithHealth(ArrayList<Animal> list) {
        for (Animal a : list) {
            System.out.println(a.getName() + " - " + a.getHealth() + " (lost " + (a.getPreviousHealth() - a.getHealth()) + " health)");
        }
    }

    public static void printPlayerSummary(Player player) {
        clear();
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
}
