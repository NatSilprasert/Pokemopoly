package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;

public class Cloyster extends PokemonCard implements BattleAbility {
    public Cloyster() {
        super("P091",
                "Cloyster",
                "Cloyster is a Water/Ice type Pokémon introduced in Generation 1.",
                15,
                9,
                8);
    }

    @Override
    public void useBattlePassive(Battle battle) {
        // Icicle Crash ability is handled after normal attacks
        // so we don't put logic here
    }
}
