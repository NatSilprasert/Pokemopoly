package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;

import java.util.List;

public class Tauros extends PokemonCard {
    public Tauros() {
        super("P128",
                "Tauros",
                "Tauros is a Normal type Pokémon introduced in Generation 1.",
                10,
                8,
                5,
                List.of(PokemonType.NORMAL));
    }
}