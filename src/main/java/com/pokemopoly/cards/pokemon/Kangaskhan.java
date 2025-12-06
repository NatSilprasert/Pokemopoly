package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;

import java.util.List;

public class Kangaskhan extends PokemonCard {
    public Kangaskhan() {
        super("P115",
                "Kangaskhan",
                "Kangaskhan is a Normal type Pokémon introduced in Generation 1.",
                14,
                10,
                7,
                List.of(PokemonType.NORMAL));
    }
}