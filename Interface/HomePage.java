package Interface;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class HomePage extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label lblIdentify = new Label("Identify who you are."); // adding label to identify whether the person is customer, staff or admin

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Customer", "Staff", "Admin");
        comboBox.setValue("Choose Who are you"); // to do default selection Combo box is created

        Button btnConfirm = new Button("Confirm"); // confirm  button created
        Button btnClose = new Button("Close"); //close button  created

        //  Button Customer Registration created
        Button btnCustomerRegistrations = new Button("Customer Registration");

        btnConfirm.setOnAction((event) -> {// setting action for confirm button
            String selectedRole = comboBox.getValue();
            // Handle further actions based on the selected role
            System.out.println("Selected Role: " + selectedRole);
            if (selectedRole.equals("Staff")) {
                StaffLogin staffLogin = new StaffLogin();
                try {
                    staffLogin.start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (selectedRole.equals("Customer")) {
                CustomerLogin customerLogin = new CustomerLogin();
                try {
                    customerLogin.start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (selectedRole.equals("Admin")) {
                AdminLogin adminLogin = new AdminLogin();
                try {
                    adminLogin.start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnCustomerRegistrations.setOnAction((event) -> {
            //Customer Registration form Run 
            CustomerRegistrations customerRegistrations = new CustomerRegistrations();
            try {
                customerRegistrations.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        btnClose.setOnAction((event) -> {
            primaryStage.close(); // Closes the window when close button is clicked
        });

        GridPane pane = new GridPane();
        pane.add(lblIdentify, 0, 0); // identify button place set
        pane.add(comboBox, 0, 1); // Combobox place set
        pane.add(btnConfirm, 0, 2); // button confirm place set
        pane.add(btnClose, 1, 2); // button close place set
        pane.add(btnCustomerRegistrations, 0, 5); // customer registration button place set

        // background color set of the scene
        pane.setStyle("-fx-background-color: skyblue;");

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene); // scene set
        primaryStage.setTitle("Identification Page"); // title set as Identification Page
        primaryStage.setWidth(650); // window width 650 set 
        primaryStage.setHeight(450); // window height 450 set
        primaryStage.setResizable(false);
        primaryStage.show(); // shows window

    }

    public static void main(String[] args) { // main method
        launch(args);
    }
}// ends code
