package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;

import java.util.List;

public class Seaking extends PokemonCard {
    public Seaking() {
        super("P119",
                "Seaking",
                "Seaking is a Water type Pokémon introduced in Generation 1.",
                11,
                10,
                5,
                List.of(PokemonType.WATER));
    }
}