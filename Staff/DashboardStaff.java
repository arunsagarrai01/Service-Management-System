package Staff;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DashboardStaff extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Combo box created to do default selection
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Booking, View Customer, View Staff, View Service, View Report");
        

        // Button conform created
        Button btnConfirm = new Button("Confirm");
        // Button close created
        Button btnClose = new Button("Close");

        // Creating buttons for different options
        Button btnBooking = new Button("Booking");
        Button btnViewCustomer = new Button("View Customer");
        Button btnViewStaff = new Button("View Staff");
        Button btnViewService = new Button("View Service");
        Button btnViewReport = new Button("View Report");

        // Loading the image logo
        Image logoImage = new Image("file:///C:/Users/aruns/OneDrive/Pictures/Screenshots/Screenshot%202024-04-14%20223453.png");

        // Creating the ImageView to show image
        ImageView logoImageView = new ImageView(logoImage);

        // HBox to hold buttons horizontally
        VBox buttonBox = new VBox(20); // spacing between buttons
        buttonBox.getChildren().addAll(btnBooking, btnViewCustomer, btnViewStaff, btnViewService, btnViewReport);
        buttonBox.setAlignment(javafx.geometry.Pos.CENTER);

        // BorderPane to hold logo at the top and buttons at the bottom
        BorderPane root = new BorderPane();

        // Adding logo at the top
        root.setTop(logoImageView);

        // Adding buttons at the bottom
        root.setBottom(buttonBox);

        // Scene created and set on stage
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dashboard Staff");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
