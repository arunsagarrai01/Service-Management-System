package Interface;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ViewService extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(30); // Horizontal gap between columns
        gridPane.setVgap(30); // Vertical gap between rows
        gridPane.setPadding(new Insets(30)); // Padding around the grid pane

        Button Plumbing = new Button("Plumbing");
        Plumbing.setPrefSize(100, 50); // Set width and height for the Plumbing button

        Plumbing.setOnAction((event) -> {// setting action for button Plumbing
            Plumbing plumbing = new Plumbing();
            Stage plumbingStage = new Stage();
            try {
                plumbing.start(plumbingStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Button Electrical_Repairs = new Button("Electrical_Repairs");
        Electrical_Repairs.setPrefSize(100, 50); // Set width and height for the Electrical_Repairs button
        Electrical_Repairs.setOnAction(e -> {
            ElectricalRepairs repairs = new ElectricalRepairs();
            Stage repairsStage = new Stage();
            try {
                repairs.start(repairsStage);
            } catch (Exception event) {
                event.printStackTrace();
            }
        });

        Button Cleaner = new Button("Cleaner");
        Cleaner.setPrefSize(100, 50); // Set width and height for the Cleaning button
        Cleaner.setOnAction(e -> {
            Cleaner cleaner = new Cleaner();
            Stage repairsStage = new Stage();
            try {
                cleaner.start(repairsStage);
            } catch (Exception event) {
                event.printStackTrace();
            }
        });
        // Add buttons to the grid pane, each in a separate column
        gridPane.add(Plumbing, 3, 4);
        gridPane.add(Electrical_Repairs, 4, 5);
        gridPane.add(Cleaner, 5, 6);

        // Set background color
        BackgroundFill backgroundFill = new BackgroundFill(Color.CYAN, null, null);
        Background background = new Background(backgroundFill);
        gridPane.setBackground(background);

        Scene scene = new Scene(gridPane);

        primaryStage.setScene(scene);// set scene
        primaryStage.setWidth(600);// set width of window as 600
        primaryStage.setHeight(500);// set height of window as 500 
        primaryStage.setTitle("View Service");// set window title as View Service
        primaryStage.show();// display window
    }

    public static void main(String[] args) {
        launch(args);
    }
}// code ended
