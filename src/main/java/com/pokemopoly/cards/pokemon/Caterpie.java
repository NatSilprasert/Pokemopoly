package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Caterpie extends PokemonCard implements Evolvable {
    public Caterpie(String id, String name, String description, int hp, int power, int price) {
        super("P010",
                "Caterpie",
                "Caterpie is a Bug type Pokémon introduced in Generation 1.",
                3,
                3,
                2);
    }

    @Override
    public PokemonCard evolve() {
        return new Metapod("P011",
                "Metapod",
                "Metapod is a Bug type Pokémon introduced in Generation 1.",
                10,
                2,
                2);
    }
    //Create 10/23/68
}
