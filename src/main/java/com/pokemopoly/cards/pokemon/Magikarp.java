package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Game;
import com.pokemopoly.board.Board;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;
import com.pokemopoly.cards.pokemon.interfaces.PreRollAbility;
import com.pokemopoly.player.Player;

import java.util.List;

public class Magikarp extends PokemonCard implements Evolvable , PreRollAbility {
    public Magikarp() {
        super("P129",
                "Magikarp",
                "Magikarp is a Water type Pokémon introduced in Generation 1.",
                3,
                1,
                1,
                List.of(PokemonType.WATER));
    }

    @Override
    public PokemonCard evolve() {
        return new Gyarados();
    }

    @Override
    public void usePreRollPassive(Game game) {
        Player owner = getOwner();
        if (owner == null) {
            System.out.println("⚠️ Magikarp has no owner. Ability cannot be used.");
            return;
        }

        System.out.println("💦 " + owner.getName() + "'s Magikarp used Splash!");
        System.out.println(owner.getName() + " moves forward 1 space!");

        Board board = game.getBoard();

        // Move player on board
        board.movePlayer(owner, 1, game);

        // Update position on Player
        owner.move(1);
    }
}