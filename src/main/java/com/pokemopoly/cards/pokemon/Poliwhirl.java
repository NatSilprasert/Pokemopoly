package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

import java.util.List;

public class Poliwhirl extends PokemonCard implements Evolvable {
    public Poliwhirl() {
        super("P061",
                "Poliwhirl",
                "Poliwhirl is a Water type Pokémon introduced in Generation 1.",
                8,
                7,
                4,
                List.of(PokemonType.WATER));
    }

    @Override
    public PokemonCard evolve() {
        return new Poliwrath();
    }
}
