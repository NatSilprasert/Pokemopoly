package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;

import java.util.List;

public class Gyarados extends PokemonCard {
    public Gyarados() {
        super("P130",
                "Gyarados",
                "Gyarados is a Water/Flying type Pokémon introduced in Generation 1.",
                12,
                15,
                6,
                List.of(PokemonType.WATER,PokemonType.FLYING));
    }
}