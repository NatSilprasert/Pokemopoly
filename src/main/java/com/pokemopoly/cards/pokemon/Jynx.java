package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;

import java.util.List;

public class Jynx extends PokemonCard {
    public Jynx() {
        super("P124",
                "Jynx",
                "Jynx is an Ice/Psychic type Pokémon introduced in Generation 1.",
                9,
                11,
                5,
                List.of(PokemonType.ICE));
    }
}