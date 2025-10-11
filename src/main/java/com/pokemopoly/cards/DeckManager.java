package com.pokemopoly.cards;


public class DeckManager {
    private Deck<ItemCard> itemDeck;
    private Deck<EventCard> eventDeck;
    private Deck<QuestCard> questDeck;
    private Deck<PokemonCard> pokemonDeck;

    public DeckManager(Deck<ItemCard> itemDeck, Deck<EventCard> eventDeck, Deck<QuestCard> questDeck, Deck<PokemonCard> pokemonDeck) {
        this.itemDeck = itemDeck;
        this.eventDeck = eventDeck;
        this.questDeck = questDeck;
        this.pokemonDeck = pokemonDeck;
    }

    public ItemCard drawItem() {
        return itemDeck.draw();
    }

    public EventCard drawEvent() {
        return eventDeck.draw();
    }

    public QuestCard drawQuest() {
        return questDeck.draw();
    }

    public PokemonCard drawPokemon() {
        return pokemonDeck.draw();
    }

    public Deck<ItemCard> getItemDeck() {
        return itemDeck;
    }

    public Deck<EventCard> getEventDeck() {
        return eventDeck;
    }

    public Deck<QuestCard> getQuestDeck() {
        return questDeck;
    }

    public Deck<PokemonCard> getPokemonDeck() {
        return pokemonDeck;
    }

    public void shuffleAll() {
        itemDeck.shuffle();
        eventDeck.shuffle();
        questDeck.shuffle();
        pokemonDeck.shuffle();
    }
}
