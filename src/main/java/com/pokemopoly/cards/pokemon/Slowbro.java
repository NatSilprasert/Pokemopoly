package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;

import java.util.List;

public class Slowbro extends PokemonCard {
    public Slowbro() {
        super("P080",
                "Slowbro",
                "Slowbro is a Water/Psychic type Pokémon introduced in Generation 1.",
                14,
                10 ,
                7,
                List.of(PokemonType.WATER,PokemonType.PSYCHIC));
    }
}
