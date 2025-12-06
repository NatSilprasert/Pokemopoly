package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Game;
import com.pokemopoly.cards.ItemCard;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.PreRollAbility;
import com.pokemopoly.player.Hand;
import com.pokemopoly.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Farfetch_d extends PokemonCard implements PreRollAbility {


    public Farfetch_d() {
        super("P083",
                "Farfetch'd",
                "Farfetch'd is a Normal/Flying type Pokémon introduced in Generation 1.",
                5,
                8,
                4);
    }

    @Override
    public void usePreRollPassive(Game game) {
        Player user = game.getCurrentPlayer();
        List<Player> players = game.getPlayers();

        // Filter out self
        List<Player> targets = new ArrayList<>();
        for (Player p : players) {
            if (p != user) targets.add(p);
        }

        if (targets.isEmpty()) {
            System.out.println("❌ No other players to target.");
            return;
        }

        // Choose target player
        System.out.println("✂️ Farfetch'd used CUT!");
        System.out.println("Choose a player to discard 1 item from:");

        for (int i = 0; i < targets.size(); i++) {
            System.out.println((i + 1) + ". " + targets.get(i).getName());
        }

        int targetIndex = game.askPlayerToChooseIndex(1, targets.size(), "Select player") - 1;
        Player target = targets.get(targetIndex);

        Hand targetHand = target.getHand();

        if (targetHand.getItems().isEmpty()) {
            System.out.println("❌ " + target.getName() + " has no items to discard.");
            return;
        }

        // Show target items
        System.out.println("\n👜 " + target.getName() + "'s items:");
        for (int i = 0; i < targetHand.getItems().size(); i++) {
            ItemCard item = targetHand.getItems().get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - " + item.getDescription());
        }

        // Choose item to discard
        int itemIndex = game.askPlayerToChooseIndex(1, targetHand.getItems().size(),
                "Choose item to CUT") - 1;

        ItemCard removed = targetHand.getItems().remove(itemIndex);

        System.out.println("🗑️ " + removed.getName() + " has been cut from " + target.getName() + "'s hand!");

        // Send to discard pile
        game.getDeckManager().getItemDeck().discard(removed);
    }
}
