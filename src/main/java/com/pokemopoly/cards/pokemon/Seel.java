package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Seel extends PokemonCard implements Evolvable {
    public Seel() {
        super("P086",
                "Seel",
                "Seel is a Water type Pokémon introduced in Generation 1.",
                6,
                5,
                4);
    }

    @Override
    public PokemonCard evolve() {
        return new Dewgong();
    }
}
