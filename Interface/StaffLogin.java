package Interface;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StaffLogin extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label lblLoginID = new Label("Staff ID: ");// Creating label login id for inserting Staff ID
        Label lblLoginPassword = new Label("Password: ");// Creating label login password for inserting password

        TextField txtLoginID = new TextField();
        PasswordField txtLoginPassword = new PasswordField();// TextField changed to passwordField to insert password
        Button btnLogin = new Button("Login");
        btnLogin.setOnAction((event) -> {
            String loginName = txtLoginID.getText();
            String loginPass = txtLoginPassword.getText();
            boolean res = loginStaff(loginName, loginPass);// LoginStaff method called by doing change
            if (res) {
                System.out.println("Valid staff");
                openStaffPanel(primaryStage);// openStaffPanel method called by doing change
            } else {
                System.out.println("Error: Invalid staff");// Prints message Error: Invalid Staff
            }
        });

        Button btnClose = new Button("Close");
        btnClose.setOnAction((event) -> {
            primaryStage.close();// Closes the window
        });

        GridPane pane = new GridPane();// Grid created for screen
        pane.setHgap(10);// Horizontal Grid set
        pane.setVgap(10);// Vertical Grid set

        pane.add(lblLoginID, 0, 0);// Sets login id button place
        pane.add(txtLoginID, 1, 0);

        pane.add(lblLoginPassword, 0, 1);// sets loginpassword button place
        pane.add(txtLoginPassword, 1, 1);

        pane.add(btnLogin, 0, 2);// sets login button 
        pane.add(btnClose, 1, 2);// sets close button

        Scene scene = new Scene(pane);// Sets scene
        primaryStage.setScene(scene);
        primaryStage.setTitle("Staff Login");// sets title
        primaryStage.setWidth(400);// sets width 400 of window
        primaryStage.setHeight(200);// sets height 200 of window
        primaryStage.show();// shows window
    }

    public boolean loginStaff(String staffID, String password) {
        // Logic of staff
        return true;// returning test
    }

    public void openStaffPanel(Stage primaryStage) {
        Stage newStage = new Stage();
        GridPane newPane = new GridPane();
        newPane.setHgap(10);//sets horizontal grid
        newPane.setVgap(10);// sets vertical grid

        //Button btnDashboardCustomer = new Button("Dashboard Customer");
        // Action for Dashboard Customer button sets

        Button btnStaffDashboard = new Button("Staff Dashboard");
        btnStaffDashboard.setOnAction((event) -> {
            Stage staffStage=new Stage();
           StaffDashboard staff=new StaffDashboard();
            staff.start(staffStage);
        });
        // Action for Dashboard Staff button sets

        //Button btnDashboardAdmin = new Button("Dasboard Admin");
        // Action for Dashboard Admin button sets
        
        Button btnLogout = new Button("Log Out");
        btnLogout.setOnAction((event) -> {
            primaryStage.close();// sets logout button and it's action
        });

        //newPane.add(btnDashboardCustomer, 0, 0);//Row and column sets of User Management
        newPane.add(btnStaffDashboard, 0, 1);// Row and column sets of Service Management
        //newPane.add(btnDashboardAdmin, 0, 2);// Row and column sets of Appointment Management
        newPane.add(btnLogout, 0, 3);
        
        Scene newScene = new Scene(newPane);//Sets scene
        newStage.setScene(newScene);
        newStage.setTitle("Staff Panel");// Staff Panel title sets
        newStage.setWidth(600);// width 600 sets of window 
        newStage.setHeight(400);// height 400 sets of window
        newStage.show(); // shows window
    }
}// ends code
