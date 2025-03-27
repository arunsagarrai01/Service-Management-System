package Interface;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Service extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Creating buttons
        Button plumbingButton = new Button("Plumbing");
        Button electricianButton = new Button("Electrician");
        Button cleanerButton = new Button("Cleaner");

        // Setting action for plumbing button
        plumbingButton.setOnAction(e -> {
            // Code to handle plumbing service
            System.out.println("Plumbing service selected");
        });

        // Setting action for electrician button
        electricianButton.setOnAction(e -> {
            // Code to handle electrician service
            System.out.println("Electrician service selected");
        });

        // Setting action for cleaner button
        cleanerButton.setOnAction(e -> {
            // Code to handle cleaner service
            System.out.println("Cleaner service selected");
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

    public static void main(String[] args) {
        launch(args);
    }
}
