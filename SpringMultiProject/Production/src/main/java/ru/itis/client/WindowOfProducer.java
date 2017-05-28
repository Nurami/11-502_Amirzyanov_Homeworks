package ru.itis.client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.itis.client.config.ActiveToken;
import ru.itis.client.config.ServerUri;
import ru.itis.dto.ProducerDto;
import ru.itis.model.Good;
import ru.itis.model.Producer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nurami on 07.05.2017.
 */
public class WindowOfProducer {
    private String uri = ServerUri.getUri()+"producers";
    private Stage primaryStage = new Stage();
    private ProducerDto producer;

    public void runWindow(int id, boolean editing) {


        primaryStage.setTitle("Production Client");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(5);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 300, 400);
        primaryStage.setScene(scene);

        Label titleLabel = new Label("Title");
        grid.add(titleLabel, 1, 1);
        TextField titleField = new TextField();
        grid.add(titleField, 1, 2);

        Label addressLabel = new Label("Address");
        grid.add(addressLabel, 1, 3);
        TextField addressField = new TextField();
        grid.add(addressField, 1, 4);

        Label goodsList = new Label("Goods");
        grid.add(goodsList, 1, 5);
        ListView<String> list = new ListView<>();
        list.setPrefHeight(100);
        grid.add(list, 1, 6);


        Button addButton = new Button("Add");
        Button updateButton = new Button("Update");
        Button backButton = new Button("Back");
        HBox hBox1 = new HBox(5);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(addButton, updateButton, backButton);
        grid.add(hBox1, 1, 9);

        if (id!=-1) {
            uri += "/" + id;
            getDataFromServer();
            titleField.setText(producer.getTitle());
            addressField.setText(producer.getAddress());
            String[] mas = new String [producer.getGoods().size()];
            for (int i=0; i<producer.getGoods().size(); i++){
                mas[i] = producer.getGoods().get(i).getTitle();
            }
            ObservableList<String> data = FXCollections.observableArrayList(mas);
            list.setItems(data);
        }

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                WindowOfProducers windowOfProducers = new WindowOfProducers();
                windowOfProducers.runWindow();
                primaryStage.close();
            }
        });

        updateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                RestTemplate restTemplate = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                headers.add("Auth-Token", ActiveToken.getToken());
                HttpEntity<ProducerDto> request = new HttpEntity<ProducerDto>(new ProducerDto(producer.getId(), titleField.getText(), addressField.getText(), producer.getGoods()), headers);
                ResponseEntity<ProducerDto> response = restTemplate.exchange(uri, HttpMethod.PUT, request, ProducerDto.class);
                WindowOfProducer windowOfProducer = new WindowOfProducer();
                windowOfProducer.runWindow(response.getBody().getId(), false);
                primaryStage.close();

            }
        });

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                RestTemplate restTemplate = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                headers.add("Auth-Token", ActiveToken.getToken());
                HttpEntity<ProducerDto> request = new HttpEntity<ProducerDto>(new ProducerDto(titleField.getText(), addressField.getText(), new ArrayList<Good>()), headers);
                ResponseEntity<ProducerDto> response = restTemplate.exchange(uri, HttpMethod.POST, request, ProducerDto.class);
                WindowOfProducers windowOfProducers = new WindowOfProducers();
                windowOfProducers.runWindow();
                primaryStage.close();
            }
        });


        if(!editing){
            titleField.setEditable(false);
            addressField.setEditable(false);
            updateButton.setVisible(false);
            addButton.setVisible(false);
        }
        else {
            if (id==-1){
                updateButton.setVisible(false);
            }
            else {
                addButton.setVisible(false);
            }
            goodsList.setVisible(false);
            list.setVisible(false);
        }


        primaryStage.show();
    }
    private void getDataFromServer(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Auth-Token", ActiveToken.getToken());
        HttpEntity request = new HttpEntity<>(null, headers);
        HttpEntity<ProducerDto> response = restTemplate.exchange(uri, HttpMethod.GET, request, ProducerDto.class);
        producer = response.getBody();
    }

    private List<Good> divideString(String string){
        String[] mas = string.split(", ");
        List<Good> goods = new ArrayList<>();
        for (int i=0;i<mas.length; i++){
            if (producer!=null) {
                goods.add(new Good(mas[i], new Producer(producer.getId())));
            }
            else {
                goods.add(new Good(mas[i], new Producer()));

            }
        }
        return goods;
    }
}
