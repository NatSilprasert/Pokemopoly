package com.pokemopoly.cards;

import java.util.*;

public class TypeEffectiveness {

    private static final Map<PokemonType, List<PokemonType>> superEffective = new HashMap<>();
    private static final Map<PokemonType, List<PokemonType>> notEffective = new HashMap<>();

    static {
        superEffective.put(PokemonType.FIRE, Arrays.asList(PokemonType.GRASS, PokemonType.ICE, PokemonType.BUG));
        superEffective.put(PokemonType.WATER, Arrays.asList(PokemonType.FIRE, PokemonType.ROCK, PokemonType.GROUND));
        superEffective.put(PokemonType.GRASS, Arrays.asList(PokemonType.WATER, PokemonType.ROCK, PokemonType.GROUND));
        superEffective.put(PokemonType.ELECTRIC, Arrays.asList(PokemonType.WATER, PokemonType.FLYING));
        superEffective.put(PokemonType.ICE, Arrays.asList(PokemonType.GRASS, PokemonType.GROUND, PokemonType.FLYING, PokemonType.DRAGON));
        superEffective.put(PokemonType.FIGHTING, Arrays.asList(PokemonType.NORMAL, PokemonType.ROCK, PokemonType.ICE));
        superEffective.put(PokemonType.POISON, Arrays.asList(PokemonType.GRASS));
        superEffective.put(PokemonType.GROUND, Arrays.asList(PokemonType.FIRE, PokemonType.ELECTRIC, PokemonType.POISON, PokemonType.ROCK));
        superEffective.put(PokemonType.FLYING, Arrays.asList(PokemonType.GRASS, PokemonType.FIGHTING, PokemonType.BUG));
        superEffective.put(PokemonType.PSYCHIC, Arrays.asList(PokemonType.FIGHTING, PokemonType.POISON));
        superEffective.put(PokemonType.BUG, Arrays.asList(PokemonType.GRASS, PokemonType.PSYCHIC));
        superEffective.put(PokemonType.ROCK, Arrays.asList(PokemonType.FIRE, PokemonType.ICE, PokemonType.FLYING, PokemonType.BUG));
        superEffective.put(PokemonType.GHOST, Arrays.asList(PokemonType.GHOST, PokemonType.PSYCHIC));
        superEffective.put(PokemonType.DRAGON, Arrays.asList(PokemonType.DRAGON));

        notEffective.put(PokemonType.FIRE, Arrays.asList(PokemonType.WATER, PokemonType.ROCK, PokemonType.FIRE, PokemonType.DRAGON));
        notEffective.put(PokemonType.WATER, Arrays.asList(PokemonType.GRASS, PokemonType.WATER, PokemonType.DRAGON));
        notEffective.put(PokemonType.GRASS, Arrays.asList(PokemonType.FIRE, PokemonType.POISON, PokemonType.FLYING, PokemonType.BUG, PokemonType.GRASS, PokemonType.DRAGON));
        notEffective.put(PokemonType.ELECTRIC, Arrays.asList(PokemonType.GRASS, PokemonType.ELECTRIC, PokemonType.DRAGON));
        notEffective.put(PokemonType.ICE, Arrays.asList(PokemonType.FIRE, PokemonType.WATER, PokemonType.ICE));
        notEffective.put(PokemonType.FIGHTING, Arrays.asList(PokemonType.POISON, PokemonType.FLYING, PokemonType.PSYCHIC, PokemonType.BUG));
        notEffective.put(PokemonType.POISON, Arrays.asList(PokemonType.POISON, PokemonType.GROUND, PokemonType.ROCK, PokemonType.GHOST));
        notEffective.put(PokemonType.GROUND, Arrays.asList(PokemonType.GRASS, PokemonType.BUG));
        notEffective.put(PokemonType.FLYING, Arrays.asList(PokemonType.ROCK, PokemonType.ELECTRIC));
        notEffective.put(PokemonType.PSYCHIC, Arrays.asList(PokemonType.PSYCHIC));
        notEffective.put(PokemonType.BUG, Arrays.asList(PokemonType.FIRE, PokemonType.FIGHTING, PokemonType.POISON, PokemonType.FLYING, PokemonType.GHOST));
        notEffective.put(PokemonType.ROCK, Arrays.asList(PokemonType.FIGHTING, PokemonType.GROUND));
        notEffective.put(PokemonType.GHOST, Arrays.asList(PokemonType.GHOST));
    }

    public static List<PokemonType> getSuperEffective(PokemonType type) {
        return superEffective.getOrDefault(type, Collections.emptyList());
    }

    public static List<PokemonType> getNotEffective(PokemonType type) {
        return notEffective.getOrDefault(type, Collections.emptyList());
    }

}