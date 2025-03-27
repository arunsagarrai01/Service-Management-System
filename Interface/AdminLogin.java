package Interface;

import Admin.DashboardAdmin;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField; // Changed from TextField to PasswordField for password input
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AdminLogin extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label lblLoginID = new Label("Admin ID: ");//Creating label for inserting login id
        Label lblLoginPassword = new Label("Password: ");// Creating label for inserting login password

        TextField txtLoginID = new TextField();
        PasswordField txtLoginPassword = new PasswordField(); // Changing TextField to PasswordField to insert password

        Button btnLogin = new Button("Login");
        btnLogin.setOnAction((event) -> {
            String loginName = txtLoginID.getText();
            String loginPass = txtLoginPassword.getText();
            boolean res = loginAdmin(loginName, loginPass); // LoginAdmin method called by doing change
            if (res) {
                System.out.println("Valid admin");
                openAdminPanel(primaryStage); // OpenAdminPanel method called by doing change
            } else {
                System.out.println("Error: Invalid admin");// Printing Error: Invalid admin 
            }
        });

        Button btnClose = new Button("Close");
        btnClose.setOnAction((event) -> {// Pleacing button to close the window
            primaryStage.close();
        });

        GridPane pane = new GridPane();// Grid created for screen
        pane.setHgap(10);// Horizental grid set
        pane.setVgap(10);// vertical grid set

        pane.add(lblLoginID, 0, 0);// setting login id button place
        pane.add(txtLoginID, 1, 0);

        pane.add(lblLoginPassword, 0, 1);// setting login password place
        pane.add(txtLoginPassword, 1, 1);

        pane.add(btnLogin, 0, 2);// setting login button place
        pane.add(btnClose, 1, 2);// setting close button place

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);// Sets screen
        primaryStage.setTitle("Admin Login");// sets title Admin Login
        primaryStage.setWidth(400);// sets width 400
        primaryStage.setHeight(200);// sets height 200
        primaryStage.show();// shows window
    }

    public boolean loginAdmin(String adminID, String password) {
        // Admin logic
        return true; // Return Testing
    }

    public void openAdminPanel(Stage primaryStage) {//New openAdminPanel created
        Stage newStage = new Stage();
        GridPane newPane = new GridPane();
        newPane.setHgap(10);// sets horizontal grid
        newPane.setVgap(10);// sets vertical grid

        Button btnDashboardAdmin = new Button("Dashboard Admin");
        btnDashboardAdmin.setOnAction((event) -> {
            Stage adminStage=new Stage();
            DashboardAdmin admin=new DashboardAdmin();
            admin.start(adminStage);
        });
        
        Button btnLogout = new Button("Log Out");
        btnLogout.setOnAction((event) -> {
            primaryStage.close();// sets logout button and it's action
        });

        newPane.add(btnDashboardAdmin, 0, 0);//Dashboard Admin button row and column sets
        newPane.add(btnLogout, 0, 3);// Sets row and column of logout button
        
        Scene newScene = new Scene(newPane);//Sets scene
        newStage.setScene(newScene);
        newStage.setTitle("Admin Panel");// stes title Admin Panel
        newStage.setWidth(600);// sets width 600 of window
        newStage.setHeight(400);// sets height 400 of window
        newStage.show();
    }
}// ends the code
