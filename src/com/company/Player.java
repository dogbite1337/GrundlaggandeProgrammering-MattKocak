package com.company;

import com.company.animal.Animal;
import java.util.*;

/**
 * Keeps track of a player's name, money, animals, and food. Has several methods to evaluate these fields
 */
public class Player {
    private static final int STARTMONEY = 1500; //Starting money
    private final String name; //Player's name
    private int money; //Player's current money
    private final ArrayList<ArrayList<Animal>> animalList; //List containing all of the lists of various animals that the player owns
    private final ArrayList<Animal> maleElephant; //List of male elephants that the player owns
    private final ArrayList<Animal> femaleElephant; //List of female elephants that the player owns
    private final ArrayList<Animal> maleBuffalo; //List of male buffaloes that the player owns
    private final ArrayList<Animal> femaleBuffalo; //List of female buffaloes that the player owns
    private final ArrayList<Animal> maleBoar; //List of male boars that the player owns
    private final ArrayList<Animal> femaleBoar; //List of female boars that the player owns
    private final ArrayList<Animal> maleHare; //List of male hares that the player owns
    private final ArrayList<Animal> femaleHare; //List of female hares that the player owns
    private final ArrayList<Animal> maleMouse; //List of male mice that the player owns
    private final ArrayList<Animal> femaleMouse; //List of female mice that the player owns
    private final ArrayList<Animal> lastRoundsDeadAnimals; //List of animals that died during the previous round
    private int hay; //Amount of hay that the player owns
    private int soy; //Amount of soy that the player owns
    private int pellets; //Amount of pellets that the player owns
    private boolean playing; //True if player still has animals/money, false otherwise

    /**
     * Initializes all class fields
     * @param name name of player
     */
    public Player(String name) {
        this.name = name;
        this.money = STARTMONEY;
        animalList = new ArrayList<>();
        maleElephant = new ArrayList<>();
        animalList.add(maleElephant);
        femaleElephant = new ArrayList<>();
        animalList.add(femaleElephant);
        maleBuffalo = new ArrayList<>();
        animalList.add(maleBuffalo);
        femaleBuffalo = new ArrayList<>();
        animalList.add(femaleBuffalo);
        maleBoar = new ArrayList<>();
        animalList.add(maleBoar);
        femaleBoar = new ArrayList<>();
        animalList.add(femaleBoar);
        maleHare = new ArrayList<>();
        animalList.add(maleHare);
        femaleHare = new ArrayList<>();
        animalList.add(femaleHare);
        maleMouse = new ArrayList<>();
        animalList.add(maleMouse);
        femaleMouse = new ArrayList<>();
        animalList.add(femaleMouse);
        lastRoundsDeadAnimals = new ArrayList<>();
        this.hay = 0;
        this.soy = 0;
        this.pellets = 0;
        this.playing = true;
    }

    /**
     * Gets player's name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets player's money amount
     * @return money amount
     */
    public int getMoney() {
        return money;
    }

    /**
     * Sets player's money amount to a new value
     * @param amount what to set money field to
     */
    public void setMoney(int amount) {
        money = amount;
    }

    /**
     * Gets player's hay amount
     * @return hay amount
     */
    public int getHay() {
        return hay;
    }

    /**
     * Sets player's hay amount to a new value
     * @param amount what to set hay field to
     */
    public void setHay(int amount) {
        hay = amount;
    }

    /**
     * Gets player's soy amount
     * @return soy amount
     */
    public int getSoy() {
        return soy;
    }

    /**
     * Sets player's soy amount to a new value
     * @param amount what to set soy field to
     */
    public void setSoy(int amount) {
        soy = amount;
    }

    /**
     * Gets player's pellets amount
     * @return pellets amount
     */
    public int getPellets() {
        return pellets;
    }

    /**
     * Sets player's pellets amount to a new value
     * @param amount what to set pellets field to
     */
    public void setPellets(int amount) {
        pellets = amount;
    }

    /**
     * Gets player's animal list
     * @return animal list
     */
    public ArrayList<ArrayList<Animal>> getAnimalList() {
        return animalList;
    }

    /**
     * Gets list of player's male elephants
     * @return male elephant list
     */
    public ArrayList<Animal> getMaleElephants() {
        return maleElephant;
    }

    /**
     * Gets list of player's female elephants
     * @return female elephant list
     */
    public ArrayList<Animal> getFemaleElephants() {
        return femaleElephant;
    }

    /**
     * Gets list of player's male buffaloes
     * @return male buffalo list
     */
    public ArrayList<Animal> getMaleBuffaloes() {
        return maleBuffalo;
    }

