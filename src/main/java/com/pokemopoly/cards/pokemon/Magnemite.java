package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Magnemite extends PokemonCard implements Evolvable , BattleAbility {

    public Magnemite() {
        super("P081",
                "Magnemite",
                "Magnemite is an Electric/Steel type Pokémon introduced in Generation 1.",
                4,
                4,
                2);
    }

    @Override
    public void useBattlePassive(Battle battle) {
        //attack
    }

    @Override
    public PokemonCard evolve() {
        return new Magneton();
    }
}
