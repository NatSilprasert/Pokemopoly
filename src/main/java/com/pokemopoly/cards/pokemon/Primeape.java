package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;

public class Primeape extends PokemonCard implements BattleAbility {
    public Primeape() {
        super("P057",
                "Primeape",
                "Primeape is a Fighting type Pokémon introduced in Generation 1.",
                9,
                9,
                4);
    }

    @Override
    public void useBattlePassive(Battle battle) {
        // Revenge: If Primeape is attacked first → +3 power until the battle ends

        PokemonCard first = battle.getFirstAttacker();
        PokemonCard me = battle.getPokemonOf(this);

        // ถ้าคนแรกที่ตี != Primeape → แปลว่า Primeape โดนก่อน
        if (first != null && first != me) {

            System.out.println("🔥 Primeape activates Revenge! +3 Power this battle!");

            battle.addTemporaryPowerAdjustment(this, this.getPower());
            this.setPower(this.getPower() + 3);
        }
    }
}
