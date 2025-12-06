package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Slowpoke extends PokemonCard implements Evolvable {
    public Slowpoke() {
        super("P079",
                "Slowpoke",
                "Slowpoke is a Water/Psychic type Pokémon introduced in Generation 1.",
                9, 6 ,4);
    }

    @Override
    public PokemonCard evolve() {
        return new Slowbro();
    }
}
