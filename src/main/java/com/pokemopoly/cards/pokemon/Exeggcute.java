package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Exeggcute extends PokemonCard implements Evolvable {
    public Exeggcute() {
        super("P102",
                "Exeggcute",
                "Exeggcute is a Grass/Psychic type Pokémon introduced in Generation 1.",
                3,
                4,
                2);
    }

    @Override
    public PokemonCard evolve() {
        return new Exeggutor();
    }
}