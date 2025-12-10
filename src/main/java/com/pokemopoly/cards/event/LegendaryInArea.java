package com.pokemopoly.cards.event;

import com.pokemopoly.Game;
import com.pokemopoly.cards.EventCard;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.Mew;
import com.pokemopoly.cards.pokemon.Mewtwo;
import com.pokemopoly.player.Player;

import java.util.*;

public class LegendaryInArea extends EventCard {
    public LegendaryInArea() {
        super("event_legendary", "Legendary in Area",
                "Everyone rolls 2 dice. Highest roll will get a chance to catch MEWTWO!");
    }

    @Override
    public void activate(Game game) {
        Player p = game.getCurrentPlayer();

        PokemonCard mewtwo = new Mewtwo(); // ต้องมี class MewTwo
        p.addPokemon(mewtwo);

        System.out.println("[EVENT] Legendary in Area" + p.getName() + " obtained MewTwo! ⭐ Legendary Pokémon!");
    }
}
