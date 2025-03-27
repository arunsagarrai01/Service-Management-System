package Interface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Revenue extends Application {

    ComboBox<String> selectservice;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label lblServiceType = new Label("Service Type :");
        Label lblRevenue = new Label("Revenue :");
        Label lblTotalRevenue = new Label("Total Revenue:");

        selectservice = new ComboBox<>();
        selectservice.setItems(FXCollections.observableArrayList(
                "Plumber",
                "Electrician",
                "Cleaner"
        ));
        selectservice.setValue("Plumber");

        TextField txtRevenue = new TextField();
        TextField txtTotalRevenue = new TextField();

        Button btngenerate = new Button("Generate");
        btngenerate.setOnAction((event) -> {
            String service = selectservice.getValue();
            ServiceRequest serviceRequest = searchService(service);
            if (serviceRequest != null) {
                selectservice.setValue(serviceRequest.getServiceType());
                txtRevenue.setText(String.valueOf(serviceRequest.getRevenue()));
                txtTotalRevenue.setText(String.valueOf(serviceRequest.getTotalRevenue()));
                System.out.println("Record found");
            } else {
                System.out.println("Record not found");
            }
        });

        Button btnClose = new Button("Close");
        btnClose.setOnAction((event) -> {
            primaryStage.close(); //close the window
        });

        GridPane pane = new GridPane();
        pane.setConstraints(lblServiceType, 0, 0);//col, row
        pane.setConstraints(selectservice, 1, 0);
        pane.setConstraints(lblRevenue, 0, 1);
        pane.setConstraints(txtRevenue, 1, 1);
        pane.setConstraints(lblTotalRevenue, 0, 2);
        pane.setConstraints(txtTotalRevenue, 1, 2);

        pane.setConstraints(btngenerate, 1, 11);
        pane.setConstraints(btnClose, 2, 11);

        pane.getChildren().addAll(lblServiceType, selectservice, lblRevenue, txtRevenue, lblTotalRevenue, txtTotalRevenue, btngenerate, btnClose);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Revenue");
        primaryStage.setWidth(650);
        primaryStage.setHeight(450);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public ServiceRequest searchService(String service) {
        ServiceRequest serviceRequest = null;
        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String HOST = "localhost";
        int PORT = 3306;
        String DATABASE = "SMS";
        String DBUSER = "root";
        String DBPASS = "@arun123";
        String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
        String revenueQuery = "SELECT Services, SUM(Payment) as Revenue FROM ServicesRequested WHERE Services=? AND Status='Accepted'";
        String totalRevenueQuery = "SELECT SUM(Payment) as TotalRevenue FROM ServicesRequested";
        try {
            Class.forName(DRIVER);
            try (Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);
                 PreparedStatement revstat = conn.prepareStatement(revenueQuery);
                 PreparedStatement totalstat = conn.prepareStatement(totalRevenueQuery)) {
                revstat.setString(1, service);
                ResultSet rs = revstat.executeQuery();
                if (rs.next()) {
                    String serviceType = rs.getString("Services");
                    int revenue = rs.getInt("Revenue");
                    serviceRequest = new ServiceRequest(serviceType, revenue);
                }

                ResultSet totalRs = totalstat.executeQuery();
                if (totalRs.next()) {
                    int totalRevenue = totalRs.getInt("TotalRevenue");
                    if (serviceRequest != null) {
                        serviceRequest.setTotalRevenue(totalRevenue);
                    } else {
                        serviceRequest = new ServiceRequest(null, 0, totalRevenue);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return serviceRequest;
    }

    static class ServiceRequest {
        private String serviceType;
        private int revenue;
        private int totalRevenue;

        public ServiceRequest(String serviceType, int revenue) {
            this.serviceType = serviceType;
            this.revenue = revenue;
        }

        public ServiceRequest(String serviceType, int revenue, int totalRevenue) {
            this.serviceType = serviceType;
            this.revenue = revenue;
            this.totalRevenue = totalRevenue;
        }

        public String getServiceType() {
            return serviceType;
        }

        public void setServiceType(String serviceType) {
            this.serviceType = serviceType;
        }

        public int getRevenue() {
            return revenue;
        }

        public void setRevenue(int revenue) {
            this.revenue = revenue;
        }

        public int getTotalRevenue() {
            return totalRevenue;
        }

        public void setTotalRevenue(int totalRevenue) {
            this.totalRevenue = totalRevenue;
        }
    }
}
