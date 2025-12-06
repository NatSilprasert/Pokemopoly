package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;

import java.util.List;

public class Victreebel extends PokemonCard implements BattleAbility {

    public Victreebel() {
        super("P071",
                "Victreebel",
                "Victreebel is a Grass/Poison type Pokémon introduced in Generation 1.",
                14,
                10,
                7,
                List.of(PokemonType.GRASS,PokemonType.POISON));
    }

    @Override
    public void useBattlePassive(Battle battle) {
        //Leech life
        //Add +2 all turn
    }
}
