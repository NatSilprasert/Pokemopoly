package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Game;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;
import com.pokemopoly.cards.pokemon.interfaces.PreRollAbility;

import java.util.List;

public class Alakazam extends PokemonCard {
    public Alakazam() {
        super("P065",
                "Alakazam",
                "Alakazam is a Psychic type Pokémon introduced in Generation 1.",
                10,
                17,
                8,
                List.of(PokemonType.PSYCHIC)
        );
    }

}
