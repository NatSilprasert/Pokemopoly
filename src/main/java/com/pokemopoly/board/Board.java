package com.pokemopoly.board;

import com.pokemopoly.Game;
import com.pokemopoly.player.Player;

import java.util.List;

public class Board {
    private final List<Tile> tiles;

    public Board(List<Tile> tiles) {
        this.tiles = tiles;
    }

    public Tile getTileAt(int index) {
        return tiles.get(index % tiles.size());
    }

    public void movePlayer(Player player, int steps, Game game) {
        int oldPos = player.getPosition();
        int newPos = (oldPos + steps) % tiles.size();
        player.setPosition(newPos);

        Tile tile = getTileAt(newPos);

        // Update tile disable status (if it should re-enable this turn)
        tile.updateDisableStatus(game.getTurn());

        if (tile.isDisabled()) {
            System.out.println("🚧 Tile " + tile.getName() + " is disabled (Earthquake)! No effect triggered.");
            return;
        }

        // If not disabled → apply onLand() logic
        tile.onLand(player, game);
    }

    public int getSize() {
        return tiles.size();
    }

    public void blockTile(int currentPosition, int enableTurn) {
        Tile tile = getTileAt(currentPosition);
        tile.disable(enableTurn);
        System.out.println("🚧 Tile " + tile.getName() + " is disabled until turn " + enableTurn);
    }
}