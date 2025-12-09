package com.pokemopoly.ui;

import com.pokemopoly.Game;
import com.pokemopoly.cards.*;
import com.pokemopoly.cards.event.*;
import com.pokemopoly.cards.items.*;
import com.pokemopoly.cards.pokemon.*;
import com.pokemopoly.ui.cards.PokemonCardUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.List;

public class RunCardPreview extends Application {

    @Override
    public void start(Stage stage) {

        Game game = new Game();
        PokemonCard card = new Pikachu();

        // Mock DeckManager (สร้าง DeckManager ว่าง ๆ เพื่อใช้ทดสอบ)
        DeckManager deckManager = game.getDeckManager();

        // Create the card UI
        PokemonCardUI view = new PokemonCardUI(card);

        // Wrap in container
        StackPane root = new StackPane(view);

        Scene scene = new Scene(root, 320, 540);
        stage.setScene(scene);
        stage.setTitle("Pokemon Card Preview");
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }

}