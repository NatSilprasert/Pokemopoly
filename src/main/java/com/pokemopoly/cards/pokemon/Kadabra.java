package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Game;
import com.pokemopoly.cards.DeckManager;
import com.pokemopoly.cards.ItemCard;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;
import com.pokemopoly.cards.pokemon.interfaces.PreRollAbility;
import com.pokemopoly.player.Hand;
import com.pokemopoly.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kadabra extends PokemonCard implements Evolvable , PreRollAbility {
    public Kadabra() {
        super("P063",
                "Kadabra",
                "Kadabra is a Psychic type Pokémon introduced in Generation 1.",
                8,
                12,
                6);
    }

    @Override
    public PokemonCard evolve() {
        return new Alakazam();
    }

    @Override
    public void usePreRollPassive(Game game) {
        Player player = game.getCurrentPlayer();
        DeckManager dm = game.getDeckManager();
        Scanner sc = new Scanner(System.in);

        System.out.println("🔮 Kadabra used Psychic!");

        // จั่วการ์ด 3 ใบ
        List<ItemCard> drawn = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            ItemCard card = dm.drawItem();
            drawn.add(card);
        }

        System.out.println("Kadabra reveals 3 item cards:");
        for (int i = 0; i < drawn.size(); i++) {
            System.out.println((i + 1) + ". " + drawn.get(i).getName() + " - " + drawn.get(i).getDescription());
        }

        // ให้ผู้เล่นเลือก 1 ใบขึ้นมือ
        int pick;
        while (true) {
            System.out.print("Choose 1 card to keep (1-3): ");
            pick = sc.nextInt();
            if (pick >= 1 && pick <= 3) break;
            System.out.println("❌ Invalid choice, try again.");
        }

        ItemCard chosen = drawn.get(pick - 1);

        // เช็คถ้ามือเต็ม
        if (player.getHand().isFull()) {
            System.out.println("⚠️ Your hand is full! Choose a card to replace:");
            Hand hand = player.getHand();

            for (int i = 0; i < hand.getItems().size(); i++) {
                ItemCard c = hand.getItems().get(i);
                System.out.println((i + 1) + ". " + c.getName() + " - " + c.getDescription());
            }

            int replaceIndex;
            while (true) {
                System.out.print("Select card to replace (1-" + hand.getItems().size() + "): ");
                replaceIndex = sc.nextInt() - 1;
                if (replaceIndex >= 0 && replaceIndex < hand.getItems().size()) break;
                System.out.println("❌ Invalid selection, try again.");
            }

            ItemCard removed = hand.getItems().remove(replaceIndex);
            System.out.println("🗑 Removed: " + removed.getName());
            hand.add(chosen);
            System.out.println("👍 Added: " + chosen.getName());
        } else {
            // มือไม่เต็ม เอาขึ้นมือได้เลย
            player.getHand().add(chosen);
            System.out.println("✨ " + chosen.getName() + " added to your hand!");
        }

        // การ์ดที่เหลือใส่กลับเข้ากอง
        for (ItemCard c : drawn) {
            if (c != chosen) {
                dm.getItemDeck().discard(c);
            }
        }

        System.out.println("🔁 Remaining cards returned to the deck.");
    }
}
