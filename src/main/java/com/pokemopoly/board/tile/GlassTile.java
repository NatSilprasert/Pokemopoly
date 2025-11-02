package com.pokemopoly.board.tile;

import com.pokemopoly.Battle;
import com.pokemopoly.Game;
import com.pokemopoly.board.GrassColor;
import com.pokemopoly.board.Tile;
import com.pokemopoly.cards.DeckManager;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.player.Player;

import java.util.Scanner;

public class GlassTile extends Tile {
    private int catchRate;
    private GrassColor color;

    public GlassTile(String name, int index, GrassColor color) {
        super(name, index);
        this.color = color;
        this.catchRate = color.getCatchRate();
    }

    @Override
    public void moveIn(Player player, Game game) {
        if (!playersOnLand.isEmpty()) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("You're on the same tile with other players!");
            System.out.println("Do you want to fight? 1) Yes 2) No");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Choose you opponent.");
                for (int i = 0; i < playersOnLand.size(); i++) {
                    System.out.println(i + 1 + ". " + playersOnLand.get(i).getName());
                }

                int opponentIdx = scanner.nextInt();
                scanner.nextLine();

                Player opponent = playersOnLand.get(opponentIdx - 1);
                Battle battle = new Battle(game, player, opponent, false);
                battle.start();

                return;
            }
        }
        onLand(player, game);
        playersOnLand.add(player);
    }

    public void onLand(Player player, Game game) {
        System.out.println(player.getName() + " landed on " + name + "!");

        DeckManager deckManager = game.getDeckManager();

        PokemonCard pokemonCard = deckManager.drawGreenPokemon();
        if (catchRate == 3) pokemonCard = deckManager.drawBluePokemon();
        else if (catchRate == 4) pokemonCard = deckManager.drawPurplePokemon();
        else if (catchRate == 5) pokemonCard = deckManager.drawRedPokemon();
        else if (catchRate == 6) pokemonCard = deckManager.drawCrownPokemon();

        System.out.println("Pokemon details:");
        System.out.println("Name: " + pokemonCard.getName());
        System.out.println("Description: " + pokemonCard.getDescription());

        System.out.println("Do you want to try to catch a Pokémon? (y/n)");

        Scanner scanner = new Scanner(System.in);
        String strChoice = scanner.nextLine();

        if (strChoice.equalsIgnoreCase("y")) {
            int dice = game.rollDice();
            System.out.println("You rolled: " + dice);
            if (dice > catchRate) {
                System.out.println("🎉 You caught a new Pokémon!");
                // Add new pokemon
                if (player.getTeam().size() == player.getMaxPokemon()) {
                    System.out.println("Your team is full!");
                    System.out.println("Do you want to:");
                    System.out.println("1. Replace an existing pokemon");
                    System.out.println("2. Discard the new pokemon");

                    int choice = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    if (choice == 1) {
                        System.out.println("Your current team:");
                        for (int i = 0; i < player.getTeam().size(); i++) {
                            PokemonCard p = player.getTeam().get(i);
                            System.out.println((i + 1) + ". " + p.getName() + " - " + p.getDescription());
                        }

                        while (true) {
                            System.out.print("Select the item to replace (1-" + player.getTeam().size() + "): ");
                            int index = scanner.nextInt() - 1;

                            if (index >= 0 && index < player.getTeam().size()) {
                                PokemonCard removed = player.getTeam().remove(index);
                                System.out.println("Removed: " + removed.getName());
                                player.addPokemon(pokemonCard);
                                System.out.println("Added: " + pokemonCard.getName());
                                break;
                            } else {
                                System.out.println("Invalid selection. Please try again!");
                            }
                        }
                    }
                    else if (choice == 2) {
                        System.out.println("You discarded the new pokemon: " + pokemonCard.getName());
                    }

                } else {
                    player.addPokemon(pokemonCard);
                    System.out.println(pokemonCard.getName() + " has been added to your hand!");
                }
            } else {
                System.out.println("😢 The Pokémon ran away...");
            }
        }
    }

    public int getCatchRate() {
        return catchRate;
    }

    public GrassColor getColor() {
        return color;
    }
}
