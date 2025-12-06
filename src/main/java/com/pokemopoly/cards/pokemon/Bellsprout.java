package com.pokemopoly.cards.pokemon;

import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

import java.util.List;

public class Bellsprout extends PokemonCard implements Evolvable {
    public Bellsprout() {
        super("P069",
                "Bellsprout",
                "Bellsprout is a Grass/Poison type Pokémon introduced in Generation 1.",
                4,
                3,
                2,
                List.of(PokemonType.GRASS,PokemonType.POISON));
    }

    @Override
    public PokemonCard evolve() {
        return new Weepinbell();
    }
}
