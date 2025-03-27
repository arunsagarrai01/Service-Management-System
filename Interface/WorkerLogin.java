package Interface;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class WorkerLogin extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label lblLoginID = new Label("Worker ID: ");// Label created for inputing worker id
        Label lblLoginPassword = new Label("Password: ");// label created for inputing login password

        TextField txtLoginID = new TextField();
        PasswordField txtLoginPassword = new PasswordField();// TextField changed to password for inputing password

        Button btnLogin = new Button("Login");
        btnLogin.setOnAction((event) -> {
            String loginID = txtLoginID.getText();
            String loginPass = txtLoginPassword.getText();
            boolean res = loginWorker(loginID, loginPass);// loginWorker method called by doing change
            if (res) {
                System.out.println("Valid worker");
                openWorkerPanel(primaryStage);//openWorkerPanel method called by doing change
            } else {
                System.out.println("Error: Invalid worker");// prints Error: Invalid worker if login id or password is invalid
            }
        });

        Button btnClose = new Button("Close");
        btnClose.setOnAction((event) -> {
            primaryStage.close();// action of close button assigned
        });

        GridPane pane = new GridPane();
        pane.setHgap(10);// Horizontal grid set
        pane.setVgap(10); // Vertical grid set

        pane.add(lblLoginID, 0, 0);
        pane.add(txtLoginID, 1, 0);// sets login id button

        pane.add(lblLoginPassword, 0, 1);
        pane.add(txtLoginPassword, 1, 1);// sets login password button

        pane.add(btnLogin, 0, 2);// sets login button place 
        pane.add(btnClose, 1, 2);// sets close button place

        Scene scene = new Scene(pane); // sets scene
        primaryStage.setScene(scene);
        primaryStage.setTitle("Worker Login"); // Worker Login Title set
        primaryStage.setWidth(400);// sets width 400 of window
        primaryStage.setHeight(200);// sets height 200 of window
        primaryStage.show();// shows Window
    }

    public boolean loginWorker(String workerID, String password) {
        // Worker logic to run code
        return true; // return test
    }

    public void openWorkerPanel(Stage primaryStage) {
        Stage newStage = new Stage();
        GridPane newPane = new GridPane();
        newPane.setHgap(10);// Horizontal grid set
        newPane.setVgap(10);// Vertical grid set

        Button btnUserManagement = new Button("User Management");
        // Action set for User Management button

        Button btnServiceManagement = new Button("Service Management");
        // Action set for Service Management button

        Button btnAppointmentManagement = new Button("Appointment Management");
        // Action for Appointment Management button set
        
        Button btnLogout = new Button("Log Out");
        btnLogout.setOnAction((event) -> {
            primaryStage.close();// Sets logout button and it's action
        });

        newPane.add(btnUserManagement, 0, 0);// UserManagement button placed
        newPane.add(btnServiceManagement, 0, 1);// ServiceManagement button placed
        newPane.add(btnAppointmentManagement, 0, 2);// AppointmentManagement button placed
        newPane.add(btnLogout, 0, 3);//logout button placed
        
        Scene newScene = new Scene(newPane);// sets scene
        newStage.setScene(newScene);
        newStage.setTitle("Worker Panel");// sets title as worker panel 
        newStage.setWidth(600);// width 600 of worker panel window sets
        newStage.setHeight(400);// height 400 of worker panel window sets
        newStage.show();// shows worker panel window 
    }
}// ends code
