package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;

import java.util.List;

public class Golem extends PokemonCard {
    public Golem() {
        super("P076",
                "Golem",
                "Golem is a Rock/Ground type Pokémon introduced in Generation 1.",
                17,
                10,
                6,
                List.of(PokemonType.ROCK,PokemonType.GROUND));
    }
}
