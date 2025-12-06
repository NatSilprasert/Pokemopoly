package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Game;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.PokemonType;
import com.pokemopoly.cards.pokemon.interfaces.PreRollAbility;
import com.pokemopoly.player.Player;

import java.util.List;

public class Snorlax extends PokemonCard implements PreRollAbility {
    public Snorlax() {
        super("P143",
                "Snorlax",
                "Snorlax is a Normal type Pokémon introduced in Generation 1.",
                25,
                10,
                8,
                List.of(PokemonType.NORMAL));
    }

    @Override
    public void usePreRollPassive(Game game) {
        Player player = getOwner();

        System.out.println("😴 Snorlax used REST! Skipping this turn...");

        // ข้ามเทิร์นของผู้เล่น
        player.setSkipTurn(true);

        // ฟื้นฟู HP ของโปเกม่อนทั้งหมดในทีม
        for (PokemonCard p : player.getTeam()) {
            if (p.isAlive()) {
                p.setHp(p.getMaxHp());
            }
        }

        System.out.println("✨ All your Pokémon have been fully healed!");
    }
}