package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Bulbasaur extends PokemonCard implements Evolvable {

    public Bulbasaur(String id, String name, String description, int hp, int power, int price) {
        super(
                "P001",
                "bulbasaur",
                "Bulbasaur is a Grass/Poison type Pokémon introduced in Generation 1.",
                8,
                5,
                3
        );
    }

    @Override
    public PokemonCard evolve() {
        return new Ivysaur("P002",
                "Ivysaur",
                "Ivysaur is a Grass/Poison type Pokémon introduced in Generation 1.",
                12,
                8,
                6);
    }
    //Create 10/23/68
}
