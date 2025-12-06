package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.Game;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;
import com.pokemopoly.cards.pokemon.interfaces.PreRollAbility;

public class Poliwrath extends PokemonCard implements BattleAbility {
    public Poliwrath() {
        super("P062",
                "Poliwrath",
                "Poliwrath is a Water/Fighting type Pokémon introduced in Generation 1.",
                12,
                12,
                6);
    }

    @Override
    public void useBattlePassive(Battle battle) {
        System.out.println("🥊 Poliwrath used Dynamic Punch! If you roll a 6, you attack twice!");
    }
}
