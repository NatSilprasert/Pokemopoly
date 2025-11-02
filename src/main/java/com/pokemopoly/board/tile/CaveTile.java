package com.pokemopoly.board.tile;

import com.pokemopoly.Game;
import com.pokemopoly.board.Tile;
import com.pokemopoly.player.Player;

public class CaveTile extends Tile {

    public CaveTile(String name, int index) {
        super(name, index);
    }

    public void onLand(Player player, Game game) {
        System.out.println(player.getName() + " landed on " + name + "!");
        System.out.println(player.getName() + " is trapped in the cave and must wait for the next turn!");
        player.setSkipTurn(true);
    }
}