    /**
     * Gets list of player's female buffaloes
     * @return female buffalo list
     */
    public ArrayList<Animal> getFemaleBuffaloes() {
        return femaleBuffalo;
    }

    /**
     * Gets list of player's male boars
     * @return male boar list
     */
    public ArrayList<Animal> getMaleBoars() {
        return maleBoar;
    }

    /**
     * Gets list of player's female boars
     * @return female boar list
     */
    public ArrayList<Animal> getFemaleBoars() {
        return femaleBoar;
    }

    /**
     * Gets list of player's male hares
     * @return male hare list
     */
    public ArrayList<Animal> getMaleHares() {
        return maleHare;
    }

    /**
     * Gets list of player's female hares
     * @return female hare list
     */
    public ArrayList<Animal> getFemaleHares() {
        return femaleHare;
    }

    /**
     * Gets list of player's male mice
     * @return male mice list
     */
    public ArrayList<Animal> getMaleMice() {
        return maleMouse;
    }

    /**
     * Gets list of player's female mice
     * @return female mice list
     */
    public ArrayList<Animal> getFemaleMice() {
        return femaleMouse;
    }

    /**
     * Gets list of animals that died last round
     * @return dead animals list
     */
    public ArrayList<Animal> getLastRoundsDeadAnimals() {
        return lastRoundsDeadAnimals;
    }

    /**
     * Gets whether a player is still playing or not
     * @return value of playing
     */
    public boolean isPlaying() {
        return playing;
    }

    /**
     * Sets playing to false
     */
    public void noLongerPlaying() {
        playing = false;
    }

    /**
     * Searches all animal lists for a name and returns whether or not it was found
     * @param name String to search for
     * @return True if name was found, False otherwise
     */
    public boolean isNamePresent(String name) {
        for (ArrayList<Animal> l : animalList) {
            for (Animal a : l) {
                if (a.getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Prints all animals of a certain type that don't have 100% health
     * @param type type of animal
     * @return list of all unhealthy animals of the given type
     */
    public List<Animal> printUnhealthyAnimals(String type) {
        ArrayList<Animal> list = new ArrayList<>();

        for (ArrayList<Animal> l : animalList) {
            if(!l.isEmpty() && l.get(0).getType().equals(type)) {
                for (Animal a : l) {
                    if (a.getHealth() != 100) {
                        list.add(a);
                        System.out.println("\"" + a.getName() + "\" the " + a.getSex().toLowerCase() + " " + a.getType().toLowerCase() + " has " + a.getHealth() + " health");
                    }
                }
            }
        }

        return list;
    }

    /**
     * Increases animals health by 10 and subtracts player's hay by 1
     * @param animal animal to feed
     */
    public void feedHay(Animal animal) {
        hay--;
        animal.increaseHealth(10);
    }

    /**
     * Increases animals health by 10 and subtracts player's soy by 1
     * @param animal animal to feed
     */
    public void feedSoy(Animal animal) {
        soy--;
        animal.increaseHealth(10);
    }

    /**
     * Increases animals health by 10 and subtracts player's pellets by 1
     * @param animal animal to feed
     */
    public void feedPellets(Animal animal) {
        pellets--;
        animal.increaseHealth(10);
    }

    /**
     * Loops through all of a player's animals and decreases their health by a random number between 10 and 30.
     * If any animal dies, they are added to the list of animals that died during that round
     */
    public void loseHealth() {
        Random rand = new Random();
        lastRoundsDeadAnimals.clear();

        for (ArrayList<Animal> l : animalList) {
            for (int i = 0; i < l.size(); i++) {
                if (l.get(i).decreaseHealth(rand.nextInt(21) + 10)) {
                    lastRoundsDeadAnimals.add(l.remove(i));
                    i--;
                }
            }
        }
    }

    /**
     * Loops through all lists of animals for a player to determine if they have any live animals
     * @return True if there are any live animals, False otherwise
     */
    public boolean hasLiveAnimals() {
        for (ArrayList<Animal> l : animalList) {
            if (!l.isEmpty()) {
                return true;
            }
        }

        return false;
    }

    /**
     * Determines if a player has food of any kind
     * @return True if player has any kind of food, False otherwise
     */
    public boolean hasFood() {
        return hay != 0 || soy != 0 || pellets != 0;
    }

    /**
     * Removes all animals from their animal list and adds their calculated value to the "money" field
     */
    public void calculateFinalScore() {
        for (ArrayList<Animal> l : animalList) {
            while (!l.isEmpty()) {
                money += (l.get(0).getPrice() * ((double) l.get(0).getHealth() / 100));
                l.remove(0);
            }
        }
    }
}
