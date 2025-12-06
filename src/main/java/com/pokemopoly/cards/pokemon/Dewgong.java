package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;

import java.util.List;

public class Dewgong extends PokemonCard {
    public Dewgong() {
        super("P087",
                "Dewgong",
                "Dewgong is a Water/Ice type Pokémon introduced in Generation 1.",
                17,
                11,
                6,
                List.of(PokemonType.WATER,PokemonType.ICE));
    }
}