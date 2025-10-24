package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Kakuna extends PokemonCard implements Evolvable, BattleAbility {
    public Kakuna(String id, String name, String description, int hp, int power, int price) {
        super("P014",
                "Kakuna",
                "Kakuna is a Bug/Poison type Pokémon introduced in Generation 1.",
                10,
                2,
                2);
    }

    @Override
    public void useBattlePassive(Battle battle) {
        //Wait Battle Class
        //Harden
    }

    @Override
    public PokemonCard evolve() {
        return new Beedrill("P015",
                "Beedrill",
                "Beedrill is a Bug/Flying type Pokémon introduced in Generation 1.",
                11,
                10,
                6);
    }
    //Create 10/23/68
}
