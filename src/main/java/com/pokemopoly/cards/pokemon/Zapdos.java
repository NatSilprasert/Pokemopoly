package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;

public class Zapdos extends PokemonCard implements BattleAbility {
    public Zapdos() {
        super("P145",
                "Zapdos",
                "Zapdos is an Electric/Flying type Pokémon introduced in Generation 1.",
                19,
                19,
                10);
    }

    @Override
    public void useBattlePassive(Battle battle) {
        // Static activates when Zapdos is HIT, not on battle start.
        // So nothing needed here.
    }

    /**
     * Helper method for Battle class to trigger Static
     */
    public void tryActivateStatic(Battle battle, PokemonCard attacker) {
        int roll = battle.getGame().rollDice(); // 1–6 (≈33% if <=2)
        if (roll <= 2) {
            if (!attacker.isParalyzed()) {
                attacker.setParalyzed(true);
                System.out.println("⚡ Static! " + attacker.getName() + " is paralyzed!");
            } else {
                System.out.println("⚡ Static triggered, but " + attacker.getName() + " is already paralyzed.");
            }
        }
    }
}
