package client;

import javafx.application.Application;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import client.config.ActiveToken;
import client.config.ServerUri;

/**
 * Created by Nurami on 06.05.2017.
 */
public class SignIn extends Application {

    private String uri = ServerUri.getUri()+"login";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String token = ActiveToken.getToken();
        if (!token.equals("-1")){
            WindowOfObjects windowOfObjects = new WindowOfObjects();
            windowOfObjects.runWindow();
            primaryStage.close();
        }
        else {


            primaryStage.setTitle("Sign In");

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

            Button button = new Button("Sign In");
            HBox boxButton = new HBox();
            boxButton.setAlignment(Pos.CENTER);
            boxButton.getChildren().add(button);
            grid.add(boxButton, 1, 5);

            Text text = new Text("or");
            HBox textBox = new HBox();
            textBox.setAlignment(Pos.CENTER);
            textBox.getChildren().add(text);
            grid.add(textBox, 1, 6);

            Button button1 = new Button("Sign Up");
            HBox boxButton1 = new HBox();
            boxButton1.setAlignment(Pos.CENTER);
            boxButton1.getChildren().add(button1);
            grid.add(boxButton1, 1, 7);

            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    RestTemplate restTemplate = new RestTemplate();
                    HttpHeaders headers = new HttpHeaders();
                    headers.add("login", loginTextField.getText());
                    headers.add("password", passwordField.getText());
                    HttpEntity request = new HttpEntity("hello world", headers);
                    HttpEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
                    ActiveToken.setToken(response.getHeaders().getFirst("Auth-Token"));
                    if (ActiveToken.getToken() != "-1") {
                        WindowOfObjects windowOfObjects = new WindowOfObjects();
                        windowOfObjects.runWindow();
                        primaryStage.close();
                    }

                }
            });

            button1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    SignUp signUp = new SignUp();
                    signUp.runWindow();
                    primaryStage.close();
                }
            });


            primaryStage.show();
        }

    }
}
