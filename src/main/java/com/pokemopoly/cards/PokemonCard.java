package com.pokemopoly.cards;

import com.pokemopoly.player.Player;

public abstract class PokemonCard implements Card {
    private final String id;
    private final String name;
    private final String description;
    private final int maxHp;
    private final int price;
    private int hp;
    private int power;
    private boolean isAlive = true;
    private Player owner;
    private boolean burned = false;


    public PokemonCard(String id, String name, String description, int hp, int power, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.hp = hp;
        this.maxHp = hp;
        this.power = power;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getPower() {
        return power;
    }

    public int getPrice() {
        return price;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public boolean isBurned() {
        return burned;
    }

    public void setBurned(boolean burned) {
        this.burned = burned;
    }

    public void setHp(int hp) {
        this.hp = Math.max(0, hp);
        if (this.hp == 0) {
            this.isAlive = false;
            System.out.println(name + " has fainted!");
        }
    } //Edit 10/23/68
}
