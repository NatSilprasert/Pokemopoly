package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Geodude extends PokemonCard implements Evolvable {
    public Geodude() {
        super("P074",
                "Geodude",
                "Geodude is a Rock/Ground type Pokémon introduced in Generation 1.",
                4,
                4,
                2);
    }

    @Override
    public PokemonCard evolve() {
        return new Graveler();
    }
}
