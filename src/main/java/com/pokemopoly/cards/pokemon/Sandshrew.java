package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Sandshrew extends PokemonCard implements Evolvable {
    public Sandshrew() {
        super("P027",
                "Sandshrew",
                "Sandshrew is a Ground type Pokémon introduced in Generation 1.",
                5,
                4,
                2);
    }

    @Override
    public PokemonCard evolve() {
        return new Sandslash();
    }
    //Create 10/29/68
}
