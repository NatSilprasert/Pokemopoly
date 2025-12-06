package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Staryu extends PokemonCard implements Evolvable {
    public Staryu() {
        super("P121",
                "Staryu",
                "Staryu is a Water type Pokémon introduced in Generation 1.",
                4,
                4,
                2);
    }

    @Override
    public PokemonCard evolve() {
        return new Starmie();
    }
}
