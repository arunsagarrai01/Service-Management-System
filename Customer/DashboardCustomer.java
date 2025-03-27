package Customer;

import Interface.DashboardStaff;
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

public class DashboardCustomer extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Combo box created to do default selection
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Customer Registration", "Manage Account", "View Service", "Request Cuotes", "Booking Appointment", "History");
        comboBox.setValue("Choose Who are you");

        // Button conform created
        Button btnConform = new Button("Conform");
        // Button close created
        Button btnClose = new Button("Close");

        // Creating buttons for different options
        Button btnCustomerRegistration = new Button("Customer Registration");
        btnCustomerRegistration.setOnAction((event) -> {
            Stage customerRegisterStage=new Stage();
            CustomerRegistration customerRegistration=new CustomerRegistration();
            customerRegistration.start(customerRegisterStage);
        });
        
        
        Button btnManageAccount = new Button("Manage Account");
        //btnManageAccount.setOnAction((event) -> {
          //  Stage manageAccountStage=new Stage();
            //ManageAccount manageAccount=new manageAccount();
            //manageAccount.start(manageAccountStage);
        //});
        
        
        Button btnViewService = new Button("View Service");
        
        
        
        Button btnRequestCuotes = new Button("Request Cuotes");
        
        
        
        Button btnBookingAppointment = new Button("Booking Appointment");
        
        
        
        Button btnHistory = new Button("History");
        
        
        
        // Loading the image logo
        Image logoImage = new Image("file:///C:/Users/aruns/OneDrive/Pictures/Screenshots/Screenshot%202024-04-14%20223453.png");

        // Creating the ImageView to show image
        ImageView logoImageView = new ImageView(logoImage);

        // HBox to hold buttons horizontally
        VBox buttonBox = new VBox(20); // spacing between buttons
        buttonBox.getChildren().addAll(btnCustomerRegistration, btnManageAccount, btnViewService, btnRequestCuotes, btnBookingAppointment, btnHistory);
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
        primaryStage.setTitle("Dashboard Customer");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
