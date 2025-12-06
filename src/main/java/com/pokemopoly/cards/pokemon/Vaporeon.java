package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;

import java.util.List;

public class Vaporeon extends PokemonCard {
    public Vaporeon() {
        super("P134",
                "Vaporeon",
                "Vaporeon is a Water type Pokémon introduced in Generation 1.",
                12,
                10,
                6,
                List.of(PokemonType.WATER));
    }
}