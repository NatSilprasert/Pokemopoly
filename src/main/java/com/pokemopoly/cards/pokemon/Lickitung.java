package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;

import java.util.List;

public class Lickitung extends PokemonCard {
    public Lickitung() {
        super("P108",
                "Lickitung",
                "Lickitung is a Normal type Pokémon introduced in Generation 1.",
                8,
                8,
                4,
                List.of(PokemonType.NORMAL));
    }
}