package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

import java.util.List;

public class Graveler extends PokemonCard implements Evolvable {
    public Graveler() {
        super("P075",
                "Graveler",
                "Graveler is a Rock/Ground type Pokémon introduced in Generation 1.",
                10,
                7,
                4,
                List.of(PokemonType.ROCK,PokemonType.GROUND));
    }

    @Override
    public PokemonCard evolve() {
        return new Golem();
    }
}
