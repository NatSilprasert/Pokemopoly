package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;

public class Gengar extends PokemonCard implements BattleAbility {
    public Gengar() {
        super("P094",
                "Gengar",
                "Gengar is a Ghost/Poison type Pokémon introduced in Generation 1.",
                12,
                16,
                8);
    }

    @Override
    public void useBattlePassive(Battle battle) {
        // Destiny Bond: register effect for later
        battle.setDestinyBond(this);
    }
}
