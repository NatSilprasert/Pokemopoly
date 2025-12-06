package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

import java.util.List;

public class Lapras extends PokemonCard {

    public Lapras() {
        super(
                "P131",
                "lapras",
                "Lapras is a Water/Ice type Pokémon introduced in Generation 1.",
                16,
                13,
                8,
                List.of(PokemonType.WATER,PokemonType.ICE));

    }
    //Create 10/13/68
}
