package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Koffing extends PokemonCard implements Evolvable {
    public Koffing() {
        super("P109",
                "Koffing",
                "Koffing is a Poison type Pokémon introduced in Generation 1.",
                5,
                4,
                2);
    }

    @Override
    public PokemonCard evolve() {
        return new Weezing();
    }
}
