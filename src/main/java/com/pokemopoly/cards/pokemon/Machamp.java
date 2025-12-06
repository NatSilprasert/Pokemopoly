package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Game;
import com.pokemopoly.cards.ItemCard;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.PreRollAbility;
import com.pokemopoly.player.Hand;
import com.pokemopoly.player.Player;

import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.List;

public class Machamp extends PokemonCard implements PreRollAbility {
    public Machamp() {
        super("P068",
                "Machamp",
                "Machamp is a Fighting type Pokémon introduced in Generation 1.",
                13,
                16,
                8);
    }

    @Override
    public void usePreRollPassive(Game game) {
        // ตรวจสอบว่าใช้ไปแล้วในรอบนี้หรือยัง
        if (game.isMachampCloseCombatUsed()) {
            System.out.println("❌ Machamp already used Close Combat this round!");
            return;
        }

        System.out.println("💥 Machamp uses Close Combat! All players discard their entire hand!");

        for (Player p : game.getPlayers()) {
            Hand hand = p.getHand();
            if (hand.getItems().isEmpty()) {
                System.out.println(" - " + p.getName() + " has no items to discard.");
                continue;
            }

            // ทิ้งทุกใบ
            List<ItemCard> items = new ArrayList<>(hand.getItems());
            hand.getItems().clear();

            System.out.println(" - " + p.getName() + " discarded " + items.size() + " cards!");

            // ใส่ลง discard pile ของ item deck
            for (ItemCard item : items) {
                game.getDeckManager().getItemDeck().discard(item);
            }
        }

        game.setMachampCloseCombatUsed(true);
    }
}
