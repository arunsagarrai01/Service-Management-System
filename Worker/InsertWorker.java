package Worker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InsertWorker extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label lblWID = new Label("Worker ID : ");
        Label lblFullName = new Label("Full Name : ");
        Label lblAddress = new Label("Address : ");
        Label lblPhoneNumber = new Label("Phone Number : ");
        Label lblGender = new Label("Gender : ");
        Label lblRole = new Label("Role : ");
        Label lblEmail = new Label("Email : ");
        Label lblLoginPassword = new Label("Login Password : ");

        TextField txtWID = new TextField();
        TextField txtFullName = new TextField();
        TextField txtAddress = new TextField(); // Changed from TextArea
        TextField txtPhoneNumber = new TextField();
        ComboBox<String> cbGender = new ComboBox<>(); // Changed from TextArea
        cbGender.getItems().addAll("Male", "Female");

        ComboBox cmbRole = new ComboBox();
        List lst = new ArrayList();
        lst.add("Plumber");
        lst.add("Electrician");
        lst.add("Cleaner");
        cmbRole.getItems().addAll(lst);

        TextField txtEmail = new TextField();
        TextField txtLoginPassword = new TextField();

        Button btnSave = new Button("Save");
        btnSave.setOnAction((event) -> {
            int wid = Integer.parseInt(txtWID.getText());
            String fullName = txtFullName.getText();
            String address = txtAddress.getText();
            String phoneNumber = txtPhoneNumber.getText();
            String gender = cbGender.getValue(); // Using ComboBox for gender selection
            String role = cmbRole.getValue().toString();
            String email = txtEmail.getText();
            String loginPass = txtLoginPassword.getText();

            Worker worker = new Worker(wid, fullName, address, phoneNumber, gender, role, email, loginPass);
            boolean res = saveRecord(worker);
            if (res) {
                System.out.println("Record Saved");
            } else {
                System.out.println("Error: Failed to save record");
            }
        });

        Button btnClose = new Button("Close");
        btnClose.setOnAction((event) -> primaryStage.close());

        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.add(lblWID, 0, 0);
        pane.add(txtWID, 1, 0);
        pane.add(lblFullName, 0, 1);
        pane.add(txtFullName, 1, 1);
        pane.add(lblAddress, 0, 2);
        pane.add(txtAddress, 1, 2);
        pane.add(lblPhoneNumber, 0, 3);
        pane.add(txtPhoneNumber, 1, 3);
        pane.add(lblGender, 0, 4);
        pane.add(cbGender, 1, 4);
        
        pane.add(lblRole, 0, 6);
        pane.add(cmbRole, 1, 6);
        pane.add(lblEmail, 0, 7);
        pane.add(txtEmail, 1, 7);
        pane.add(lblLoginPassword, 0, 8);
        pane.add(txtLoginPassword, 1, 8);
        pane.add(btnSave, 1, 9);
        pane.add(btnClose, 2, 9);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Insert into Worker");
        primaryStage.setWidth(650);
        primaryStage.setHeight(450);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public boolean saveRecord(Worker worker) {
        boolean result = false;
        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String HOST = "localhost";
        int PORT = 3306;
        String DATABASE = "SMS";
        String DBUSER = "root";
        String DBPASS = "@arun123";
        String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
        String sql = "INSERT INTO Workers (wid, fullname, address, phone_number, gender,roles, email, pass_word) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setInt(1, worker.getWid());
            pstat.setString(2, worker.getFullName());
            pstat.setString(3, worker.getAddress());
            pstat.setString(4, worker.getPhone_number());
            pstat.setString(5, worker.getGender());
            pstat.setString(6, worker.getRole());
            pstat.setString(7, worker.getEmail());
            pstat.setString(8, worker.getPass_word());
            pstat.executeUpdate(); // Execute insert statement
            pstat.close();
            conn.close();
            result = true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return result;
    }
}
