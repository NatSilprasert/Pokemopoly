package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Graveler extends PokemonCard implements Evolvable {
    public Graveler() {
        super("P075",
                "Graveler",
                "Graveler is a Rock/Ground type Pokémon introduced in Generation 1.",
                10,
                7,
                4);
    }

    @Override
    public PokemonCard evolve() {
        return new Golem();
    }
}
