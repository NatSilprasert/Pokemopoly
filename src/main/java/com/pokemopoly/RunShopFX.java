package com.pokemopoly;

import com.pokemopoly.player.Player;
import com.pokemopoly.player.ProfessionType;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RunShopFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 1. สร้างข้อมูล Player จำลองเพื่อทดสอบ
        // เลือกอาชีพ TRAINER และเติมเงินให้ 20 เหรียญเพื่อลองซื้อของ
        Player testPlayer = new Player("Ash Ketchum", ProfessionType.TRAINER);
        testPlayer.setCoin(20);

        // 2. สร้างหน้า Shop และส่ง Player เข้าไป
        Shop shopUI = new Shop(testPlayer);

        // 3. สร้าง Scene โดยนำ shopUI ไปใส่
        Scene scene = new Scene(shopUI);

        // 4. ตั้งค่า Stage (หน้าต่างโปรแกรม)
        primaryStage.setTitle("Pokemopoly Shop");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false); // ล็อกขนาดหน้าจอถ้าต้องการ
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}