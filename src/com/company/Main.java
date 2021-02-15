package com.company;

import com.company.helper.GeneralGameHelper;

public class Main {

    public static void main(String[] args) {
        do {
            GeneralGameHelper.clear();
            Game game = new Game();
            game.getNumPlayers();
            game.getPlayerNames();
            game.getNumRounds();

            while (game.numRounds() - game.getRound() >= 0) {
                game.playRound();
            }

            game.scoreGame();
        } while (Game.lastDialog().equalsIgnoreCase("Y"));
    }
}
