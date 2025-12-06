package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Game;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;
import com.pokemopoly.cards.pokemon.interfaces.PreRollAbility;

import java.util.List;

public class Porygon extends PokemonCard {
    public Porygon() {
        super("P137",
                "Porygon",
                "Porygon is a Normal type Pokémon introduced in Generation 1.",
                13,
                12,
                7,
                List.of(PokemonType.NORMAL));
    }
}