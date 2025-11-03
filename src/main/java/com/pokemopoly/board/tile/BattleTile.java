package com.pokemopoly.board.tile;

import com.pokemopoly.Battle;
import com.pokemopoly.Game;
import com.pokemopoly.board.Tile;
import com.pokemopoly.cards.DeckManager;
import com.pokemopoly.player.Player;
import com.pokemopoly.player.ProfessionType;

import java.util.Objects;
import java.util.Scanner;

public class BattleTile extends Tile {
    private Player boss;

    public BattleTile(String name, int index) {
        super(name, index);
        if (Objects.equals(name, "Gym 1")) {
            boss = new Player("Gym 1's Leader", ProfessionType.TRAINER);
        }
        else if (Objects.equals(name, "Gym 2")) {
            boss = new Player("Gym 2's Leader", ProfessionType.TRAINER);
        }
        else if (Objects.equals(name, "Villain")) {
            boss = new Player("Villain", ProfessionType.TRAINER);
        }
    }

    public void onLand(Player player, Game game) {
        System.out.println(player.getName() + " landed on " + name + "!");

        System.out.println("Do you want to fight? 1) Yes 2) No");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            // setup
            DeckManager deckManager = game.getDeckManager();
            boss.addPokemon(deckManager.drawPurplePokemon());

            Battle battle = new Battle(game, player, boss, true);
            battle.start();
        }

    }
}
