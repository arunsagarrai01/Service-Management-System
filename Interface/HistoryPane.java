package Interface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Interface.StaffDashboard.Request;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HistoryPane extends Application {

    public static void main(String[] args) {
        launch(args); // call start
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        TableView<Request> table1 = new TableView<>();
        table1.setPrefWidth(1000);// set width 1000 of table
        table1.setPrefHeight(250);// set height 250 of table

        // Table Columns
        TableColumn<Request, Integer> colCustomerID = new TableColumn<>("Customer ID");
        colCustomerID.setCellValueFactory(new PropertyValueFactory<>("cid"));
        colCustomerID.setMinWidth(50);

        TableColumn<Request, String> colName = new TableColumn<>("Name");
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colName.setMinWidth(150);

        TableColumn<Request, String> colTime = new TableColumn<>("Time");
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        colTime.setMinWidth(50);

        TableColumn<Request, String> colLocation = new TableColumn<>("Location");
        colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        colLocation.setMinWidth(50);

        table1.getColumns().addAll(colCustomerID, colName, colTime, colLocation);

        // set data
        List<Request> reqstats = new ArrayList<>();
        reqstats = allRecords();
        // set persons to table1
        for (Request reqstat : reqstats) {
            table1.getItems().add(reqstat);
        }

        Button btnClose = new Button("Close");
        btnClose.setOnAction((event) -> {
            primaryStage.close();
        });

        VBox pane = new VBox();
        pane.getChildren().add(table1);
        pane.getChildren().add(btnClose);

        Scene scene = new Scene(pane);
        scene.setFill(Color.LIME); // Set French lime background color
        primaryStage.setScene(scene);// set scene
        primaryStage.setTitle("Request History");// set window title as Request History
        primaryStage.setWidth(1050);// set width of window 1050
        primaryStage.setHeight(350);// set height of window 350
        primaryStage.setResizable(false);
        primaryStage.show();// display window
    }

    public ArrayList<Request> allRecords() {

        ArrayList<Request> reqstats = new ArrayList<>();

        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String HOST = "localhost";
        int PORT = 3306;
        String DATABASE = "SMS";
        String DBUSER = "root";
        String DBPASS = "@arun123";
        String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
        String sql = "SELECT CID, Name, Location, Time FROM Plumbing";

        try {
            Class.forName(DRIVER); // loading driver
            Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);// connection with database server
            PreparedStatement pstat = conn.prepareStatement(sql);

            ResultSet rs = pstat.executeQuery();
            while (rs.next()) {

                String cid = rs.getString("CID");
                String name = rs.getString("Name");
                String time = rs.getString("Time");
                String location = rs.getString("Location");

                Request reqstat = new Request(cid, name, time, location);
                reqstats.add(reqstat);

            }
            pstat.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return reqstats;
    }
}// end code
