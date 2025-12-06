package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;

import java.util.List;

public class Scyther extends PokemonCard {
    public Scyther() {
        super("P123",
                "Scyther",
                "Scyther is a Bug/Flying type Pokémon introduced in Generation 1.",
                8,
                12,
                5,
                List.of(PokemonType.BUG,PokemonType.FLYING));
    }
}