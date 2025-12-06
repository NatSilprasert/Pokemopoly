package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;
import com.pokemopoly.player.Player;

import java.util.List;
import java.util.Random;

public class Tangela extends PokemonCard {
    public Tangela() {
        super("P114",
                "Tangela",
                "Tangela is a Grass type Pokémon introduced in Generation 1.",
                12,
                8,
                6,
                List.of(PokemonType.GRASS));
    }
}