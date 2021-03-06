package ru.itis.client;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by Nurami on 07.05.2017.
 */
public class WindowOfObjects {
    private Stage primaryStage = new Stage();

    public void runWindow(){

        primaryStage.setTitle("Objects");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 300, 400);
        primaryStage.setScene(scene);

        Text sceneTitle = new Text("Hello, my friend...");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);

        Button producersButton = new Button("Producers");
        producersButton.setMinWidth(100);
        producersButton.setMinHeight(100);
        grid.add(producersButton, 1, 1);

        Button goodsButton = new Button("Goods");
        goodsButton.setMinWidth(100);
        goodsButton.setMinHeight(100);
        grid.add(goodsButton, 2, 1);

        producersButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                WindowOfProducers windowOfProducers = new WindowOfProducers();
                windowOfProducers.runWindow();
                primaryStage.close();
            }
        });

        goodsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                WindowOfGoods windowOfGoods = new WindowOfGoods();
                windowOfGoods.runWindow();
                primaryStage.close();
            }
        });

        primaryStage.show();
    }
}
