package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Game;
import com.pokemopoly.cards.ItemCard;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.PreRollAbility;
import com.pokemopoly.player.Hand;
import com.pokemopoly.player.Player;

import java.util.List;

public class Hypno extends PokemonCard implements PreRollAbility {
    public Hypno() {
        super("P097",
                "Hypno",
                "Hypno is a Psychic type Pokémon introduced in Generation 1.",
                9,
                14,
                6);
    }

    @Override
    public void usePreRollPassive(Game game) {
        //Swap Guard
    }
}