package Interface;

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

public class CustomerRegistrations extends Application {

    private Connection connection;
    private TextField customerCidField;
    private TextField customerFullNameField;
    private TextField customerAddressField;
    private TextField customerEmailField;
    private TextField customerPhone_numberField;
    private TextField customerGenderField;
    private TextField customerLoginIDField;
    private PasswordField customerPasswordField;

    @Override
    public void start(Stage primaryStage) throws Exception {
        establishDatabaseConnection(); // Connect to the database

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Define UI components
        customerCidField = new TextField();
        customerFullNameField = new TextField();
        customerAddressField = new TextField();
        customerEmailField = new TextField();
        customerPhone_numberField = new TextField();
        customerGenderField = new TextField();
        customerLoginIDField = new TextField();
        customerPasswordField = new PasswordField();

        // Add UI components to the gridPane
        gridPane.add(new Label("CID:"), 0, 0);
        gridPane.add(customerCidField, 1, 0);
        gridPane.add(new Label("Full Name:"), 0, 1);
        gridPane.add(customerFullNameField, 1, 1);
        gridPane.add(new Label("Address:"), 0, 2);
        gridPane.add(customerAddressField, 1, 2);
        gridPane.add(new Label("Email:"), 0, 3);
        gridPane.add(customerEmailField, 1, 3);
        gridPane.add(new Label("Phone Number:"), 0, 4);
        gridPane.add(customerPhone_numberField, 1, 4);
        gridPane.add(new Label("Gender:"), 0, 5);
        gridPane.add(customerGenderField, 1, 5);
        gridPane.add(new Label("Login ID:"), 0, 6);
        gridPane.add(customerLoginIDField, 1, 6);
        gridPane.add(new Label("Password:"), 0, 7);
        gridPane.add(customerPasswordField, 1, 7);

        Button btnConfirm = new Button("Confirm");
        btnConfirm.setOnAction(event -> {
            // Handle confirmation
            registerCustomer();
        });

        Button btnClose = new Button("Close");
        btnClose.setOnAction(event -> primaryStage.close());

        gridPane.add(btnConfirm, 0, 9);
        gridPane.add(btnClose, 1, 9);

        primaryStage.setScene(new Scene(gridPane, 500, 500));
        primaryStage.setTitle("Customer Registration Form");
        primaryStage.show();
    }

    private void establishDatabaseConnection() {
        // Load MySQL JDBC Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/SMS";
            String username = "root";
            String password = "@arun123";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void registerCustomer() {
        try {
            String query = "INSERT INTO InsertCustomer (cid, fullname, address, email, phone_number, gender, login_id, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customerCidField.getText());
            preparedStatement.setString(2, customerFullNameField.getText());
            preparedStatement.setString(3, customerAddressField.getText());
            preparedStatement.setString(4, customerEmailField.getText());
            preparedStatement.setString(5, customerPhone_numberField.getText());
            preparedStatement.setString(6, customerGenderField.getText());
            preparedStatement.setString(7, customerLoginIDField.getText());
            preparedStatement.setString(8, customerPasswordField.getText());
            preparedStatement.executeUpdate();
            System.out.println("Customer registered successfully");
            
            // Close resources
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
