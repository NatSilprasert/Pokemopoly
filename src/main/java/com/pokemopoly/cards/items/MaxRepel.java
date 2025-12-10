package com.pokemopoly.cards.items;

import com.pokemopoly.Game;
import com.pokemopoly.cards.ItemCard;
import com.pokemopoly.player.Player;
import com.pokemopoly.ui.MainGameUI;

public class MaxRepel extends ItemCard {

    public MaxRepel() {
        super("maxrepel", "Max Repel",
                "Move forward 6 tiles.");
    }

    @Override
    public void activate(Game game, MainGameUI gameUI) {
        // move 6
        gameUI.movePlayerIcon(game.getCurrentPlayer(), 6, game.getBoard());
    }

    @Override public boolean isAsync() { return true; }
}