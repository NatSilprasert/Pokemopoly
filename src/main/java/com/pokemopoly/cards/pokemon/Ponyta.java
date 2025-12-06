package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Ponyta extends PokemonCard implements Evolvable {
    public Ponyta() {
        super("P077",
                "Ponyta",
                "Ponyta is a Fire type Pokémon introduced in Generation 1.",
                6,
                6,
                4);
    }

    @Override
    public PokemonCard evolve() {
        return new Rapidash();
    }
}
