package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.getNumPlayers();
        game.getPlayerNames();
        game.getNumRounds();

        while (game.numRounds() > 0) {
            game.playRound();
        }
    }
}
