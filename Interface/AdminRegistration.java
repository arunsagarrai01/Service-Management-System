package Interface;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AdminRegistration extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Admin fields

        Button btnConfirm = new Button("Confirm");
        Button btnClose = new Button("Close");

        btnConfirm.setOnAction((event) -> {
            // Perform actions upon confirmation
        });

        btnClose.setOnAction((event) -> {
            primaryStage.close(); // Close the window when the Close button is clicked
        });

        gridPane.add(btnConfirm, 0, 10);
        gridPane.add(btnClose, 1, 10);

        Label adminIDLabel = new Label("Admin ID:");
        gridPane.add(adminIDLabel, 0, 1);

        Label full_NameLabel = new Label("Full Name:");
        gridPane.add(full_NameLabel, 0, 2);

        Label address_Label = new Label("Address:");
        gridPane.add(address_Label, 0, 3);

        Label email_Label = new Label("Email:");
        gridPane.add(email_Label, 0, 4);

        Label phone_NumberLabel = new Label("Phone Number:");
        gridPane.add(phone_NumberLabel, 0, 5);

        Label gender_Label = new Label("Gender:");
        gridPane.add(gender_Label, 0, 6);

        Label login_IDLabel = new Label("Login ID:");
        gridPane.add(login_IDLabel, 0, 7);

        Label passwordLabel = new Label("Password:");
        gridPane.add(passwordLabel, 0, 8);

        TextField adminIDField = new TextField();
        gridPane.add(adminIDField, 1, 1);

        TextField adminFullNameField = new TextField();
        gridPane.add(adminFullNameField, 1, 2);

        TextField adminAddressField = new TextField();
        gridPane.add(adminAddressField, 1, 3);

        TextField adminEmailField = new TextField();
        gridPane.add(adminEmailField, 1, 4);

        TextField adminPhoneField = new TextField();
        gridPane.add(adminPhoneField, 1, 5);

        TextField adminGenderField = new TextField();
        gridPane.add(adminGenderField, 1, 6);

        TextField adminLoginIDField = new TextField();
        gridPane.add(adminLoginIDField, 1, 7);

        PasswordField adminPasswordField = new PasswordField();
        gridPane.add(adminPasswordField, 1, 8);

        primaryStage.setScene(new Scene(gridPane, 500, 500));
        primaryStage.setTitle("Admin Registration Form");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
