package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;

import java.util.List;

public class Electabuzz extends PokemonCard {
    public Electabuzz() {
        super("P125",
                "Electabuzz",
                "Electabuzz is an Electric type Pokémon introduced in Generation 1.",
                12,
                11,
                7,
                List.of(PokemonType.ELECTRIC));
    }
}