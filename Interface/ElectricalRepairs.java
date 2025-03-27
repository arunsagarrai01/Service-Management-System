package Interface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ElectricalRepairs extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Creating labels
        Label cidLabel = new Label("CID:");
        Label fullnameLabel = new Label("Full Name:");
        Label timeLabel = new Label("Time:");
        Label locationLabel = new Label("Location:");

        // Creating text fields
        TextField cidTextField = new TextField();
        TextField fullnameTextField = new TextField();
        TextField timeTextField = new TextField();
        TextField locationTextField = new TextField();

        // Creating buttons
        Button bookButton = new Button("Book");
        Button closeButton = new Button("Close");

        // Adding functionality to buttons
        bookButton.setOnAction(event -> {
            // Add functionality to book button (e.g., database connection)
            // You can retrieve data from text fields like this:
            String cidStr = cidTextField.getText();
            int cid = Integer.parseInt(cidStr); // Parse text to int
            String fullname = fullnameTextField.getText();
            String time = timeTextField.getText();
            String location = locationTextField.getText();

            // Create an ElectricalRepairs object to pass to the electricalRepairs() method
            ElectricalRepairs electricalRepairs = new ElectricalRepairs();

            // Call the electricalRepairs() method to insert data into the database
            boolean isBooked = electricalRepairs.electricalRepairs(cid, fullname, time, location);

            if (isBooked) {
                // Display a message indicating that the electrical repairs service has been booked
                System.out.println("Electrical Repairs service booked successfully!");
            } else {
                // Display an error message if booking fails
                System.out.println("Failed to book electrical repairs service.");
            }
        });

        closeButton.setOnAction(event -> primaryStage.close());

        // Creating a grid pane to organize the elements
        GridPane gridPane = new GridPane();
        gridPane.addRow(0, cidLabel, cidTextField);
        gridPane.addRow(1, fullnameLabel, fullnameTextField);
        gridPane.addRow(2, timeLabel, timeTextField);
        gridPane.addRow(3, locationLabel, locationTextField);
        gridPane.addRow(4, bookButton, closeButton);

        // Setting the spacing between elements
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Creating a scene and setting it on the stage
        Scene scene = new Scene(gridPane, 400, 200);
        scene.setFill(Color.LIGHTBLUE); // Set the background color of the scene
        primaryStage.setScene(scene);
        primaryStage.setTitle("Book Electrical Repairs");
        primaryStage.show();
    }

    public boolean electricalRepairs(int cid, String name, String time, String location) {
        boolean result = false;
        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String HOST = "localhost";
        int PORT = 3306;
        String DATABASE = "SMS";
        String DBUSER = "root";
        String DBPASS = "@arun123";
        String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
        String sql = "INSERT INTO ElectricalRepairs (cid, name, time, location) VALUES (?, ?, ?, ?)";
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setInt(1, cid); // Set int parameter
            pstat.setString(2, name);
            pstat.setString(3, time);
            pstat.setString(4, location);

            pstat.executeUpdate(); // Execute insert statement
            pstat.close();
            conn.close();
            result = true;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(); // Print stack trace to identify issues
        }
        return result;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
