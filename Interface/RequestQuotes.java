package Interface;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea; // Correct import for TextArea
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequestQuotes extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Creating labels
        Label requestIdLabel = new Label("Request ID:");
        Label serviceNameLabel = new Label("Service Name:");
        Label serviceDescriptionLabel = new Label("Service Description:");
        Label phoneNumberLabel = new Label("Phone Number:");

        // Creating text fields
        TextField requestIdField = new TextField();
        TextField serviceNameField = new TextField();
        TextArea serviceDescriptionArea = new TextArea(); // Corrected to use JavaFX TextArea
        TextField phoneNumberField = new TextField();

        // Creating buttons
        Button acceptButton = new Button("Accept");
        Button denyButton = new Button("Deny");

        // Setting action for accept button
        acceptButton.setOnAction(e -> {
            String requestId = requestIdField.getText();
            String serviceName = serviceNameField.getText();
            String serviceDescription = serviceDescriptionArea.getText();
            String phoneNumber = phoneNumberField.getText();

            DatabaseConnector connector = new DatabaseConnector();
            connector.insertQuote(requestId, serviceName, serviceDescription, phoneNumber);
            connector.close();

            System.out.println("Quote accepted and saved to database");
        });

        // Setting action for deny button
        denyButton.setOnAction(e -> {
            // Implement deny functionality here
            System.out.println("Quote denied");
        });

        // Creating a grid pane to layout the elements
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Adding elements to the grid pane
        gridPane.add(requestIdLabel, 0, 0);
        gridPane.add(requestIdField, 1, 0);
        gridPane.add(serviceNameLabel, 0, 1);
        gridPane.add(serviceNameField, 1, 1);
        gridPane.add(serviceDescriptionLabel, 0, 2);
        gridPane.add(serviceDescriptionArea, 1, 2);
        gridPane.add(phoneNumberLabel, 0, 3);
        gridPane.add(phoneNumberField, 1, 3);
        gridPane.add(acceptButton, 0, 4);
        gridPane.add(denyButton, 1, 4);

        // Setting background color for the grid pane
        gridPane.setStyle("-fx-background-color: #D2B48C;"); // Light brown color

        // Creating scene and setting it to the stage
        Scene scene = new Scene(gridPane, 700, 250);
        primaryStage.setTitle("Request Quotes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class DatabaseConnector {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/SMS";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "@arun123";

    private Connection connection;

    public DatabaseConnector() {
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertQuote(String requestId, String serviceName, String serviceDescription, String phoneNumber) {
        String sql = "INSERT INTO quotes (request_id, service_name, service_description, phone_number) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, requestId);
            statement.setString(2, serviceName);
            statement.setString(3, serviceDescription);
            statement.setString(4, phoneNumber);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
