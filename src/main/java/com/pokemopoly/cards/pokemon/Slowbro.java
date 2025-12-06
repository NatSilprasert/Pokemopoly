package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Game;
import com.pokemopoly.cards.Deck;
import com.pokemopoly.cards.DeckManager;
import com.pokemopoly.cards.ItemCard;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.PreRollAbility;
import com.pokemopoly.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Slowbro extends PokemonCard implements PreRollAbility {
    public Slowbro() {
        super("P080",
                "Slowbro",
                "Slowbro is a Water/Psychic type Pokémon introduced in Generation 1.",
                14,
                10 ,
                7);
    }

    @Override
    public void usePreRollPassive(Game game) {
        Player player = game.getCurrentPlayer();
        DeckManager deckManager = game.getDeckManager();
        Deck<ItemCard> itemDeck = deckManager.getItemDeck();

        // Peek the top 3 cards
        List<ItemCard> peekCards = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            ItemCard card = itemDeck.peek(i);
            if (card != null) peekCards.add(card);
        }

        if (peekCards.isEmpty()) {
            System.out.println("🟣 Future Sight: Not enough cards in the deck.");
            return;
        }

        // Show the cards
        System.out.println("🟣 Future Sight – Top 3 item cards:");
        for (int i = 0; i < peekCards.size(); i++) {
            System.out.println((i + 1) + ") " + peekCards.get(i).getName());
        }

        // Ask player to choose 1 card
        int choice = game.askPlayerToChooseIndex(
                1,
                peekCards.size(),
                "Choose 1 card to add to your hand:"
        );

        ItemCard chosen = peekCards.get(choice - 1);

        // Remove the chosen card from the deck
        itemDeck.remove(chosen);

        // Add chosen card to player's hand
        player.getHand().add(chosen);
        System.out.println("🟣 You added → " + chosen.getName() + " to your hand.");

        // Remaining cards stay in the same order automatically
    }
}
