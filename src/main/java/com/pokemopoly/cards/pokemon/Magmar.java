package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;

public class Magmar extends PokemonCard implements BattleAbility {
    public Magmar() {
        super("P126",
                "Magmar",
                "Magmar is a Fire type Pokémon introduced in Generation 1.",
                12,
                12,
                7);
    }

    @Override
    public void useBattlePassive(Battle battle) {
        System.out.println("🔥 Magmar's Flame Body is activated!");

        PokemonCard opponent = battle.getOpponentPokemon(this);
        if (opponent == null) return;

        // 🎲 ใช้ rollDice() จาก Game
        int roll = battle.getGame().rollDice();
        System.out.println("🎲 Flame Body roll: " + roll);

        // ถ้าได้เลขคู่ (2,4,6) → Burn
        if (roll % 2 == 0) {
            if (!opponent.isBurned()) {
                opponent.setBurned(true);
                System.out.println("🔥 Flame Body: " + opponent.getName() + " is burned!");
            } else {
                System.out.println(opponent.getName() + " is already burned.");
            }
        } else {
            System.out.println("❌ Flame Body did not burn the opponent.");
        }
    }
}
