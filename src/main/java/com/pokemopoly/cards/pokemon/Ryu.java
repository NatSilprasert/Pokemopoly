package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Ryu extends PokemonCard implements Evolvable, BattleAbility {

    public Ryu() {
        super(
                id,
                name,
                description,
                hp,
                power,
                price
        );
    }

    @Override
    public PokemonCard evolve() {
        return new Ryu2();
    }

    @Override
    public void useBattlePassive(Battle battle) {
        // todo
    }
}
