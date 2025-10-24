package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Pidgey extends PokemonCard implements Evolvable {
    public Pidgey(String id, String name, String description, int hp, int power, int price) {
        super("P016",
                "Pidgey",
                "Pidgey is a Normal/Flying type Pokémon introduced in Generation 1.",
                5,
                3,
                2);
    }

    @Override
    public PokemonCard evolve() {
        return new Pidgeot("P017",
                "Pidgeotto",
                "Pidgeotto is a Normal/Flying type Pokémon introduced in Generation 1.",
                12,
                6,
                4);
    }
    //Create 10/24/2025
}
