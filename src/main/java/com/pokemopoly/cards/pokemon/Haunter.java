package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

import java.util.List;

public class Haunter extends PokemonCard implements Evolvable {
    public Haunter() {
        super("P093",
                "Haunter",
                "Haunter is a Ghost/Poison type Pokémon introduced in Generation 1.",
                7,
                10,
                6,
                List.of(PokemonType.GHOST,PokemonType.POISON));
    }

    @Override
    public PokemonCard evolve() {
        return new Gengar();
    }
}