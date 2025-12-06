package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Rhyhorn extends PokemonCard implements Evolvable {
    public Rhyhorn() {
        super("P111",
                "Rhyhorn",
                "Rhyhorn is a Ground/Rock type Pokémon introduced in Generation 1.",
                12,
                5,
                4);
    }

    @Override
    public PokemonCard evolve() {
        return new Rhydon();
    }
}
