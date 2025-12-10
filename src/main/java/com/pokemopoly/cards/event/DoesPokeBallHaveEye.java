package com.pokemopoly.cards.event;

import com.pokemopoly.Game;
import com.pokemopoly.cards.EventCard;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.player.Player;

import java.util.List;

public class DoesPokeBallHaveEye extends EventCard {
    public DoesPokeBallHaveEye() {
        super("event_does_pokeball_have_eye",
                "Does a Poké Ball have an eye?",
                "Losing 2 of their Poke Balls.");
    }

    @Override
    public void activate(Game game) {
        Player p = game.getCurrentPlayer();
        int before = p.getRedBall();

        p.setRedBall(Math.max(0, before - 2));

        System.out.println("[EVENT] Does a Poke Ball have an eye?" + p.getName() + " lost 2 Poké Balls! (" + before + " → " + p.getRedBall() + ")");
    }
}
