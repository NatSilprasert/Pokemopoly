package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;

public class Onix extends PokemonCard implements BattleAbility {
    public Onix() {
        super("P095",
                "Onix",
                "Onix is a Rock/Ground type Pokémon introduced in Generation 1.",
                12,
                14,
                8);
    }

    @Override
    public void useBattlePassive(Battle battle) {
        // Sturdy activates only if Onix starts battle at full HP
        if (this.getHp() == this.getMaxHp()) {
            sturdyActive = true;
            battle.registerSturdy(this);
            System.out.println("🛡️ Onix's Sturdy is active! It will survive the first fatal hit.");
        }
    }
}
