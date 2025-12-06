package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;

public class Tentacruel extends PokemonCard implements BattleAbility {
    public Tentacruel() {
        super("P073",
                "Tentacruel",
                "Tentacruel is a Water/Poison type Pokémon introduced in Generation 1.",
                12,
                8,
                6);
    }

    @Override
    public void useBattlePassive(Battle battle) {
        System.out.println("✨ Clear Body activated! " + getName() + " cannot have its power reduced!");
        battle.addClearBody(this);
    }
}
