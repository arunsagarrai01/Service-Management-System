package Staff;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StaffRegistration extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Staff fields
        Label staffIDLabel = new Label("Staff ID:");
        gridPane.add(staffIDLabel, 0, 1);

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

        TextField staffIDField = new TextField();
        gridPane.add(staffIDField, 1, 1);

        TextField staffFullNameField = new TextField();
        gridPane.add(staffFullNameField, 1, 2);

        TextField staffAddressField = new TextField();
        gridPane.add(staffAddressField, 1, 3);

        TextField staffEmailField = new TextField();
        gridPane.add(staffEmailField, 1, 4);

        TextField staffPhoneField = new TextField();
        gridPane.add(staffPhoneField, 1, 5);

        TextField staffGenderField = new TextField();
        gridPane.add(staffGenderField, 1, 6);

        TextField staffLoginIDField = new TextField();
        gridPane.add(staffLoginIDField, 1, 7);

        PasswordField staffPasswordField = new PasswordField();
        gridPane.add(staffPasswordField, 1, 8);

        Button btnConform = new Button("Confirm");
        btnConform.setOnAction(event -> {
            // Here you can add code to handle confirmation
            System.out.println("Registration Confirmed");
        });

        Button btnClose = new Button("Close");
        btnClose.setOnAction(event -> primaryStage.close());

        gridPane.add(btnConform, 0, 9);
        gridPane.add(btnClose, 1, 9);

        primaryStage.setScene(new Scene(gridPane, 500, 500));
        primaryStage.setTitle("Staff Registration Form");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
