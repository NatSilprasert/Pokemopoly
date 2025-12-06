package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;

public class Articuno extends PokemonCard implements BattleAbility {
    public Articuno() {
        super("P144",
                "Articuno",
                "Articuno is an Ice/Flying type Pokémon introduced in Generation 1.",
                18,
                20,
                10);
    }

    @Override
    public void useBattlePassive(Battle battle) {
        System.out.println("❄️ Articuno's Snow Cloak activated! (20% dodge chance)");
    }
}
