package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;

import java.util.List;

public class Muk extends PokemonCard {
    public Muk() {
        super("P089",
                "Muk",
                "Muk is a Poison type Pokémon introduced in Generation 1.",
                14,
                14,
                8,
                List.of(PokemonType.POISON));
    }
}