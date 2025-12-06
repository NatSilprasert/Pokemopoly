package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

import java.util.List;

public class Shellder extends PokemonCard implements Evolvable {
    public Shellder() {
        super("P090",
                "Shellder",
                "Shellder is a Water type Pokémon introduced in Generation 1.",
                8,
                5,
                4,
                List.of(PokemonType.WATER));
    }

    @Override
    public PokemonCard evolve() {
        return new Cloyster();
    }
}