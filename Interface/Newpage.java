package Interface;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Newpage extends Application {

    private Scene loginScene;
    private Scene loggedInScene;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Customer Login");

        // Login Scene
        GridPane loginGrid = new GridPane();
        loginGrid.setVgap(8);
        loginGrid.setHgap(10);

        Label customerUsernameLabel = new Label("Username:");
        GridPane.setConstraints(customerUsernameLabel, 0, 1);
        TextField customerUsernameInput = new TextField();
        GridPane.setConstraints(customerUsernameInput, 1, 1);

        Label customerPasswordLabel = new Label("Password:");
        GridPane.setConstraints(customerPasswordLabel, 0, 2);
        PasswordField customerPasswordInput = new PasswordField();
        GridPane.setConstraints(customerPasswordInput, 1, 2);

        Button customerLoginButton = new Button("Login");
        GridPane.setConstraints(customerLoginButton, 1, 3);

        loginGrid.getChildren().addAll(
                customerUsernameLabel, customerUsernameInput, customerPasswordLabel, customerPasswordInput, customerLoginButton
        );

        loginScene = new Scene(loginGrid, 300, 200);

        // Logged-in Scene
        GridPane loggedInGrid = new GridPane();
        loggedInGrid.setVgap(8);
        loggedInGrid.setHgap(10);

        Button registerButton = new Button("Register");
        GridPane.setConstraints(registerButton, 0, 0);

        Button manageButton = new Button("Manage");
        GridPane.setConstraints(manageButton, 1, 0);

        Button browseButton = new Button("Browse Services");
        GridPane.setConstraints(browseButton, 0, 1);

        Button requestQuoteButton = new Button("Request Quote");
        GridPane.setConstraints(requestQuoteButton, 1, 1);

        loggedInGrid.getChildren().addAll(registerButton, manageButton, browseButton, requestQuoteButton);

        loggedInScene = new Scene(loggedInGrid, 300, 200);

        // Set initial scene
        primaryStage.setScene(loginScene);

        // Login button action
        customerLoginButton.setOnAction(event -> {
            // Here you would typically perform login authentication
            // For the sake of simplicity, I'm just switching to the logged-in scene directly
            primaryStage.setScene(loggedInScene);
        });

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
