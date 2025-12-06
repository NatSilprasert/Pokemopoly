package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;
import com.pokemopoly.player.Player;

import java.util.Random;

public class Tangela extends PokemonCard implements BattleAbility {
    public Tangela() {
        super("P114",
                "Tangela",
                "Tangela is a Grass type Pokémon introduced in Generation 1.",
                12,
                8,
                6);
    }

    @Override
    public void useBattlePassive(Battle battle) {
        // Stun Spore : Roll 5 or 6 to skip opponent's next turn
        Random rand = new Random();
        int roll = rand.nextInt(6) + 1; // 1–6

        System.out.println("Tangela uses Stun Spore! Rolled: " + roll);

        if (roll >= 5) {
            // Step 1: find opponent Pokémon
            PokemonCard opponentPokemon = battle.getOpponentPokemon(this);

            // Step 2: get opponent player
            if (opponentPokemon != null) {
                Player opponent = opponentPokemon.getOwner();
                opponent.setSkipTurn(true);

                System.out.println(opponent.getName() + " is stunned and will skip their next turn!");
            }
        } else {
            System.out.println("Stun Spore failed.");
        }
    }
}
