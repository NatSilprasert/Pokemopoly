package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Metapod extends PokemonCard implements Evolvable, BattleAbility {
    public Metapod(String id, String name, String description, int hp, int power, int price) {
        super("P011",
                "Metapod",
                "Metapod is a Bug type Pokémon introduced in Generation 1.",
                10,
                2,
                2);
    }

    @Override
    public PokemonCard evolve() {
        return new Butterfree("P012",
                "Butterfree",
                "Butterfree is a Bug/Flying type Pokémon introduced in Generation 1.",
                12,
                7,
                6);
    }

    @Override
    public void useBattlePassive(Battle battle) {
        //Waiting Battle Class
        //Harden
    }
    //Create 10/23/68
}
