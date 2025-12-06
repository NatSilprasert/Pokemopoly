package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;

import java.util.List;

public class Kabutops extends PokemonCard {
    public Kabutops() {
        super("P141",
                "Kabutops",
                "Kabutops is a Rock/Water type Pokémon introduced in Generation 1.",
                15,
                12,
                7,
                List.of(PokemonType.ROCK,PokemonType.WATER));
    }
}