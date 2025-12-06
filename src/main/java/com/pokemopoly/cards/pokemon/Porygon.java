package com.pokemopoly.cards.pokemon;

import com.pokemopoly.Game;
import com.pokemopoly.cards.PokemonCard;
import com.pokemopoly.cards.pokemon.interfaces.PreRollAbility;

public class Porygon extends PokemonCard implements PreRollAbility {
    public Porygon() {
        super("P137",
                "Porygon",
                "Porygon is a Normal type Pokémon introduced in Generation 1.",
                13,
                12,
                7);
    }

    @Override
    public void usePreRollPassive(Game game) {
        System.out.println("🔵 Porygon activates Download! Dice manipulation enabled this turn.");

        // เปิดสถานะให้โกงลูกเต๋าได้ในการทอยครั้งนี้
        getOwner().setCanManipulateDice(true);
    }
}
