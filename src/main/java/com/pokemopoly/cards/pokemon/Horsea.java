package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Horsea extends PokemonCard implements Evolvable {
    public Horsea() {
        super("P116",
                "Horsea",
                "Horsea is a Water type Pokémon introduced in Generation 1.",
                3,
                3,
                2);
    }

    @Override
    public PokemonCard evolve() {
        return new Seadra();
    }
}