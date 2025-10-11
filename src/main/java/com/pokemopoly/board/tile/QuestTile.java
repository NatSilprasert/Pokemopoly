package com.pokemopoly.board.tile;

import com.pokemopoly.Game;
import com.pokemopoly.board.Tile;
import com.pokemopoly.cards.QuestCard;
import com.pokemopoly.player.Player;

public class QuestTile extends Tile {

    public QuestTile(String name, int index) {
        super(name, index);
    }

    public void onLand(Player player, Game game) {
        System.out.println(player.getName() + " landed on " + name + "!");
        QuestCard questCard = game.getDeckManager().drawQuest();
        // todo
    }
}
