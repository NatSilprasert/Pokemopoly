package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Pidgeotto extends PokemonCard implements Evolvable {
    public Pidgeotto(String id, String name, String description, int hp, int power, int price) {
        super("P017",
                "Pidgeotto",
                "Pidgeotto is a Normal/Flying type Pokémon introduced in Generation 1.",
                12,
                6,
                4);
    }

    @Override
    public PokemonCard evolve() {
        return new Pidgeot("P018",
                "Pidgeot",
                "Pidgeot is a Normal/Flying type Pokémon introduced in Generation 1.",
                14,
                14,
                8);
    }
    //Create 10/24/2025
}
