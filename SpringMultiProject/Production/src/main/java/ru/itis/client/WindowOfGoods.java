package ru.itis.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.itis.client.config.ActiveToken;
import ru.itis.client.config.ServerUri;
import ru.itis.dto.GoodDto;
import ru.itis.dto.ProducerDto;
import ru.itis.model.Good;
import ru.itis.model.Producer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nurami on 07.05.2017.
 */
public class WindowOfGoods {
    private String uri = ServerUri.getUri()+"goods";
    private Stage primaryStage = new Stage();
    private ObservableList<GoodDto> data;

    public void runWindow() {

        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Goods");
        primaryStage.setWidth(300);
        primaryStage.setHeight(500);


        getDataFromServer();

        Label label = new Label("Goods");
        label.setFont(new Font("Arial", 20));

        TableView<GoodDto> table = new TableView();
        table.setMaxHeight(380);

        table.setEditable(true);

        TableColumn firstColumn = new TableColumn("Goods");
        firstColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        table.getColumns().add(firstColumn);
        table.setItems(data);

        Button addButton = new Button("New");
        Button buttonShow = new Button("Show");
        Button editButton = new Button("Edit");
        Button deleteButton = new Button("Delete");
        Button backButton = new Button("Back");
        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(addButton, buttonShow, editButton, deleteButton, backButton);

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                WinForAddingGood winForAddingGood = new WinForAddingGood();
                winForAddingGood.runWindow(-1);
                primaryStage.close();
            }
        });

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                WindowOfObjects windowOfObjects = new WindowOfObjects();
                windowOfObjects.runWindow();
                primaryStage.close();
            }
        });

        buttonShow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                WindowOfGood windowOfGood = new WindowOfGood();
                windowOfGood.runWindow(table.getSelectionModel().getSelectedItem().getId(), false);
                primaryStage.close();
            }
        });

        editButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                WinForAddingGood winForAddingGood = new WinForAddingGood();
                winForAddingGood.runWindow(table.getSelectionModel().getSelectedItem().getId());
                primaryStage.close();
            }
        });

        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                RestTemplate restTemplate = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                headers.add("Auth-Token", ActiveToken.getToken());
                HttpEntity request = new HttpEntity(null, headers);
                restTemplate.exchange(ServerUri.getUri()+"/goods/"+table.getSelectionModel().getSelectedItem().getId(), HttpMethod.DELETE, request, Object.class);
                WindowOfGoods windowOfGoods = new WindowOfGoods();
                windowOfGoods.runWindow();
                primaryStage.close();

            }
        });

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hBox);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void getDataFromServer(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Auth-Token", ActiveToken.getToken());
        HttpEntity request = new HttpEntity(null, headers);
        ResponseEntity<List<GoodDto>> response = restTemplate.exchange(uri, HttpMethod.GET, request, new ParameterizedTypeReference<List<GoodDto>>() {});
        data = FXCollections.observableArrayList(response.getBody());
    }
}
