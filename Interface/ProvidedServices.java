package Interface;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ProvidedServices extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Creating buttons
        Button plumbingButton = new Button("Plumbing");
        Button electricianButton = new Button("Electrician");
        Button cleanerButton = new Button("Cleaner");

        // Setting action for plumbing button
        plumbingButton.setOnAction(event -> {
            // Code to handle plumbing service
            System.out.println("Plumbing service selected");
            // Call method to display plumbing booking form
            showPlumbingBookingForm();
        });

        // Setting action for electrician button
        electricianButton.setOnAction(event -> {
            // Code to handle electrician service
            System.out.println("Electrician service selected");
            showElectricianBookingForm();
            // Implement electrician service handling
        });

        // Setting action for cleaner button
        cleanerButton.setOnAction(event -> {
            // Code to handle cleaner service
            System.out.println("Cleaner service selected");
            showCleanerBookingForm();
            // Implement cleaner service handling
        });

        // Creating an HBox to hold the buttons
        HBox hbox = new HBox(10); // spacing = 10
        hbox.setPadding(new Insets(20)); // padding around the hbox
        hbox.getChildren().addAll(plumbingButton, electricianButton, cleanerButton);

        // Creating a scene and setting it to the stage
        Scene scene = new Scene(hbox);
        primaryStage.setScene(scene);

        // Setting stage properties
        primaryStage.setTitle("Service Buttons");
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);
        primaryStage.show();
    }

    private void showPlumbingBookingForm() {
        Stage stage = new Stage();

        // Creating labels and text fields for plumbing booking form
        Label customerIdLabel = new Label("Customer ID:");
        TextField customerIdField = new TextField();
        Label customerNameLabel = new Label("Customer Name:");
        TextField customerNameField = new TextField();
        Label addressLabel = new Label("Address:");
        TextField addressField = new TextField();
        Label timeLabel = new Label("Time:");
        TextField timeField = new TextField();
        Label costLabel = new Label("Cost:");
        TextField costField = new TextField();

        // Creating a button for booking
        Button bookButton = new Button("Book");

        // Creating a GridPane to hold the form elements
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        // Adding elements to the grid
        gridPane.add(customerIdLabel, 0, 0);
        gridPane.add(customerIdField, 1, 0);
        gridPane.add(customerNameLabel, 0, 1);
        gridPane.add(customerNameField, 1, 1);
        gridPane.add(addressLabel, 0, 2);
        gridPane.add(addressField, 1, 2);
        gridPane.add(timeLabel, 0, 3);
        gridPane.add(timeField, 1, 3);
        gridPane.add(costLabel, 0, 4);
        gridPane.add(costField, 1, 4);
        gridPane.add(bookButton, 0, 5, 2, 1);

        // Setting action for book button
        bookButton.setOnAction(e -> {
            // Code to handle booking
            System.out.println("Booking for plumbing service:");
            System.out.println("Customer ID: " + customerIdField.getText());
            System.out.println("Customer Name: " + customerNameField.getText());
            System.out.println("Address: " + addressField.getText());
            System.out.println("Time: " + timeField.getText());
            System.out.println("Cost: " + costField.getText());
            // You can add further processing here like saving to database, etc.
            stage.close(); // Close the booking form stage after booking
        });

        // Creating a scene and setting it to the stage
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.setTitle("Plumbing Booking");
        stage.show();
    }
    
    private void showElectricianBookingForm() {
        Stage stage = new Stage();

        // Creating labels and text fields for plumbing booking form
        Label customerIdLabel = new Label("Customer ID:");
        TextField customerIdField = new TextField();
        Label customerNameLabel = new Label("Customer Name:");
        TextField customerNameField = new TextField();
        Label addressLabel = new Label("Address:");
        TextField addressField = new TextField();
        Label timeLabel = new Label("Time:");
        TextField timeField = new TextField();
        Label costLabel = new Label("Cost:");
        TextField costField = new TextField();

        // Creating a button for booking
        Button bookButton = new Button("Book");

        // Creating a GridPane to hold the form elements
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        // Adding elements to the grid
        gridPane.add(customerIdLabel, 0, 0);
        gridPane.add(customerIdField, 1, 0);
        gridPane.add(customerNameLabel, 0, 1);
        gridPane.add(customerNameField, 1, 1);
        gridPane.add(addressLabel, 0, 2);
        gridPane.add(addressField, 1, 2);
        gridPane.add(timeLabel, 0, 3);
        gridPane.add(timeField, 1, 3);
        gridPane.add(costLabel, 0, 4);
        gridPane.add(costField, 1, 4);
        gridPane.add(bookButton, 0, 5, 2, 1);

        // Setting action for book button
        bookButton.setOnAction(e -> {
            // Code to handle booking
            System.out.println("Booking for electrician service:");
            System.out.println("Customer ID: " + customerIdField.getText());
            System.out.println("Customer Name: " + customerNameField.getText());
            System.out.println("Address: " + addressField.getText());
            System.out.println("Time: " + timeField.getText());
            System.out.println("Cost: " + costField.getText());
            // You can add further processing here like saving to database, etc.
            stage.close(); // Close the booking form stage after booking
        });

        // Creating a scene and setting it to the stage
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.setTitle("Electrician Booking");
        stage.show();
    }


    private void showCleanerBookingForm() {
        Stage stage = new Stage();

        // Creating labels and text fields for plumbing booking form
        Label customerIdLabel = new Label("Customer ID:");
        TextField customerIdField = new TextField();
        Label customerNameLabel = new Label("Customer Name:");
        TextField customerNameField = new TextField();
        Label addressLabel = new Label("Address:");
        TextField addressField = new TextField();
        Label timeLabel = new Label("Time:");
        TextField timeField = new TextField();
        Label costLabel = new Label("Cost:");
        TextField costField = new TextField();

        // Creating a button for booking
        Button bookButton = new Button("Book");

        // Creating a GridPane to hold the form elements
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        // Adding elements to the grid
        gridPane.add(customerIdLabel, 0, 0);
        gridPane.add(customerIdField, 1, 0);
        gridPane.add(customerNameLabel, 0, 1);
        gridPane.add(customerNameField, 1, 1);
        gridPane.add(addressLabel, 0, 2);
        gridPane.add(addressField, 1, 2);
        gridPane.add(timeLabel, 0, 3);
        gridPane.add(timeField, 1, 3);
        gridPane.add(costLabel, 0, 4);
        gridPane.add(costField, 1, 4);
        gridPane.add(bookButton, 0, 5, 2, 1);

        // Setting action for book button
        bookButton.setOnAction(e -> {
            // Code to handle booking
            System.out.println("Booking for cleaner service:");
            System.out.println("Customer ID: " + customerIdField.getText());
            System.out.println("Customer Name: " + customerNameField.getText());
            System.out.println("Address: " + addressField.getText());
            System.out.println("Time: " + timeField.getText());
            System.out.println("Cost: " + costField.getText());
            // You can add further processing here like saving to database, etc.
            stage.close(); // Close the booking form stage after booking
        });

        // Creating a scene and setting it to the stage
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.setTitle("Cleaner Booking");
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
