package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;

public class Arbok extends PokemonCard implements BattleAbility {
    public Arbok() {
        super("P024",
                "Arbok",
                "Arbok is a Poison type Pokémon introduced in Generation 1.",
                12,
                7,
                5);
    }

    @Override
    public void useBattlePassive(Battle battle) {
        // Unnerve Ability: No one can use any Item cards this battle
        System.out.println("🐍 Arbok used **Unnerve**! Items cannot be used in this battle!");
        battle.disableItemsForThisBattle();
    }
    //Create 10/29/68
}
