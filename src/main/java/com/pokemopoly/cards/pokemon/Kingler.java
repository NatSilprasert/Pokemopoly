package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;

import java.util.List;

public class Kingler extends PokemonCard {
    public Kingler() {
        super("P099",
                "Kingler",
                "Kingler is a Water type Pokémon introduced in Generation 1.",
                8,
                11,
                5,
                List.of(PokemonType.WATER));
    }
}