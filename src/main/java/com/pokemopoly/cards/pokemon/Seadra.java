package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Game;
import com.pokemopoly.cards.ItemCard;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.PreRollAbility;
import com.pokemopoly.player.Hand;
import com.pokemopoly.player.Player;

import java.util.List;
import java.util.Random;

public class Seadra extends PokemonCard implements PreRollAbility {
    public Seadra() {
        super("P117",
                "Seadra",
                "Seadra is a Water type Pokémon introduced in Generation 1.",
                7,
                8,
                4);
    }

    @Override
    public void usePreRollPassive(Game game) {
        Player user = game.getCurrentPlayer();
        List<Player> players = game.getPlayers();

        // เลือกเป้าหมายจากผู้เล่นทั้งหมด (ยกเว้นตัวเอง)
        System.out.println("Choose a player to use Bubble Beam on:");

        for (int i = 0; i < players.size(); i++) {
            if (!players.get(i).equals(user)) {
                System.out.println((i + 1) + ". " + players.get(i).getName());
            }
        }

        int targetIndex = game.askPlayerToChooseIndex(1, players.size(),
                "Select target player number") - 1;

        Player target = players.get(targetIndex);

        if (target.equals(user)) {
            System.out.println("You cannot target yourself!");
            return;
        }

        Hand targetHand = target.getHand();

        if (targetHand.getItems().isEmpty()) {
            System.out.println(target.getName() + " has no items in hand!");
            return;
        }

        System.out.println("Choose an item to destroy from " + target.getName() + ":");

        for (int i = 0; i < targetHand.getItems().size(); i++) {
            ItemCard item = targetHand.getItems().get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - " + item.getDescription());
        }

        int itemIndex = game.askPlayerToChooseIndex(
                1,
                targetHand.getItems().size(),
                "Select item to destroy"
        ) - 1;

        ItemCard removed = targetHand.getItems().remove(itemIndex);

        System.out.println("💥 Seadra used Bubble Beam!");
        System.out.println("Destroyed " + removed.getName() + " from " + target.getName());
    }
}
