package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;

import java.util.List;

public class Tentacruel extends PokemonCard {
    public Tentacruel() {
        super("P073",
                "Tentacruel",
                "Tentacruel is a Water/Poison type Pokémon introduced in Generation 1.",
                12,
                8,
                6,
                List.of(PokemonType.WATER,PokemonType.POISON));
    }
}
