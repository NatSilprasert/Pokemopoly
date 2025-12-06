package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;

import java.util.List;

public class Flareon extends PokemonCard {
    public Flareon() {
        super("P136",
                "Flareon",
                "Flareon is a Fire type Pokémon introduced in Generation 1.",
                10,
                12,
                6,
                List.of(PokemonType.FIRE));
    }
}