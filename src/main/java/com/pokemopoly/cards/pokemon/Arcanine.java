package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;

public class Arcanine extends PokemonCard implements BattleAbility {
    public Arcanine() {
        super("P059",
                "Arcanine",
                "Arcanine is a Fire type Pokémon introduced in Generation 1.",
                14,
                15,
                8);
    }

    @Override
    public void useBattlePassive(Battle battle) {
        // Intimidate: ลดพลังโจมตีคู่ต่อสู้ -2
        PokemonCard enemy = battle.getOpponentPokemon(this);
        if (enemy == null) return;
        if (battle.hasClearBody(enemy)) {
            System.out.println("❌ Clear Body prevented the power reduction on " + enemy.getName());
            return; // ห้ามลด
        }

        // เก็บค่าพลังเดิมเพื่อคืนตอนจบแบทเทิล
        battle.addTemporaryPowerAdjustment(enemy, enemy.getPower());

        // ลดพลัง 2
        enemy.setPower(enemy.getPower() - 2);

        System.out.println("🔥 Arcanine’s Intimidate activated! "
                + enemy.getName() + " ATK -2!");
    }
}
