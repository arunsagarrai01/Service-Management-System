package Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewReport extends Application {

    // Default constructor required by Application class
    public ViewReport() {
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        TableView<ViewReports> table1 = new TableView<>(); // Changed to ViewReports
        table1.setPrefWidth(1000);
        table1.setPrefHeight(250);

        // Table Columns
        TableColumn<ViewReports, Integer> colCID = new TableColumn<>("CID");
        colCID.setCellValueFactory(new PropertyValueFactory<>("cid"));
        colCID.setMinWidth(50);

        TableColumn<ViewReports, String> colName = new TableColumn<>("NAME");
        colName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colName.setMinWidth(150);

        TableColumn<ViewReports, String> colAddress = new TableColumn<>("ADDRESS");
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colAddress.setMinWidth(150);

        TableColumn<ViewReports, String> colGender = new TableColumn<>("GENDER");
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colGender.setMinWidth(50);

        TableColumn<ViewReports, String> colUnPhone = new TableColumn<>("PHONE");
        colUnPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colUnPhone.setMinWidth(50);

        TableColumn<ViewReports, String> colUnEmail = new TableColumn<>("EMAIL");
        colUnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colUnEmail.setMinWidth(50);

        TableColumn<ViewReports, String> colPw = new TableColumn<>("PASSWORD");
        colPw.setCellValueFactory(new PropertyValueFactory<>("pass_word"));
        colPw.setMinWidth(50);

        table1.getColumns().addAll(colCID, colName, colAddress, colGender, colUnPhone, colUnEmail, colPw);

        // Set data
        List<ViewReports> persons = allRecords();
        // Set persons to table1
        table1.getItems().addAll(persons);

        Button btnClose = new Button("Close");
        btnClose.setOnAction((event) -> {
            primaryStage.close();
        });

        VBox pane = new VBox();
        pane.getChildren().add(table1);
        pane.getChildren().add(btnClose);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);// set scene
        primaryStage.setTitle("All Person");// set title as All Person
        primaryStage.setWidth(1050);
        primaryStage.setHeight(350);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static ArrayList<ViewReports> allRecords() {
        // pid, fullName, address, gender, ageGroup, reading, playing, other, login_id, pass_word

        ArrayList<ViewReports> persons = new ArrayList<>();

        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String HOST = "localhost";
        int PORT = 3306;
        String DATABASE = "SMS";
        String DBUSER = "root";
        String DBPASS = "@arun123";
        String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
        String sql = "SELECT * FROM Customers";
        try {
            Class.forName(DRIVER); // loading driver
            Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);// connection with database server
            PreparedStatement pstat = conn.prepareStatement(sql);

            ResultSet rs = pstat.executeQuery();
            while (rs.next()) {
                int cid = rs.getInt("cid");
                String fullName = rs.getString("fullName");
                String address = rs.getString("address");
                String gender = rs.getString("gender");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String pass_word = rs.getString("pass_word");
                ViewReports person = new ViewReports(cid, fullName, address, gender, phone, email, pass_word);
                persons.add(person);
                System.out.println(person);
            }
            pstat.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return persons;
    }
}//end code
