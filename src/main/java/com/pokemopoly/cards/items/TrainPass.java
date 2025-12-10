package com.pokemopoly.cards.items;

import com.pokemopoly.Game;
import com.pokemopoly.board.Board;
import com.pokemopoly.cards.ItemCard;
import com.pokemopoly.player.Player;
import com.pokemopoly.ui.MainGameUI;

public class TrainPass extends ItemCard {
    public TrainPass() {
        super("trainpass", "Train Pass",
                "Teleport to the nearest City tile ahead.");
    }

    @Override
    public void activate(Game game, MainGameUI gameUI) {
        Player player = game.getCurrentPlayer();
        Board board = game.getBoard();

        System.out.println("✨ " + player.getName() + " used Pokedex!");

        int currentPos = player.getPosition();
        int[] shopTiles = new int[]{5, 15, 25, 35};

        int nearestShop = shopTiles[0];
        int minDistance = (nearestShop - currentPos + 40) % 40;

        for (int shop : shopTiles) {
            int distance = (shop - currentPos + 40) % 40;
            if (distance < minDistance) {
                minDistance = distance;
                nearestShop = shop;
            }
        }

        System.out.println("Moving " + player.getName() + " to nearest shop at tile " + nearestShop);
        gameUI.movePlayerIcon(player, minDistance, board);
    }

    @Override public boolean isAsync() { return true; }
}
