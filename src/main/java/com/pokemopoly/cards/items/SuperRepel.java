package com.pokemopoly.cards.items;

import com.pokemopoly.Game;
import com.pokemopoly.cards.ItemCard;
import com.pokemopoly.player.Player;
import com.pokemopoly.ui.MainGameUI;

public class SuperRepel extends ItemCard {
    public SuperRepel() {
        super("superrepel", "Super Repel",
                "Move forward 4 tiles.");
    }

    @Override
    public void activate(Game game, MainGameUI gameUI) {
        // move 6
        gameUI.movePlayerIcon(game.getCurrentPlayer(), 4, game.getBoard());
    }

    @Override public boolean isAsync() { return true; }
}
