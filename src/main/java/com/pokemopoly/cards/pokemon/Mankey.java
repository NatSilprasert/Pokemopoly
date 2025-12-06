package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Game;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;
import com.pokemopoly.cards.pokemon.interfaces.PreRollAbility;
import com.pokemopoly.player.Player;

import java.util.List;

public class Mankey extends PokemonCard implements Evolvable {
    public Mankey() {
        super("P056",
                "Mankey",
                "Mankey is a Fighting type Pokémon introduced in Generation 1.",
                5,
                4,
                2);
    }

    @Override
    public PokemonCard evolve() {
        return new Primeape();
    }
}
