package Customer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.sql.*;

public class CustomerLogin extends Application {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "@arun123";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label lblFullname = new Label("USER : ");
        Label lblLoginPassword = new Label("PASSWORD : ");

        TextField txtFullname = new TextField();
        TextField txtLoginPassword = new TextField();

        Button btnLogin = new Button("Login");
        btnLogin.setOnAction((event) -> {
            String fullname = txtFullname.getText();
            String loginPass = txtLoginPassword.getText();
            if (Fullname(fullname, loginPass)) {
                openNewTab(primaryStage);
            } else {
                showAlert("Error: Invalid username or password.");
            }
        });

        Button btnClose = new Button("Close");
        btnClose.setOnAction((event) -> {
            primaryStage.close();
        });

        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);

        pane.add(lblFullname, 0, 0);
        pane.add(txtFullname, 1, 0);

        pane.add(lblLoginPassword, 0, 1);
        pane.add(txtLoginPassword, 1, 1);

        pane.add(btnLogin, 0, 2);
        pane.add(btnClose, 1, 2);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Customer Login");
        primaryStage.setWidth(400);
        primaryStage.setHeight(200);
        primaryStage.show();
    }

    private boolean Fullname(String fullname, String password) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String sql = "SELECT * FROM Customers WHERE fullname = ? AND pass_word = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, fullname);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void openNewTab(Stage primaryStage) {
        Stage newStage = new Stage();
        GridPane newPane = new GridPane();
        newPane.setHgap(10);
        newPane.setVgap(10);

        Button btnUserManagement = new Button("User Management");
        Button btnServiceManagement = new Button("Service Management");
        Button btnAppointmentManagement = new Button("Appointment Management");
        Button btnLogout = new Button("Log Out");

        btnLogout.setOnAction((event) -> {
            newStage.close();
        });

        newPane.add(btnUserManagement, 0, 0);
        newPane.add(btnServiceManagement, 0, 1); 
        newPane.add(btnAppointmentManagement, 0, 2);
        newPane.add(btnLogout, 0, 3);

        Scene newScene = new Scene(newPane);
        newStage.setScene(newScene);
        newStage.setTitle("Customer Portal");
        newStage.setWidth(600);
        newStage.setHeight(400);
        newStage.show();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
