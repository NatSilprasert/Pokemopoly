package com.pokemopoly.board.tile;

import com.pokemopoly.Battle;
import com.pokemopoly.Game;
import com.pokemopoly.board.Tile;
import com.pokemopoly.cards.DeckManager;
import com.pokemopoly.player.Player;
import com.pokemopoly.player.ProfessionType;

import java.util.Objects;

public class GymTile extends Tile {
    private Player gymLeader;

    public GymTile(String name, int index) {
        super(name, index);
        if (Objects.equals(name, "Gym 1")) {
            gymLeader = new Player("Gym 1's Leader", ProfessionType.TRAINER);
        }
        else if (Objects.equals(name, "Gym 2")) {
            gymLeader = new Player("Gym 2's Leader", ProfessionType.TRAINER);
        }
    }

    public void onLand(Player player, Game game) {
        System.out.println(player.getName() + " landed on " + name + "!");

        // setup
        DeckManager deckManager = game.getDeckManager();
        gymLeader.addPokemon(deckManager.drawPurplePokemon());

        Battle battle = new Battle(game, player, gymLeader, true);
    }
}
