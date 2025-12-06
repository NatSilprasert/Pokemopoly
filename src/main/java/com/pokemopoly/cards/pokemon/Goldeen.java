package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Goldeen extends PokemonCard implements Evolvable {
    public Goldeen() {
        super("P118",
                "Goldeen",
                "Goldeen is a Water type Pokémon introduced in Generation 1.",
                4,
                5,
                2);
    }

    @Override
    public PokemonCard evolve() {
        return new Seaking();
    }
}