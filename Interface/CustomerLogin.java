package Interface;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CustomerLogin extends Application {

    public static void main(String[] args) { 
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label lblLoginID = new Label("USER : ");// adding label user
        Label lblLoginPassword = new Label("PASSWORD : ");// adding label password

        TextField txtLoginID = new TextField();// adding text field 
        TextField txtLoginPassword = new TextField();// adding text field

        Button btnLogin = new Button("Login");// setting action for login button
        btnLogin.setOnAction((event) -> {
            String loginName = txtLoginID.getText();
            String loginPass = txtLoginPassword.getText();
            boolean res = loginUser(loginName, loginPass);
            if (res) {
                System.out.println("Valid user");// printing valid user
                openNewTab(primaryStage);
            } else {
                System.out.println("Error: Invalid user");// printing error: invalid user
            }
        });

        Button btnClose = new Button("Close");//setting action for close button
        btnClose.setOnAction((event) -> {
            primaryStage.close();
        });

        GridPane pane = new GridPane();
        pane.setHgap(10);// horizontal grid pane
        pane.setVgap(10);// vertical grid pane

        pane.add(lblLoginID, 0, 0);// placing the label login id
        pane.add(txtLoginID, 1, 0);

        pane.add(lblLoginPassword, 0, 1);// placing the label login password
        pane.add(txtLoginPassword, 1, 1);

        pane.add(btnLogin, 0, 2);// placing login button
        pane.add(btnClose, 1, 2);// placing close button

        // Setting light green background color for the pane
        pane.setStyle("-fx-background-color: #ccffcc;");

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);//scene set
        primaryStage.setTitle("Customer Login");// setting title as Customer Login
        primaryStage.setWidth(400);// setting width 400 of window
        primaryStage.setHeight(200);// setting height 200 of window
        primaryStage.show();// showing window
    }

    public boolean loginUser(String user, String password) {
        // logic of login
        return true; // return for testing
    }

    public void openNewTab(Stage primaryStage) {
        Stage newStage = new Stage();
        GridPane newPane = new GridPane();
        newPane.setHgap(10);
        newPane.setVgap(10);

        Button btnDashboardCustomer = new Button("Dashboard Customer");
        btnDashboardCustomer.setOnAction((event) -> {// setting action for button DashboardCustomer
            Stage customerStage = new Stage();
            DashboardCustomer customer = new DashboardCustomer();
            customer.start(customerStage);
        });

        Button btnLogout = new Button("Log Out");
        btnLogout.setOnAction((event) -> {// setting action for log out button
            primaryStage.close();
        });

        newPane.add(btnDashboardCustomer, 0, 0);// placing DashboardCustomer button
        newPane.add(btnLogout, 0, 3);// placing Logout button

        Scene newScene = new Scene(newPane);
        newStage.setScene(newScene);// Set scene
        newStage.setTitle("Customer Portal");// Setting title as Customer Portal
        newStage.setWidth(600);// Setting width 600 of window
        newStage.setHeight(400);// Setting height 400 of window
        newStage.show();// displays window
    }
}// ends code
