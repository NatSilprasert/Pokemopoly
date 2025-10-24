package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Wartortle extends PokemonCard implements Evolvable {
    public Wartortle(String id, String name, String description, int hp, int power, int price) {
        super("P008","Wartortle",
                "Wartortle is a Water type Pokémon introduced in Generation 1.",
                12,
                10,
                6);
    }

    @Override
    public PokemonCard evolve() {
        return new Blastoise("P009","Blastoise",
                "Blastoise is a Water type Pokémon introduced in Generation 1.",
                15,
                17,
                8);
    }
    //Create 10/23/68
}
