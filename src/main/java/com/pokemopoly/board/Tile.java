package com.pokemopoly.board;

import com.pokemopoly.Game;
import com.pokemopoly.player.Player;

public abstract class Tile {
    protected String name;
    protected int index;

    public Tile(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return index + " - " + name;
    }

    public int getIndex() {
        return index;
    }

    public abstract void onLand(Player player, Game game);
}
