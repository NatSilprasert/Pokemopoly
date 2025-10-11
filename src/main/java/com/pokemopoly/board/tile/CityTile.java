package com.pokemopoly.board.tile;

import com.pokemopoly.Game;
import com.pokemopoly.board.Tile;
import com.pokemopoly.player.Player;

import java.util.Scanner;

public class CityTile extends Tile {

    public CityTile(String name, int index) {
        super(name, index);
    }

    public void onLand(Player player, Game game) {
        System.out.println(player.getName() + " landed on " + name + "!");
        System.out.println("Would you like to buy items? (y/n)");

        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            // todo
            // game.getShop().openFor(player);
        }
    }
}