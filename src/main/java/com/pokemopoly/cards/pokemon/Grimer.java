package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Grimer extends PokemonCard implements Evolvable {
    public Grimer() {
        super("P088",
                "Grimer",
                "Grimer is a Poison type Pokémon introduced in Generation 1.",
                7,
                7,
                4);
    }

    @Override
    public PokemonCard evolve() {
        return new Muk();
    }
}