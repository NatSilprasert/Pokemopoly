package com.pokemopoly.cards;

public class EventCard implements Card {
    private String id;
    private String name;
    private String description;

    public EventCard(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
