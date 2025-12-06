package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

import java.util.List;

public class Poliwag extends PokemonCard implements Evolvable {

    public Poliwag() {
        super("P060",
                "Poliwag",
                "Poliwag is a Water type Pokémon introduced in Generation 1.",
                4,
                3,
                2,
                List.of(PokemonType.WATER));
    }

    @Override
    public PokemonCard evolve() {
        return new Poliwhirl();
    }
}
