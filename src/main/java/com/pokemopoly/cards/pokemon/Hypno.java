package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Game;
import com.pokemopoly.cards.ItemCard;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.PreRollAbility;
import com.pokemopoly.player.Hand;
import com.pokemopoly.player.Player;

import java.util.List;

public class Hypno extends PokemonCard implements PreRollAbility {
    public Hypno() {
        super("P097",
                "Hypno",
                "Hypno is a Psychic type Pokémon introduced in Generation 1.",
                9,
                14,
                6);
    }

    @Override
    public void usePreRollPassive(Game game) {
        Player user = game.getCurrentPlayer();
        Hand userHand = user.getHand();

        if (userHand.getItems().isEmpty()) {
            System.out.println("❌ You have no items to swap. Guard Swap fails.");
            return;
        }

        // --------------------------
        // Choose target player
        // --------------------------
        List<Player> players = game.getPlayers();
        System.out.println("Choose a player to swap items with:");
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            if (!p.equals(user)) {
                System.out.println((i + 1) + ". " + p.getName());
            }
        }

        int index;
        while (true) {
            index = game.askPlayerToChooseIndex(1, players.size(), "Select player");

            if (!players.get(index - 1).equals(user)) {
                break;
            }
            System.out.println("❌ You cannot choose yourself. Choose another player.");
        }

        Player target = players.get(index - 1);
        Hand targetHand = target.getHand();

        if (targetHand.getItems().isEmpty()) {
            System.out.println("❌ " + target.getName() + " has no items. Guard Swap fails.");
            return;
        }

        // --------------------------
        // Choose user's item
        // --------------------------
        System.out.println("Choose 1 of YOUR items to give:");
        List<ItemCard> userItems = userHand.getItems();
        for (int i = 0; i < userItems.size(); i++) {
            System.out.println((i + 1) + ". " + userItems.get(i).getName());
        }

        int userChoice = game.askPlayerToChooseIndex(1, userItems.size(), "Select item");
        ItemCard userCard = userItems.get(userChoice - 1);

        // --------------------------
        // Choose target's item
        // --------------------------
        System.out.println("Choose 1 item from " + target.getName() + " to take:");
        List<ItemCard> targetItems = targetHand.getItems();
        for (int i = 0; i < targetItems.size(); i++) {
            System.out.println((i + 1) + ". " + targetItems.get(i).getName());
        }

        int targetChoice = game.askPlayerToChooseIndex(1, targetItems.size(), "Select item");
        ItemCard targetCard = targetItems.get(targetChoice - 1);

        // --------------------------
        // Perform swap
        // --------------------------
        userHand.remove(userCard);
        targetHand.remove(targetCard);

        userHand.add(targetCard);
        targetHand.add(userCard);

        System.out.println("🔄 Hypno used **Guard Swap**!");
        System.out.println("📤 " + user.getName() + " gave: " + userCard.getName());
        System.out.println("📥 " + user.getName() + " received: " + targetCard.getName());
        System.out.println("📤 " + target.getName() + " gave: " + targetCard.getName());
        System.out.println("📥 " + target.getName() + " received: " + userCard.getName());
    }
}
