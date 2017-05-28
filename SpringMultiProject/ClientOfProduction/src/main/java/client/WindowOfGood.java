package client;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import client.config.ActiveToken;
import client.config.ServerUri;
import ru.itis.dto.GoodDto;
import ru.itis.dto.ProducerDto;

/**
 * Created by Nurami on 07.05.2017.
 */
public class WindowOfGood {
    private String uri = ServerUri.getUri()+"goods";
    private Stage primaryStage = new Stage();
    private GoodDto good;

    public void runWindow(int id, boolean editing) {

        uri += "/" + id;

        primaryStage.setTitle("Good");

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

        Label producerTitleLabel = new Label("Title of producer");
        grid.add(producerTitleLabel, 1, 3);
        TextField producerTitleField = new TextField();
        grid.add(producerTitleField, 1, 4);

        Label producerAddressLabel = new Label("Address of producer");
        grid.add(producerAddressLabel, 1, 5);
        TextField producerAddressField = new TextField();
        grid.add(producerAddressField, 1, 6);

        Button addButton= new Button("Add");
        Button backButton = new Button("Back");
        HBox hBox1 = new HBox(5);
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(addButton, backButton);
        grid.add(hBox1, 1, 9);

        addButton.setVisible(false);
        getDataFromServer();
        titleField.setEditable(false);
        producerTitleField.setEditable(false);
        producerAddressField.setEditable(false);
        titleField.setText(good.getTitle());
        producerTitleField.setText(good.getProducerDto().getTitle());
        producerAddressField.setText(good.getProducerDto().getAddress());

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                RestTemplate restTemplate = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                headers.add("Auth-Token", ActiveToken.getToken());
                HttpEntity<GoodDto> request = new HttpEntity<>(new GoodDto(titleField.getText(), new ProducerDto(producerTitleField.getText(), producerAddressField.getText(), null)), headers);
                ResponseEntity<GoodDto> response = restTemplate.exchange(uri, HttpMethod.POST, request, GoodDto.class);
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

    private void getDataFromServer(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Auth-Token", ActiveToken.getToken());
        HttpEntity request = new HttpEntity<>(null, headers);
        HttpEntity<GoodDto> response = restTemplate.exchange(uri, HttpMethod.GET, request, GoodDto.class);
        good = response.getBody();
    }


}

