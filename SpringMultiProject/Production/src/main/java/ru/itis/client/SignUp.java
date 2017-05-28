package ru.itis.client;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.springframework.web.client.RestTemplate;
import ru.itis.client.config.ServerUri;
import ru.itis.dto.UserDataForRegistrationDto;
import ru.itis.dto.UserDto;

/**
 * Created by Nurami on 04.05.2017.
 */
public class SignUp {
    private String uri = ServerUri.getUri()+"users";
    private Stage primaryStage = new Stage();

    public void runWindow(){

        primaryStage.setTitle("Production Client");

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

        Label loginLabel = new Label("Login");
        grid.add(loginLabel, 1, 1);
        TextField loginTextField = new TextField();
        grid.add(loginTextField, 1, 2);

        Label passwordLabel = new Label("Password");
        grid.add(passwordLabel, 1, 3);
        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 4);

        Label nameLabel = new Label("Name");
        grid.add(nameLabel, 1, 5);
        TextField nameField = new TextField();
        grid.add(nameField, 1, 6);

        Label ageLabel = new Label("Age");
        grid.add(ageLabel, 1, 7);
        TextField ageField = new TextField();
        grid.add(ageField, 1, 8);


        Button button = new Button("Sign Up");
        HBox boxButton = new HBox(10);
        boxButton.setAlignment(Pos.BOTTOM_CENTER);
        boxButton.getChildren().add(button);
        grid.add(boxButton, 1 , 9);

        Label orLaberl = new Label("or");
        HBox boxLabel = new HBox();
        boxLabel.setAlignment(Pos.CENTER);
        boxLabel.getChildren().add(orLaberl);
        grid.add(boxLabel, 1, 10);

        Button signInButton = new Button("Sing In");
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add(signInButton);
        grid.add(hBox, 1, 11);





        final Text actionTarget = new Text();
        grid.add(actionTarget, 1, 10);


        button.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {

                UserDataForRegistrationDto data = new UserDataForRegistrationDto(loginTextField.getText(), passwordField.getText(), Integer.valueOf(ageField.getText()), nameField.getText());
                RestTemplate restTemplate = new RestTemplate();
                UserDto userDto = restTemplate.postForObject(uri, data, UserDto.class);
                actionTarget.setFill(Color.FIREBRICK);
                actionTarget.setText(userDto.getId() + "-" + userDto.getName() + "-" + userDto.getAge());
                SignIn signIn = new SignIn();
                try {
                    signIn.start(new Stage());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                primaryStage.close();

            }
        });

        signInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SignIn signIn = new SignIn();
                try {
                    signIn.start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                primaryStage.close();
            }
        });
        primaryStage.show();
    }

}

