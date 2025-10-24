package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Charmander extends PokemonCard implements Evolvable {
    public Charmander(String id, String name, String description, int hp, int power, int price) {
        super("P004","Charmander",
                "Charmander is a Fire type Pokémon introduced in Generation 1.",
                6,
                7,
                3);
    }

    @Override
    public PokemonCard evolve() {
        return new Charmeleon("P005","Charmeleon",
                "Charmeleon is a Fire type Pokémon introduced in Generation 1.",
                11,
                11,
                6);
    }
    //Create 10/23/68
}
