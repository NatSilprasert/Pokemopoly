package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;

public class Weezing extends PokemonCard implements BattleAbility {
    public Weezing() {
        super("P110",
                "Weezing",
                "Weezing is a Poison type Pokémon introduced in Generation 1.",
                10,
                10,
                5);
    }

    @Override
    public void useBattlePassive(Battle battle) {
        //Levitate
        //Ground Type nooooooooooooooooo
    }
}
