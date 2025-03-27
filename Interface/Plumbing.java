package Interface;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Plumbing extends Application {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/SMS";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "@arun123";

    @Override
    public void start(Stage primaryStage) {
        // Creating labels
        Label cidLabel = new Label("CID:");
        Label nameLabel = new Label("Name:");
        Label timeLabel = new Label("Time:");
        Label locationLabel = new Label("Location:");

        // Creating text fields
        TextField cidTextField = new TextField();
        TextField nameTextField = new TextField();
        TextField timeTextField = new TextField();
        TextField locationTextField = new TextField();

        // Creating buttons
        Button bookButton = new Button("Book");
        Button closeButton = new Button("Close");

        // Adding functionality to buttons
        bookButton.setOnAction(event -> {
            // Get values from text fields
            String cid = cidTextField.getText();
            String name = nameTextField.getText();
            String time = timeTextField.getText();
            String location = locationTextField.getText();

            // Call method to save booking to database
            saveBooking(cid, name, time, location);
        });

        closeButton.setOnAction(event -> primaryStage.close());

        // Creating a grid pane to organize the elements
        GridPane gridPane = new GridPane();
        gridPane.addRow(0, cidLabel, cidTextField);
        gridPane.addRow(1, nameLabel, nameTextField);
        gridPane.addRow(2, timeLabel, timeTextField);
        gridPane.addRow(3, locationLabel, locationTextField);
        gridPane.addRow(4, bookButton, closeButton);

        // Setting the spacing between elements
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Setting silver color background
        Paint silverColor = Color.rgb(192, 192, 192); // RGB values for silver color
        gridPane.setStyle("-fx-background-color: " + toRGBCode(silverColor));

        // Creating a scene and setting it on the 
        Scene scene = new Scene(gridPane, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Plumber Book");
        primaryStage.show();
    }

    // Helper method to convert Paint to RGB string
    private String toRGBCode(Paint paint) {
        return String.format("#%02X%02X%02X",
                (int) (((Color) paint).getRed() * 255),
                (int) (((Color) paint).getGreen() * 255),
                (int) (((Color) paint).getBlue() * 255));
    }

    // Method to save booking to the database
    private void saveBooking(String cid, String name, String time, String location) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "INSERT INTO Plumbing (CID, Name, Time, Location) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cid);
            pstmt.setString(2, name);
            pstmt.setString(3, time);
            pstmt.setString(4, location);
            pstmt.executeUpdate();
            System.out.println("Booking saved successfully!");
        } catch (SQLException e) {
            System.out.println("Error saving booking: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
