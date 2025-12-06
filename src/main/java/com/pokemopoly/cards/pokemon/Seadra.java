package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;

import java.util.List;

public class Seadra extends PokemonCard {
    public Seadra() {
        super("P117",
                "Seadra",
                "Seadra is a Water type Pokémon introduced in Generation 1.",
                7,
                8,
                4,
                List.of(PokemonType.WATER));
    }
}