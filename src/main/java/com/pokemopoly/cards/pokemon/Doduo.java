package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

import java.util.List;

public class Doduo extends PokemonCard implements Evolvable {
    public Doduo() {
        super("P084",
                "Doduo",
                "Doduo is a Normal/Flying type Pokémon introduced in Generation 1.",
                4,
                4,
                2,
                List.of(PokemonType.NORMAL,PokemonType.FLYING));
    }

    @Override
    public PokemonCard evolve() {
        return new Dodrio();
    }
}
