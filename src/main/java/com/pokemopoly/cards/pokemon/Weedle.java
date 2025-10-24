package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Weedle extends PokemonCard implements Evolvable {
    public Weedle(String id, String name, String description, int hp, int power, int price) {
        super("P013",
                "Weedle",
                "Weedle is a Bug/Flying type Pokémon introduced in Generation 1.",
                3,
                3,
                2);
    }

    @Override
    public PokemonCard evolve() {
        return new Kakuna("P014",
                "Kakuna",
                "Kakuna is a Bug/Poison type Pokémon introduced in Generation 1.",
                10,
                2,
                2);
    }
    //Create 10/23/68

}
