package com.pokemopoly.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck<T extends Card> {
    private List<T> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public void addCard(T card) {
        cards.add(card);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public T draw() {
        if (cards.isEmpty()) {
            System.out.println("The deck is empty!");
            return null;
        }
        return cards.removeFirst();
    }

    public void discard(T card) {
        cards.add(card);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int size() {
        return cards.size();
    }

    public T peek(int index) {
        if (index < 0 || index >= cards.size()) return null;
        return cards.get(index);
    }

    public boolean remove(T card) {
        return cards.remove(card);
    }
}
