package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

import java.util.List;

public class Krabby extends PokemonCard implements Evolvable {
    public Krabby() {
        super("P098",
                "Krabby",
                "Krabby is a Water type Pokémon introduced in Generation 1.",
                5,
                3,
                2,
                List.of(PokemonType.WATER));
    }

    @Override
    public PokemonCard evolve() {
        return new Kingler();
    }
}