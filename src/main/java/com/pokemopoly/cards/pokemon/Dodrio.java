package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Game;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.PreRollAbility;
import com.pokemopoly.player.Player;

public class Dodrio extends PokemonCard implements PreRollAbility {
    public Dodrio() {
        super("P085",
                "Dodrio",
                "Dodrio is a Normal/Flying type Pokémon introduced in Generation 1.",
                10,
                11,
                6);
    }

    @Override
    public void usePreRollPassive(Game game) {
        Player user = game.getCurrentPlayer();

        // เช็คว่าถ้าใช้ไปแล้วในรอบนี้
        if (game.isDodrioAgilityUsed()) {
            System.out.println("⚠️ Dodrio's Agility has already been used this round!");
            return;
        }

        // หา player ที่อยู่ด้านหน้ามากที่สุด
        Player leader = null;
        int maxPosition = -1;

        for (Player p : game.getPlayers()) {
            if (p.getPosition() > maxPosition) {
                maxPosition = p.getPosition();
                leader = p;
            }
        }

        // หากเราเป็นผู้นำเอง
        if (leader == user) {
            System.out.println("⚠️ Dodrio cannot use Agility because you are already the leading player!");
            return;
        }

        // คำนวณตำแหน่งใหม่ (1 ช่องถัดไปจากคนที่นำ)
        int targetPos = (leader.getPosition() + 1) % 40;

        System.out.println("⚡ Dodrio used Agility! Moving from " +
                user.getPosition() + " → " + targetPos);

        // ย้าย player
        user.setPosition(targetPos);

        // Trigger tile event
        game.getBoard().getTileAt(targetPos).onLand(user, game);

        // Mark ability as used
        game.setDodrioAgilityUsed(true);
    }
}
