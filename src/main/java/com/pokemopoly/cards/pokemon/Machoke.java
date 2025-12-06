package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

import java.util.List;

public class Machoke extends PokemonCard implements Evolvable {
    public Machoke() {
        super("P067",
                "Machoke",
                "Machoke is a Fighting type Pokémon introduced in Generation 1.",
                10,
                8,
                4,
                List.of(PokemonType.FIGHTING));
    }

    @Override
    public PokemonCard evolve() {
        return new Machamp();
    }
}
