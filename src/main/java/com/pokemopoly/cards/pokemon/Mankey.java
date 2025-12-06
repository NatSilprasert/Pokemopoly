package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Game;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;
import com.pokemopoly.cards.pokemon.interfaces.PreRollAbility;
import com.pokemopoly.player.Player;

import java.util.List;

public class Mankey extends PokemonCard implements Evolvable , PreRollAbility {
    public Mankey() {
        super("P056",
                "Mankey",
                "Mankey is a Fighting type Pokémon introduced in Generation 1.",
                5,
                4,
                2);
    }

    @Override
    public PokemonCard evolve() {
        return new Primeape();
    }

    @Override
    public void usePreRollPassive(Game game) {
        Player attacker = game.getCurrentPlayer();

        // ผู้เล่นถัดไป = เป้าหมายความสามารถ
        List<Player> players = game.getPlayers();
        Player target = players.get((players.indexOf(attacker) + 1) % players.size());

        System.out.println("🥋 Mankey used LOW KICK on " + target.getName() + "!");

        if (target.getRedBall() > 0) {
            target.setRedBall(target.getRedBall() - 1);
            System.out.println("💥 Low Kick destroyed 1 Red Pokéball from " + target.getName() + "!");
        } else {
            System.out.println("⚠️ " + target.getName() + " has no Red Pokéballs to destroy.");
        }
    }
}
