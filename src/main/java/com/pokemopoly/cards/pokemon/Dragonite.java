package com.pokemopoly.cards.pokemon;


import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;

import java.util.List;


public class Dragonite extends PokemonCard {
    public Dragonite() {
        super("P149",
                "Dragonite",
                "Dragonite is a Dragon/Flying type Pokémon introduced in Generation 1.",
                14,
                18,
                9,
                List.of(PokemonType.DRAGON,PokemonType.FLYING));
    }
}