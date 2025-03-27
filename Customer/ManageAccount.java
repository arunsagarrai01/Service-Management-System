package Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ManageAccount extends Application{    
    
    public static void main(String[] args) {
        launch(args);//calling start
    }

    @Override
    public void start(Stage primaryStage) throws Exception {        
        Label lblCID = new Label("Customer ID : ");// Set label for CID
        Label lblFullName = new Label("Full Name : ");// Set label for FullName
        Label lblAddress = new Label("Address : ");// Set label for Address
        Label lblGender = new Label("Gender : ");// Set label for Gender
        Label lblEmail = new Label("Email : ");//Set label for Email
        Label lblPhoneNumber = new Label("Phone Number : ");// Set label for PhoneNumber
        Label lblLoginPassword = new Label("Login Password : ");// Set label for LoginPassword
        
        TextField txtCID = new TextField();// Set text field for CID
        TextField txtFullName = new TextField();// Set text field for FullName
        TextArea txtAddress = new TextArea();// Set text field for Address
        TextField txtGender = new TextField();// Set text field for Gender
        TextArea txtPhoneNumber = new TextArea();// Set text field for PhoneNumber
        TextField txtEmail = new TextField();////Set text field for Email
        TextField txtLoginPassword = new TextField();//Set text field for LoginPassword
        
        RadioButton rbMale=new RadioButton("Male");// Radio button created to define whether the customer is male or female
        RadioButton rbFemale=new RadioButton("Female");
        ToggleGroup genderGroup = new ToggleGroup();
        rbMale.setToggleGroup(genderGroup);
        rbFemale.setToggleGroup(genderGroup);
        
        Button btnSearch=new Button("Search");
        btnSearch.setOnAction((event)->{// Setting action for Search button
            //Reading values from UI
            int cid = Integer.parseInt(txtCID.getText());//String->int            
            Customer customer= searchRecord(cid);                        
            if(customer!=null) {
                //cid, fullName, address, gender,  phone, email, password
                //Display all values
                txtFullName.setText(customer.getFullname());
                txtAddress.setText(customer.getAddress());
                txtPhoneNumber.setText(customer.getPhone());
                txtEmail.setText(customer.getEmail());
                
                //Gender
                if(customer.getGender().equals("Male")) {
                    rbMale.setSelected(true);
                }
                else {
                    rbFemale.setSelected(true);
                }                
                
                txtLoginPassword.setText(customer.getPass_word());
                
                System.out.println("Record found");// Printing Record found if record is found
            }
            else {
                System.out.println("Record not found");// Printing Record not found if record is not found
            }
        });
        
        Button btnUpdate=new Button("Update");
        btnUpdate.setOnAction((event)->{// setting action for update button
            //Reading values from UI
            int cid = Integer.parseInt(txtCID.getText());//string->int
            String fullName = txtFullName.getText();
            String address = txtAddress.getText();
            String gender ="Female";
            if(rbMale.isSelected()==true) {
                gender="Male";
            }           
            
            String phone = txtPhoneNumber.getText();
            String email = txtEmail.getText();
            String loginPass = txtLoginPassword.getText();
            
            Customer manageAccount=new Customer(cid, fullName, address, gender, phone, email, loginPass);            
            boolean res = updateRecord(manageAccount); //calling method
            if(res==true) {
                System.out.println("Record Updated Successfully");// Printing Record Updated Successfully
            }
            else {
                System.out.println("Error: to update record");// Printing 
            }
        });
        
        Button btnClose=new Button("Close");
        btnClose.setOnAction((event)->{
            primaryStage.close(); //close the window
        });
        
        GridPane pane = new GridPane();
        pane.setConstraints(lblCID, 0, 0);//set column and row place
        pane.setConstraints(txtCID, 1, 0);
        pane.setConstraints(lblFullName, 0, 1);
        pane.setConstraints(txtFullName, 1, 1);
        pane.setConstraints(lblAddress, 0, 2);
        pane.setConstraints(txtAddress, 1, 2);
        
        pane.setConstraints(lblGender, 0, 5);
        pane.setConstraints(rbMale, 1, 6);
        pane.setConstraints(rbFemale, 1, 7);
        
        pane.setConstraints(lblPhoneNumber, 0, 8);
        pane.setConstraints(txtPhoneNumber, 1, 8);
        
        pane.setConstraints(lblEmail, 0, 9);
        pane.setConstraints(txtEmail, 1, 9);
        
        pane.setConstraints(lblLoginPassword, 0, 10);
        pane.setConstraints(txtLoginPassword, 1, 10);
        
        pane.setConstraints(btnSearch, 0, 11);
        pane.setConstraints(btnUpdate, 1, 11);
        pane.setConstraints(btnClose, 2, 11);
        
        pane.getChildren().add(lblCID);//getting children
        pane.getChildren().add(txtCID);
        pane.getChildren().add(lblFullName);
        pane.getChildren().add(txtFullName);
        pane.getChildren().add(lblAddress);
        pane.getChildren().add(txtAddress);
        pane.getChildren().add(lblGender);
        pane.getChildren().add(rbMale);
        pane.getChildren().add(rbFemale);
        pane.getChildren().add(lblPhoneNumber);
        pane.getChildren().add(txtPhoneNumber);
        pane.getChildren().add(lblEmail);
        pane.getChildren().add(txtEmail);
        pane.getChildren().add(lblLoginPassword);
        pane.getChildren().add(txtLoginPassword);
        pane.getChildren().add(btnSearch);
        pane.getChildren().add(btnUpdate);
        pane.getChildren().add(btnClose);
        
        // Set background color
        pane.setStyle("-fx-background-color: #FFCCCC;"); // Light red color 
        
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);     // set scene   
        primaryStage.setTitle("Update Customer");// Setting window title as Update Customer
        primaryStage.setWidth(650);// Setting width of window 650 
        primaryStage.setHeight(450);// Setting height of window 450
        primaryStage.setResizable(false);
        primaryStage.show();// displaying window
    }
    public Customer searchRecord(int cid) {
        //cid, fullName, address, gender,phone, email, pass_word
        Customer customer = null;
        String DRIVER ="com.mysql.cj.jdbc.Driver";
        String HOST ="localhost";
        int PORT=3306;
        String DATABASE ="SMS";
        String DBUSER="root";
        String DBPASS="@arun123";
        String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
        String sql="SELECT * FROM Customers WHERE cid=?";
        try {
            Class.forName(DRIVER); //loading driver
            Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);//connection with database server
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setInt(1, cid);            
            ResultSet rs = pstat.executeQuery();
            while(rs.next()) {
                String fullName = rs.getString("fullName");
                String address = rs.getString("address");
                String gender = rs.getString("gender");
                String phone=rs.getString("phone");
                String email= rs.getString("email");
                String pass_word = rs.getString("pass_word");
                customer = new Customer(cid, fullName, address, gender, phone,email, pass_word);                
            }
            pstat.close();
            conn.close();            
        }
        catch(Exception ex) {
            System.out.println("Error : "+ex.getMessage());
        }
        return customer;
    }
    public boolean updateRecord(Customer manageAccount) {
        //cid, fullName, address, gender, phone number email, pass_word
        boolean result = false;
        String DRIVER ="com.mysql.cj.jdbc.Driver";
        String HOST ="localhost";
        int PORT=3306;
        String DATABASE ="SMS";
        String DBUSER="root";
        String DBPASS="@arun123";
        String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
        String sql="UPDATE Customers  SET fullName=?, address=?,  gender=?, phone=?, email=?, pass_word=? where cid=?";
        try {
            Class.forName(DRIVER); //loading driver
            Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);//connection with database server
            PreparedStatement pstat = conn.prepareStatement(sql);            
            pstat.setString(1, manageAccount.getFullname());
            pstat.setString(2, manageAccount.getAddress());
            pstat.setString(3, manageAccount.getGender());
            pstat.setString(4, manageAccount.getPhone());
            pstat.setString(5, manageAccount.getEmail());
            pstat.setString(6, manageAccount.getPass_word());
            pstat.setInt(7, manageAccount.getCid());
            pstat.executeUpdate();//Update Record
            pstat.close();
            conn.close();
            result=true;
        }
        catch(Exception ex) {
            System.out.println("Error : "+ex.getMessage());
        }
        return result;
    }
}
