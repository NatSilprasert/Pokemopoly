package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;

import java.util.List;

public class Gengar extends PokemonCard {
    public Gengar() {
        super("P094",
                "Gengar",
                "Gengar is a Ghost/Poison type Pokémon introduced in Generation 1.",
                12,
                16,
                8,
                List.of(PokemonType.GHOST,PokemonType.POISON));
    }
}