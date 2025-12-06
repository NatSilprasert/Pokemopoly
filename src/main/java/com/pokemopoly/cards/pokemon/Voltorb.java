package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

import java.util.List;

public class Voltorb extends PokemonCard implements Evolvable {
    public Voltorb() {
        super("P100",
                "Voltorb",
                "Voltorb is an Electric type Pokémon introduced in Generation 1.",
                6,
                5,
                3,
                List.of(PokemonType.ELECTRIC));
    }

    @Override
    public PokemonCard evolve() {
        return new Electrode();
    }
}