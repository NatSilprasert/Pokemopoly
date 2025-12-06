package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Battle;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.BattleAbility;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;
import com.pokemopoly.player.Player;

public class Rattata extends PokemonCard implements Evolvable, BattleAbility {
    public Rattata() {
        super("P019",
                "Rattata",
                "Rattata is a Normal type Pokémon introduced in Generation 1.",
                4,
                4,
                2);
    }

    @Override
    public void useBattlePassive(Battle battle) {
        System.out.println("⚡ Quick Attack! Rattata strikes first!");

        // Determine opponent Pokémon
        PokemonCard opponentPokemon = battle.getOpponentPokemon(this);
        if (opponentPokemon == null) {
            System.out.println("No opponent found for Quick Attack.");
            return;
        }

        // Find owner player (attacker) and opponent player (defender)
        Player attacker = getOwner();
        Player defender = (attacker == battle.getPlayer()) ? battle.getOpponent(getOwner()) : battle.getPlayer();

        // Perform a quick preemptive strike
        int damage = getPower();
        System.out.println(attacker.getName() + "'s " + getName() + " dealt " + damage + " damage to "
                + defender.getName() + "'s " + opponentPokemon.getName() + " before the battle started!");

        opponentPokemon.setHp(opponentPokemon.getHp() - damage);
    }

    @Override
    public PokemonCard evolve() {
        return new Raticate();
    }
    //Create 10/29/68
}
