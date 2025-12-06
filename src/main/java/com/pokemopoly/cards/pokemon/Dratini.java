package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

import java.util.List;

public class Dratini extends PokemonCard implements Evolvable {
    public Dratini() {
        super("P147",
                "Dratini",
                "Dratini is a Dragon type Pokémon introduced in Generation 1.",
                5,
                5,
                5,
                List.of(PokemonType.DRAGON));
    }

    @Override
    public PokemonCard evolve() {
        return new Dragonair();
    }
}
