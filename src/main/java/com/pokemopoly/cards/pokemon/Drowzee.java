package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

import java.util.List;

public class Drowzee extends PokemonCard implements Evolvable {
    public Drowzee() {
        super("P096",
                "Drowzee",
                "Drowzee is a Psychic type Pokémon introduced in Generation 1.",
                5,
                5,
                4,
                List.of(PokemonType.PSYCHIC));
    }

    @Override
    public PokemonCard evolve() {
        return new Hypno();
    }
}
