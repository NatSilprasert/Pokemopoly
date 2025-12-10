package com.pokemopoly.cards.items;

import com.pokemopoly.Game;
import com.pokemopoly.cards.ItemCard;
import com.pokemopoly.player.Player;
import com.pokemopoly.ui.MainGameUI;

public class Repel extends ItemCard {
    public Repel() {
        super("repel", "Repel",
                "Move forward 2 tiles.");
    }

    @Override
    public void activate(Game game, MainGameUI gameUI) {
        // move 6
        gameUI.movePlayerIcon(game.getCurrentPlayer(), 2, game.getBoard());
    }

    @Override public boolean isAsync() { return true; }
}
