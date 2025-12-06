package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;

import java.util.List;

public class Aerodactyl extends PokemonCard {
    public Aerodactyl() {
        super("P142",
                "Aerodactyl",
                "Aerodactyl is a Rock/Flying type Pokémon introduced in Generation 1.",
                16,
                13,
                7,
                List.of(PokemonType.ROCK,PokemonType.FLYING));
    }
}