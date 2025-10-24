package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Squirtle extends PokemonCard implements Evolvable {
    public Squirtle(String id, String name, String description, int hp, int power, int price) {
        super("P007","Squirtle",
                "Squirtle is a Water type Pokémon introduced in Generation 1.",
                7,
                6,
                3);
    }

    @Override
    public PokemonCard evolve() {
        return new Wartortle("P008","Wartortle",
                "Wartortle is a Water type Pokémon introduced in Generation 1.",
                12,
                10,
                6);
    }
    //Create 10/23/68
}
