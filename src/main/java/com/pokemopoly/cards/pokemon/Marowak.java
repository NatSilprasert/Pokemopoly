package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;

import java.util.List;

public class Marowak extends PokemonCard {
    public Marowak() {
        super("P105",
                "Marowak",
                "Marowak is a Ground type Pokémon introduced in Generation 1.",
                8,
                10,
                5,
                List.of(PokemonType.GROUND));
    }
}