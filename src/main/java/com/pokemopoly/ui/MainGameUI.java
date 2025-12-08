package com.pokemopoly.ui;

import com.pokemopoly.Game;
import com.pokemopoly.board.Board;
import com.pokemopoly.player.Player;
import com.pokemopoly.player.ProfessionType;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class MainGameUI {

    private final Game game;
    private final Stage stage;
    private final Scene scene;

    // ชั้น UI สำหรับ player icons
    private StackPane root;
    private Pane playerLayer = new Pane();

    // สีกรอบผู้เล่น
    private final Color[] playerColors = {
            Color.RED, Color.DODGERBLUE, Color.GOLD, Color.LIMEGREEN
    };

    // ตำแหน่ง Start บน board
    private final double startX = 615;   // ปรับทีหลัง
    private final double startY = 515;   // ปรับทีหลัง

    // เก็บ ImageView ของผู้เล่น
    private final List<ImageView> playerIcons = new ArrayList<>();

    private void startGame() {
        Player first = game.getCurrentPlayer();
        showTurnOverlay(first);
    }

    public MainGameUI(Game game, Stage stage) {
        this.game = game;
        this.stage = stage;

        /* =======================
         *  โหลดรูปกระดาน
         * ======================= */
        Image boardImage = new Image(
                getClass().getResource("/main_board.png").toExternalForm()
        );

        ImageView boardView = new ImageView(boardImage);
        boardView.setPreserveRatio(true);
        boardView.setFitWidth(800);
        boardView.setFitHeight(600);

        StackPane boardLayer = new StackPane(boardView);
        boardLayer.setAlignment(Pos.CENTER);


        /* =======================
         *  Player icons
         * ======================= */
        initPlayerIcons();


        /* =======================
         *  Overlay: Turn UI
         * ======================= */
        VBox turnOverlay = createTurnOverlay();
        turnOverlay.setVisible(false);  // แสดงเฉพาะตอนเริ่มตา


        /* =======================
         *  Stack ทุกชั้น
         * ======================= */
        root = new StackPane(boardLayer, playerLayer, turnOverlay);
        root.setAlignment(Pos.CENTER);

        this.scene = new Scene(root, 800, 600);

        if (getClass().getResource("/global.css") != null) {
            this.scene.getStylesheets().add(
                    getClass().getResource("/global.css").toExternalForm()
            );
        }

        Platform.runLater(this::startGame);
    }

    public Scene getScene() {
        return scene;
    }

    /* ===========================================================
     * 1) สร้าง icon ผู้เล่น + วางที่จุด Start
     * =========================================================== */
    private void initPlayerIcons() {
        for (int i = 0; i < game.getPlayers().size(); i++) {
            Player p = game.getPlayers().get(i);

            String iconFile = getIconForProfession(p.getProfession());
            Image img = new Image(getClass().getResource(iconFile).toExternalForm());

            ImageView iv = new ImageView(img);
            iv.setFitWidth(24);
            iv.setFitHeight(24);

            // ห่อด้วย StackPane (Region) -> ใส่ border ได้
            StackPane iconWrapper = new StackPane(iv);
            iconWrapper.setPrefSize(14, 14); // ให้มีพื้นที่ border รอบรูป

            iconWrapper.setStyle(
                    "-fx-border-color: " + toWebColor(playerColors[i]) + ";" +
                            "-fx-border-width: 2;" +
                            "-fx-border-radius: 3;" +
                            "-fx-background-radius: 3;"
            );

            // ซ้อนกันในแนวตั้ง (player 1 อยู่บนสุด)
            iconWrapper.setLayoutX(startX);
            iconWrapper.setLayoutY(startY - (i * 20)); // ซ้อนขึ้นด้านบน

            playerLayer.getChildren().add(iconWrapper);
            playerIcons.add(iv); // ถ้าต้องเก็บ wrapper ให้เปลี่ยนเป็น iconWrapper
        }
    }

    private String getIconForProfession(ProfessionType p) {
        return switch (p) {
            case TRAINER -> "/prof/trainer.png";
            case FISHER -> "/prof/fisher.png";
            case SCIENTIST -> "/prof/scientist.png";
            case ROCKET -> "/prof/rocket.png";
        };
    }

    private String toWebColor(Color c) {
        return String.format("rgba(%d,%d,%d,1)",
                (int) (c.getRed() * 255),
                (int) (c.getGreen() * 255),
                (int) (c.getBlue() * 255));
    }


    /* ===========================================================
     * 2) Overlay ตอนเริ่มเทิร์น
     * =========================================================== */
    private VBox createTurnOverlay() {

        VBox box = new VBox(20);
        box.setAlignment(Pos.CENTER);
        box.setMaxWidth(350);
        box.setMaxHeight(350);
        box.setStyle("-fx-background-color: rgba(0,0,0,0.65);");

        Text turnText = new Text("Player's Turn!");
        turnText.setFill(Color.WHITE);
        turnText.setStyle("-fx-font-size: 42px;");

        Button btnPokemon = new Button("Use Pokemon Skill");
        Button btnItem = new Button("Use Item Skill");
        Button btnSkip = new Button("Do Nothing");

        btnPokemon.setPrefWidth(220);
        btnItem.setPrefWidth(220);
        btnSkip.setPrefWidth(220);

        // เมื่อคลิกปุ่ม → เรียก logic ใน Game
        btnPokemon.setOnAction(e -> {
            // TODO: เรียกเมธอดใน Game เช่น game.usePokemonSkill(currentPlayer)
            hideTurnOverlay(box);
            startDiceRoll();
        });

        btnItem.setOnAction(e -> {
            // TODO: เรียก game.useItemSkill(...)
            hideTurnOverlay(box);
            startDiceRoll();
        });

        btnSkip.setOnAction(e -> {
            hideTurnOverlay(box);
            startDiceRoll();
        });

        box.getChildren().addAll(turnText, btnPokemon, btnItem, btnSkip);
        box.setVisible(false);

        return box;
    }


    /* ===========================================================
     * 3) แสดง overlay ตอนเริ่มตาผู้เล่น
     * =========================================================== */
    public void showTurnOverlay(Player p) {
        VBox overlay = (VBox) ((StackPane) scene.getRoot()).getChildren().get(2);

        Text txt = (Text) overlay.getChildren().get(0);
        txt.setText(p.getName() + "'s Turn!");

        // เปลี่ยนสี overlay ตามผู้เล่น
        int idx = game.getPlayers().indexOf(p);
        Color c = playerColors[idx];

        overlay.setStyle(
                "-fx-background-color: rgba("
                        + (int)(c.getRed()*255) + ","
                        + (int)(c.getGreen()*255) + ","
                        + (int)(c.getBlue()*255) + ", 0.55);"
        );

        overlay.setVisible(true);
    }

    private void hideTurnOverlay(VBox overlay) {
        overlay.setVisible(false);
    }


    /* ===========================================================
     * 4) หลังเลือก option → ทอยลูกเต๋า
     * =========================================================== */
    private void startDiceRoll() {

        final RollDiceUI[] diceUIHolder = new RollDiceUI[1];

        diceUIHolder[0] = new RollDiceUI((n) -> {

            // เอา overlay ออก
            root.getChildren().remove(diceUIHolder[0].getView());

            // Logic game
            Player currentPlayer = game.getCurrentPlayer();
            Board board = game.getBoard();

            if (!currentPlayer.isDoNothing()) {
                currentPlayer.setLastRoll(n);
                game.checkAdditionalConditions(currentPlayer, n);
                board.movePlayer(currentPlayer, n, game);
            }

            currentPlayer.setDoNothing(false);
            game.setTurn(game.getTurn() + 1);
        });

        // แสดง overlay ลูกเต๋า
        root.getChildren().add(diceUIHolder[0].getView());
        StackPane.setAlignment(diceUIHolder[0].getView(), Pos.CENTER);
    }
}