package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Gastly extends PokemonCard implements Evolvable {
    public Gastly() {
        super("P092",
                "Gastly",
                "Gastly is a Ghost/Poison type Pokémon introduced in Generation 1.",
                3,
                4,
                2);
    }

    @Override
    public PokemonCard evolve() {
        return new Haunter();
    }
}
