package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Game;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.PreRollAbility;
import com.pokemopoly.player.Player;

public class Rhydon extends PokemonCard implements PreRollAbility {
    public Rhydon() {
        super("P112",
                "Rhyhorn",
                "Rhyhorn is a Ground/Rock type Pokémon introduced in Generation 1.",
                14,
                14,
                8);
    }

    @Override
    public void usePreRollPassive(Game game) {
        Player p = game.getCurrentPlayer();

        int currentPosition = p.getPosition();
        int enableTurn = game.getTurn() + game.getPlayers().size();

        game.getBoard().blockTile(currentPosition, enableTurn);

        System.out.println("🌋 Rhydon used Earthquake! Tile disabled for 1 full round.");
    }
}
