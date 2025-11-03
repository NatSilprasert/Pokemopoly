package com.pokemopoly.board.tile;

import com.pokemopoly.Game;
import com.pokemopoly.board.Tile;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.Evolvable;
import com.pokemopoly.player.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DaycareTile extends Tile {
    private Map<Player, PokemonCard> hatch = new HashMap<>();

    public DaycareTile(String name, int index) {
        super(name, index);
    }

    public void onLand(Player player, Game game) {
        System.out.println(player.getName() + " landed on " + name + "!");
        List<PokemonCard> evolvablePokemons = player.getTeam().stream()
                .filter(p -> p instanceof Evolvable)
                .toList();

        if (!evolvablePokemons.isEmpty()) {
            System.out.println("Choose pokemon to evolve!");
            for (int i = 0; i < evolvablePokemons.size(); i++) {
                System.out.println((i + 1) + ". " + evolvablePokemons.get(i).getName());
            }
        }

        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= evolvablePokemons.size()) {
                    break;
                } else {
                    System.out.println("❌ Invalid number. Please select between 1 and " + evolvablePokemons.size() + "!");
                }
            } else {
                System.out.println("❌ Please enter a valid number!");
                scanner.next();
            }
        }

        PokemonCard selected = evolvablePokemons.get(choice - 1);
        System.out.println("You chose " + selected.getName() + " to evolve!");

        Evolvable evolvable = (Evolvable) selected;
        PokemonCard evolvedPokemon = evolvable.evolve();

        player.getTeam().remove(selected);
        hatch.put(player, evolvedPokemon);

        System.out.println("Come back next round to retrieve your Pokémon!");
    }

    public void walkPass(Player player, Game game) {
        if (hatch.containsKey(player)) {
            PokemonCard evolvedPokemon = hatch.get(player);

            System.out.println(player.getName() + " has an evolved Pokémon ready to pick up!");

            if (player.getTeam().size() >= player.getMaxPokemon()) {
                System.out.println("Your team is full!");
                System.out.println("Do you want to replace a Pokémon or release the new one?");
                System.out.println("1. Replace a Pokémon in your team");
                System.out.println("2. Release the evolved Pokémon");

                Scanner sc = new Scanner(System.in);
                int choice = -1;

                while (choice != 1 && choice != 2) {
                    System.out.print("Enter your choice: ");
                    try {
                        choice = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter 1 or 2.");
                    }
                }

                if (choice == 1) {
                    System.out.println("Choose a Pokémon to replace:");
                    for (int i = 0; i < player.getTeam().size(); i++) {
                        System.out.println((i + 1) + ". " + player.getTeam().get(i).getName());
                    }

                    int replaceIndex = -1;
                    while (replaceIndex < 1 || replaceIndex > player.getTeam().size()) {
                        System.out.print("Enter number of Pokémon to replace: ");
                        try {
                            replaceIndex = Integer.parseInt(sc.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                        }
                    }

                    PokemonCard removed = player.getTeam().remove(replaceIndex - 1);
                    System.out.println(removed.getName() + " was released!");
                    player.getTeam().add(evolvedPokemon);
                    System.out.println("You received " + evolvedPokemon.getName() + "!");

                }
                else {
                    System.out.println("You decided to release " + evolvedPokemon.getName() + ".");
                }

            } else {
                player.getTeam().add(evolvedPokemon);
                System.out.println("You received " + evolvedPokemon.getName() + "!");
            }

            hatch.remove(player);
        }
    }
}
