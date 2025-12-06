package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Sandshrew extends PokemonCard implements Evolvable , BattleAbility {
    public Sandshrew() {
        super("P027",
                "Sandshrew",
                "Sandshrew is a Ground type Pokémon introduced in Generation 1.",
                5,
                4,
                2);
    }

    @Override
    public void useBattlePassive(Battle battle) {
        PokemonCard enemy = battle.getOpponentPokemon(this);
        if (enemy == null) return;
        if (battle.hasClearBody(enemy)) {
            System.out.println("❌ Clear Body prevented the power reduction on " + enemy.getName());
            return; // ห้ามลด
        }

        System.out.println("🟫 Sandshrew used Sand Attack! Opponent has 20% chance to miss.");
        battle.setSandAttackActive(true);
    }

    @Override
    public PokemonCard evolve() {
        return new Sandslash();
    }
    //Create 10/29/68
}
