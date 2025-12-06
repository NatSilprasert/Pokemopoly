package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;

public class Ditto extends PokemonCard implements BattleAbility {
    private Integer originalHp = null;
    private Integer originalPower = null;
    private Integer originalMaxHp = null;
    private Integer originalMaxPower = null;

    public Ditto() {
        super("P132",
                "Ditto",
                "Ditto is a Normal type Pokémon introduced in Generation 1.",
                1,
                1,
                3);
    }

    @Override
    public void useBattlePassive(Battle battle) {
        PokemonCard opponent = battle.getOpponentPokemon(this);
        if (opponent == null) return;

        System.out.println("🔄 Ditto uses Transform!");

        // เก็บค่าพลังเดิม
        if (originalHp == null) originalHp = getHp();
        if (originalPower == null) originalPower = getPower();
        if (originalMaxHp == null) originalMaxHp = getMaxHp();
        if (originalMaxPower == null) originalMaxPower = getMaxPower();

        // Copy ค่าจากฝ่ายตรงข้าม
        setHp(opponent.getHp());
        setPower(opponent.getPower());

        try {
            // ใช้ Reflection เพื่อ set maxHp และ maxPower ให้ Ditto ด้วย
            var maxHpField = PokemonCard.class.getDeclaredField("maxHp");
            maxHpField.setAccessible(true);
            maxHpField.setInt(this, opponent.getMaxHp());

            var maxPowerField = PokemonCard.class.getDeclaredField("maxPower");
            maxPowerField.setAccessible(true);
            maxPowerField.setInt(this, opponent.getMaxPower());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("✨ Ditto transformed! Copied stats:");
        System.out.println("   HP = " + getHp() + "/" + getMaxHp());
        System.out.println("   Power = " + getPower() + "/" + getMaxPower());
    }

    // คืนค่าเดิมหลังจบการต่อสู้
    public void restoreOriginalStats() {
        if (originalHp != null) setHp(originalHp);
        if (originalPower != null) setPower(originalPower);

        try {
            if (originalMaxHp != null) {
                var f = PokemonCard.class.getDeclaredField("maxHp");
                f.setAccessible(true);
                f.setInt(this, originalMaxHp);
            }

            if (originalMaxPower != null) {
                var f2 = PokemonCard.class.getDeclaredField("maxPower");
                f2.setAccessible(true);
                f2.setInt(this, originalMaxPower);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        originalHp = null;
        originalPower = null;
        originalMaxHp = null;
        originalMaxPower = null;
    }
}
