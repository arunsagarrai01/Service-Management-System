package Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

public class InsertAdmin extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label lblAID = new Label("Admin ID : ");
        Label lblFullName = new Label("Full Name : ");
        Label lblAddress = new Label("Address : "); 
        Label lblGender = new Label("Gender : ");
        Label lblPhoneNumber = new Label("Phone Number : ");
        Label lblEmail = new Label("Email : ");
        Label lblLoginPassword = new Label("Login Password : ");

        TextField txtAID = new TextField();
        TextField txtFullName = new TextField();
        TextField txtAddress = new TextField(); // Changed from TextArea
        ComboBox<String> cbGender = new ComboBox<>(); // Changed from TextArea
        cbGender.getItems().addAll("Male", "Female");
        TextField txtPhoneNumber = new TextField();
        TextField txtEmail = new TextField();
        TextField txtLoginPassword = new TextField();

        Button btnSave = new Button("Save");
        btnSave.setOnAction((event) -> {
            int aid = Integer.parseInt(txtAID.getText());
            String fullName = txtFullName.getText();
            String address = txtAddress.getText();
            String gender = cbGender.getValue(); // Using ComboBox for gender selection
            String phoneNumber = txtPhoneNumber.getText();
            String email = txtEmail.getText();
            String loginPass = txtLoginPassword.getText();

            Admin admin = new Admin(aid, fullName, address, email, phoneNumber, gender, loginPass);
            boolean res = saveRecord(admin);
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
        pane.add(lblAID, 0, 0);
        pane.add(txtAID, 1, 0);
        pane.add(lblFullName, 0, 1);
        pane.add(txtFullName, 1, 1);
        pane.add(lblAddress, 0, 2);
        pane.add(txtAddress, 1, 2);
        pane.add(lblGender, 0, 3);
        pane.add(cbGender, 1, 3);
        
        pane.add(lblPhoneNumber, 0, 4);
        pane.add(txtPhoneNumber, 1, 4);
        pane.add(lblEmail, 0, 5);
        pane.add(txtEmail, 1, 5);
        pane.add(lblLoginPassword, 0, 6);
        pane.add(txtLoginPassword, 1, 6);
        pane.add(btnSave, 1, 7);
        pane.add(btnClose, 2, 7);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Insert into Admin");
        primaryStage.setWidth(650);
        primaryStage.setHeight(450);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public boolean saveRecord(Admin admin) {
        boolean result = false;
        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String HOST = "localhost";
        int PORT = 3306;
        String DATABASE = "SMS";
        String DBUSER = "root";
        String DBPASS = "@arun123";
        String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
        String sql = "INSERT INTO Admins (aid, fullname, address, gender, phone, email, pass_word) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setInt(1, admin.getAid());
            pstat.setString(2, admin.getFullname());
            pstat.setString(3, admin.getAddress());
            pstat.setString(4, admin.getEmail());
            pstat.setString(5, admin.getPhone());
            pstat.setString(6, admin.getGender());
            pstat.setString(7, admin.getPass_word());
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
