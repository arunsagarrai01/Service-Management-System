package Admin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

// Import the Revenue class
import Interface.Revenue;

public class DashboardAdmin extends Application {

    @Override
    public void start(Stage primaryStage) {
        ComboBox<String> comboBox = new ComboBox<>();// setting combo box
        comboBox.getItems().addAll("View Customer", "View Report");
        comboBox.setValue("Choose Who are you");

        Button btnConfirm = new Button("Confirm");
        Button btnClose = new Button("Close");

        Button btnViewCustomer = new Button("View Customer");
        Button btnViewReport = new Button("View Report");
        Button btnRevenue = new Button("Revenue");

        Image logoImage = new Image("file:///C:/Users/aruns/OneDrive/Pictures/Screenshots/Screenshot%202024-04-14%20223453.png");
        ImageView logoImageView = new ImageView(logoImage);

        HBox buttonBox = new HBox(20);
        buttonBox.getChildren().addAll(btnViewCustomer, btnViewReport, btnRevenue);
        buttonBox.setAlignment(javafx.geometry.Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setTop(logoImageView);
        root.setBottom(buttonBox);

        Scene scene = new Scene(root, 500, 450);

        // Set fiery rose background color
        scene.setFill(Color.rgb(255, 62, 150));

        primaryStage.setScene(scene);//set scene
        primaryStage.setTitle("Dashboard");// set title as Dashboard of window
        primaryStage.show();

        // Event handling for "View Customer" button
        btnViewCustomer.setOnAction(event -> {
            ViewCustomer viewCustomer = new ViewCustomer();
            try {
                viewCustomer.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
                // Handle exception appropriately
            }
        });

        // Event handling for "View Report" button
        btnViewReport.setOnAction(event -> {
            ViewReport viewReport = new ViewReport();
            try {
                viewReport.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
                // Handle exception appropriately
            }
        });

        // Event handling for "Revenue" button
        btnRevenue.setOnAction(event -> {
            // Instantiate the Revenue class and call its start() method
            Revenue revenue = new Revenue();
            try {
				revenue.start(new Stage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}//end code
