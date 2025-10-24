package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Charmeleon extends PokemonCard implements Evolvable {
    public Charmeleon(String id, String name, String description, int hp, int power, int price) {
        super("P005","Charmeleon",
                "Charmeleon is a Fire type Pokémon introduced in Generation 1.",
                11,
                11,
                6);
    }

    @Override
    public PokemonCard evolve() {
        return new Charizard("P006","Charizard",
                "Charizard is a Fire/Flying type Pokémon introduced in Generation 1.",
                14,
                18,
                8);
    }
    //Create 10/23/68
}
