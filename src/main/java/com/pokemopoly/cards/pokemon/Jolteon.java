package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;

import java.util.List;

public class Jolteon extends PokemonCard {
    public Jolteon() {
        super("P135",
                "Jolteon",
                "Jolteon is an Electric type Pokémon introduced in Generation 1.",
                11,
                11,
                6,
                List.of(PokemonType.ELECTRIC));
    }
}