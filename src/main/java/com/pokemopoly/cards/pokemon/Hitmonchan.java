package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;

import java.util.List;

public class Hitmonchan extends PokemonCard {
    public Hitmonchan() {
        super("P107",
                "Hitmonchan",
                "Hitmonchan is a Fighting type Pokémon introduced in Generation 1.",
                10,
                9,
                6,
                List.of(PokemonType.FIGHTING));
    }
}