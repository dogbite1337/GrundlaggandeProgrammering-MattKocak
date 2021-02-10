package com.company;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.getNumPlayers();
        game.getPlayerNames();
        game.getNumRounds();

        while (game.numRounds() - game.getRound() >= 0) {
            game.playRound();
        }
    }
}
