package Customer;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerRegistration extends Application {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/SMS";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "@arun123";

    // Declare text fields
    private TextField customerIDField;
    private TextField customerFullNameField;
    private TextField customerAddressField;
    private TextField customerEmailField;
    private TextField customerPhoneField;
    private TextField customerGenderField;
    private TextField customerLoginIDField;
    private PasswordField customerPasswordField;

    @Override
    public void start(Stage primaryStage) {

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Customer fields
        Label customerLabel = new Label("Customer Registration");
        gridPane.add(customerLabel, 0, 0, 2, 1);

        Label customerIDLabel = new Label("Customer ID:");
        gridPane.add(customerIDLabel, 0, 1);
        customerIDField = new TextField(); // Initialize customer ID text field
        gridPane.add(customerIDField, 1, 1);

        // Similar initialization for other text fields...

        // Confirm Button...
    }

    private void saveCustomer() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql = "INSERT INTO customers (customer_id, full_name, address, email, phone_number, gender, login_id, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customerIDField.getText());
            preparedStatement.setString(2, customerFullNameField.getText());
            preparedStatement.setString(3, customerAddressField.getText());
            preparedStatement.setString(4, customerEmailField.getText());
            preparedStatement.setString(5, customerPhoneField.getText());
            preparedStatement.setString(6, customerGenderField.getText());
            preparedStatement.setString(7, customerLoginIDField.getText());
            preparedStatement.setString(8, customerPasswordField.getText());

            preparedStatement.executeUpdate();

            System.out.println("Customer information saved successfully.");

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
