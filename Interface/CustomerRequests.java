package Interface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CustomerRequests extends Application {
    private Connection connection;

    @Override
    public void start(Stage primaryStage) {
        // Create JavaFX UI components
        Label requestTypeLabel = new Label("Request Type:");
        ComboBox<String> requestTypeComboBox = new ComboBox<>();
        requestTypeComboBox.getItems().addAll("Plumber", "Electrician", "Cleaner");

        Label descriptionLabel = new Label("Description:");
        TextArea descriptionTextArea = new TextArea();

        // Button to submit the request
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            String requestType = requestTypeComboBox.getValue();
            String description = descriptionTextArea.getText();
            if (requestType != null && !description.isEmpty()) {
                // Insert data into the database
                insertRequest(requestType, description);
            } else {
                // Show an error message if any field is empty
                // You can customize this part based on your requirements
                System.out.println("Please fill in all fields.");
            }
        });

        VBox root = new VBox(10);
        root.getChildren().addAll(requestTypeLabel, requestTypeComboBox, descriptionLabel, descriptionTextArea, submitButton);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Customer Request Form");
        primaryStage.show();

        // Connect to the database
        connect();
    }

    private void connect() {
        // JDBC URL for MySQL
        String url = "jdbc:mysql://localhost:3306/sms";
        String username = "root";
        String password = "@arun123";

        try {
            // Connect to the database
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database!");
            e.printStackTrace();
        }
    }

    private void insertRequest(String requestType, String description) {
        String query = "INSERT INTO CustomerRequests (request_type, description) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, requestType);
            statement.setString(2, description);
            statement.executeUpdate();
            System.out.println("Request submitted successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to insert request into the database!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
