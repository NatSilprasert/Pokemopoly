package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;

public class Kabuto extends PokemonCard implements Evolvable {
    public Kabuto() {
        super("P140",
                "Kabuto",
                "Kabuto is a Rock/Water type Pokémon introduced in Generation 1.",
                10,
                5,
                4);
    }

    @Override
    public PokemonCard evolve() {
        return new Kabutops();
    }
}