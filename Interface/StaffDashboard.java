package Interface;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDashboard extends Application {

    private TableView<Request> tableView; // TableView to display requests

    @Override
    public void start(Stage primaryStage) {
        Label lblRequests = new Label("Requests:");

        tableView = new TableView<>();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setPrefWidth(400);

        TableColumn<Request, String> cidCol = new TableColumn<>("CID");
        cidCol.setCellValueFactory(new PropertyValueFactory<>("cid"));

        TableColumn<Request, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Request, String> locationCol = new TableColumn<>("Location");
        locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));

        TableColumn<Request, String> timeCol = new TableColumn<>("Time");
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));

        tableView.getColumns().addAll(cidCol, nameCol, locationCol, timeCol);

        // setting button actions
        Button btnRefresh = new Button("Refresh");
        btnRefresh.setOnAction(event -> refreshRequests());

        Button btnAccept = new Button("Accept Request");
        btnAccept.setOnAction(event -> acceptRequest());

        Button btnHistory = new Button("History");
        btnHistory.setOnAction(event -> showHistoryPane());

        GridPane pane = new GridPane();
        pane.setVgap(10);// set vertical grid pane
        pane.setHgap(10);// set horizontal grid pane
        pane.add(lblRequests, 0, 0);
        pane.add(tableView, 0, 1, 2, 1); // Span over 2 columns
        pane.add(btnRefresh, 0, 2);
        pane.add(btnAccept, 1, 2);
        pane.add(btnHistory, 2, 2);

        // Apply forest green background color
        VBox root = new VBox();
        root.setStyle("-fx-background-color: forestgreen;");

        root.getChildren().addAll(pane);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Staff Dashboard");
        primaryStage.show();

        // Load requests initially
        refreshRequests();
    }

    private void refreshRequests() {
        try {
            List<Request> requests = fetchRequestsFromDatabase(); // Fetch requests from database
            tableView.getItems().clear();
            tableView.getItems().addAll(requests);
        } catch (SQLException ex) {
            showAlert("Error", "Failed to refresh requests: " + ex.getMessage());
        }
    }

    private List<Request> fetchRequestsFromDatabase() throws SQLException {
        List<Request> requests = new ArrayList<>();
        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String HOST = "localhost";
        int PORT = 3306;
        String DATABASE = "SMS";
        String DBUSER = "root";
        String DBPASS = "@arun123";
        String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;

        String electricalRepairsSql = "SELECT * FROM ElectricalRepairs"; // SQL query for ElectricalRepairs table
        String plumbingSql = "SELECT * FROM Plumbing"; // SQL query for Plumbing table
        String cleanerSql = "SELECT * FROM Cleaner"; // SQL query for Cleaner table

        try (Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);
             PreparedStatement electricalRepairsStmt = conn.prepareStatement(electricalRepairsSql);
             PreparedStatement plumbingStmt = conn.prepareStatement(plumbingSql);
             PreparedStatement cleanerStmt = conn.prepareStatement(cleanerSql);
             ResultSet electricalRepairsRs = electricalRepairsStmt.executeQuery();
             ResultSet plumbingRs = plumbingStmt.executeQuery();
             ResultSet cleanerRs = cleanerStmt.executeQuery()) {

            // Fetch ElectricalRepairs requests
            while (electricalRepairsRs.next()) {
                Request electricalRepair = new Request(
                        electricalRepairsRs.getString("CID"),
                        electricalRepairsRs.getString("Name"),
                        electricalRepairsRs.getString("Location"),
                        electricalRepairsRs.getString("Time")
                );
                requests.add(electricalRepair); // Add the ElectricalRepairs request to the list
            }

            // Fetch Plumbing requests
            while (plumbingRs.next()) {
                Request plumbingRequest = new Request(
                        plumbingRs.getString("CID"),
                        plumbingRs.getString("Name"),
                        plumbingRs.getString("Location"),
                        plumbingRs.getString("Time")
                );
                requests.add(plumbingRequest); // Add the Plumbing request to the list
            }

            // Fetch Cleaner requests
            while (cleanerRs.next()) {
                Request cleanerRequest = new Request(
                        cleanerRs.getString("CID"),
                        cleanerRs.getString("Name"),
                        cleanerRs.getString("Location"),
                        cleanerRs.getString("Time")
                );
                requests.add(cleanerRequest); // Add the Cleaner request to the list
            }
        }

        return requests;
    }

    private void acceptRequest() {
        // Get the selected request from the table view
        Request selectedRequest = tableView.getSelectionModel().getSelectedItem();

        if (selectedRequest != null) {
            // You can implement the logic here to handle accepting the request.
            // For example, you might want to update the status of the request in the database.
            // Once the request is accepted, you can remove it from the table view and refresh the view.

            try {
                // Perform database update or any other actions to accept the request

                // For demonstration purposes, let's assume we simply remove the request from the table view
                tableView.getItems().remove(selectedRequest);

                showAlert("Success", "Request accepted successfully.");
            } catch (Exception e) {
                showAlert("Error", "Failed to accept request: " + e.getMessage());
            }
        } else {
            showAlert("No Selection", "Please select a request to accept.");
        }
    }

    private void showHistoryPane() {
        HistoryPane historyPane = new HistoryPane(); // Create an instance of HistoryPane
        try {
			historyPane.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Launch HistoryPane
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static class Request {
        private final String cid;
        private final String name;
        private final String location;
        private final String time;

        public Request(String cid, String name, String location, String time) {
            this.cid = cid;
            this.name = name;
            this.location = location;
            this.time = time;
        }

        public String getCid() {
            return cid;
        }

        public String getName() {
            return name;
        }

        public String getLocation() {
            return location;
        }

        public String getTime() {
            return time;
        }
    }
}// end code
