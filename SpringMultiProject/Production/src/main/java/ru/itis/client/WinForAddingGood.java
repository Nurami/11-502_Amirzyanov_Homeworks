package ru.itis.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.View;
import ru.itis.client.config.ActiveToken;
import ru.itis.client.config.ServerUri;
import ru.itis.dto.GoodDto;
import ru.itis.dto.ProducerDto;
import ru.itis.model.Producer;

import java.util.List;

/**
 * Created by Nurami on 10.05.2017.
 */
public class WinForAddingGood {
    private String uri = ServerUri.getUri()+"good";
    private Stage primaryStage = new Stage();
    private ObservableList<ProducerDto> producers;
    private GoodDto good;

    public void runWindow(int id) {


        primaryStage.setTitle("Good");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(5);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 300, 400);
        primaryStage.setScene(scene);

        Label titleLabel = new Label("Title");
        TextField titleField = new TextField();
        grid.add(titleLabel, 1, 1);
        grid.add(titleField, 1, 2);

        getProducers();

        Label producerLabel = new Label("Choose producer");
        ListView<ProducerDto> producersList = new ListView<>(producers);
        producersList.setPrefHeight(100);
        grid.add(producerLabel, 1, 3);
        grid.add(producersList, 1, 4);

        producersList.setCellFactory(param -> new ListCell<ProducerDto>() {
            @Override
            protected void updateItem(ProducerDto item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getTitle() == null) {
                    setText(null);
                } else {
                    setText(item.getTitle());
                }
            }
        });

        Button addButton= new Button("Add");
        Button updateButton = new Button("Update");
        Button backButton = new Button("Back");
        HBox hBox1 = new HBox(5);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(addButton, updateButton, backButton);
        grid.add(hBox1, 1, 5);



        if (id!=-1){
            uri+="/"+id;
            getDataFromServer();
            titleField.setText(good.getTitle());
            addButton.setVisible(false);
        }
        else {
            uri+="s";
            updateButton.setVisible(false);
        }

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                RestTemplate restTemplate = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                headers.add("Auth-Token", ActiveToken.getToken());
                HttpEntity<GoodDto> request = new HttpEntity<>(new GoodDto(titleField.getText(), producersList.getSelectionModel().getSelectedItem()), headers);
                ResponseEntity<GoodDto> response = restTemplate.exchange(uri, HttpMethod.POST, request, GoodDto.class);
                WindowOfGood windowOfGood = new WindowOfGood();
                windowOfGood.runWindow(response.getBody().getId(), false);
                primaryStage.close();
            }
        });

        updateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                RestTemplate restTemplate = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                headers.add("Auth-Token", ActiveToken.getToken());
                HttpEntity<GoodDto> request = new HttpEntity<GoodDto>(new GoodDto(good.getId(), titleField.getText(), producersList.getSelectionModel().getSelectedItem()), headers);
                ResponseEntity<GoodDto> response = restTemplate.exchange(uri, HttpMethod.PUT, request, GoodDto.class);
                WindowOfGood windowOfGood = new WindowOfGood();
                windowOfGood.runWindow(response.getBody().getId(), false);
                primaryStage.close();
            }
        });

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                WindowOfGoods windowOfGoods = new WindowOfGoods();
                windowOfGoods.runWindow();
                primaryStage.close();
            }
        });

        primaryStage.show();
    }

    private void getProducers(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Auth-Token", ActiveToken.getToken());
        HttpEntity request = new HttpEntity(null, headers);
        ResponseEntity<List<ProducerDto>> response = restTemplate.exchange(ServerUri.getUri()+"producers", HttpMethod.GET, request, new ParameterizedTypeReference<List<ProducerDto>>() {});
        producers = FXCollections.observableArrayList(response.getBody());
    }

    private void getDataFromServer(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Auth-Token", ActiveToken.getToken());
        HttpEntity request = new HttpEntity<>(null, headers);
        HttpEntity<GoodDto> response = restTemplate.exchange(uri, HttpMethod.GET, request, GoodDto.class);
        good = response.getBody();
    }
}
