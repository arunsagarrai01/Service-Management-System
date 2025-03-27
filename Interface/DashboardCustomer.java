package Interface;

import Admin.InsertCustomer;
import Customer.ManageAccount;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DashboardCustomer extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Combo box made to do default selection
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Manage Account", "View Service", "Request Quotes", "Booking Appointment", "History");
        comboBox.setValue("Choose Who are you");

        // Button confirm created
        Button btnConfirm = new Button("Confirm");
        // Close button created
        Button btnClose = new Button("Close");

        // Button to insert customer
        Button btnInsertCustomer = new Button("Insert Customer");
        btnInsertCustomer.setOnAction((event) -> openInsertCustomerWindow());

        // Buttons created for different options
        Button btnManageAccount = new Button("Manage Account");// Open Manage Account window when ManageAccount button is clicked
        btnManageAccount.setOnAction((event) -> {
            try {
                openManageAccountWindow();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Button btnViewService = new Button("View Service");
        btnViewService.setOnAction((event) -> openViewServiceWindow());// Open View Service window when ViewService button clicked

        Button btnRequestQuotes = new Button("Request Quotes");
        btnRequestQuotes.setOnAction((event) -> openRequestQuotesWindow()); // Open Request Quotes window when RequestQuotes button is clicked

        Button btnBookingAppointment = new Button("Booking Appointment");
        btnBookingAppointment.setOnAction((event) -> {
            try {
                openBookingAppointmentWindow();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });// Open Booking Appointment window when button BookingAppointment clicked
        
        Button btnHistory = new Button("History");
        btnHistory.setOnAction((event) -> openHistoryPane());// Open History window when button History clicked

        // Loading the image logo
        Image logoImage = new Image("file:///C:/Users/aruns/OneDrive/Pictures/Screenshots/Screenshot%202024-04-14%20223453.png");

        // Creating the ImageView to show image
        ImageView logoImageView = new ImageView(logoImage);

        // Creating VBox to hold buttons vertically
        VBox buttonBox = new VBox(20); // spacing between buttons
        buttonBox.getChildren().addAll(btnInsertCustomer, btnManageAccount, btnViewService, btnRequestQuotes, btnBookingAppointment, btnHistory);
        buttonBox.setAlignment(javafx.geometry.Pos.CENTER);

        // BorderPane to hold logo at the top and buttons at the bottom
        BorderPane root = new BorderPane();

        // Logo added on the top
        root.setTop(logoImageView);

        // Buttons added at the bottom
        root.setBottom(buttonBox);

        // Creating a light purple background
        BackgroundFill backgroundFill = new BackgroundFill(Color.rgb(220, 200, 255), null, null);
        Background background = new Background(backgroundFill);
        root.setBackground(background);

        // Scene created and set on stage
        Scene scene = new Scene(root, 700, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dashboard Customer");
        primaryStage.show();
    }

    private void openInsertCustomerWindow() {
        Stage insertCustomerStage = new Stage();
        InsertCustomer insertCustomer = new InsertCustomer();
        insertCustomer.start(insertCustomerStage);
    }

    private void openBookingAppointmentWindow() {
        Stage bookStage = new Stage();
        Plumbing plumbing = new Plumbing();
        plumbing.start(bookStage);
    }

    private void openManageAccountWindow() throws Exception {
        Stage manageAccountStage = new Stage();
        ManageAccount manageAccount = new ManageAccount();
        manageAccount.start(manageAccountStage);
    }

    private void openViewServiceWindow() {
        Stage viewServiceStage = new Stage();
        ViewService viewService = new ViewService();
        viewService.start(viewServiceStage);
    }

    private void openRequestQuotesWindow() {
        Stage requestQuotesStage = new Stage();
        RequestQuotes requestQuotes = new RequestQuotes();
        requestQuotes.start(requestQuotesStage);
    }

    private void openHistoryPane() {
        Stage historyStage = new Stage();
        HistoryPane historyPane = new HistoryPane();
        try {
            historyPane.start(historyStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {// main method
        launch(args);
    }
}

