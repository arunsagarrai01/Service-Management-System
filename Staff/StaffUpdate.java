package Staff;

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

public class StaffUpdate extends Application{	
	
	public static void main(String[] args) {
		//System.out.println("Hello");
		launch(args);//call start()
	}

	@Override
	public void start(Stage primaryStage) throws Exception {		
		Label lblSID = new Label("Staff ID : ");
		Label lblFullName = new Label("Full Name : ");
		Label lblAddress = new Label("Address : ");
		Label lblPhoneNumber = new Label("Phone Number : ");
		Label lblGender = new Label("Gender : ");
		Label lblRoles = new Label("Roles : ");
		Label lblEmail = new Label("Email : ");
		Label lblLoginPassword = new Label("Login Password : ");
		
		TextField txtSID = new TextField();
		TextField txtFullName = new TextField();
		TextArea txtAddress = new TextArea();
		TextArea txtPhoneNumber = new TextArea();
		TextField txtGender = new TextField();
		TextArea txtRoles = new TextArea();
		TextField txtEmail = new TextField();
		TextField txtLoginPassword = new TextField();
		
		RadioButton rbMale=new RadioButton("Male");
		RadioButton rbFemale=new RadioButton("Female");
		ToggleGroup genderGroup = new ToggleGroup();
		rbMale.setToggleGroup(genderGroup);
		rbFemale.setToggleGroup(genderGroup);
		
		Button btnSearch=new Button("Search");
		btnSearch.setOnAction((event)->{
			//Reading values from UI
			int sid = Integer.parseInt(txtSID.getText());//String->int			
			Staff staff= searchRecord(sid);						
			if(staff!=null) {
				//sid, fullName, address, gender,  phone, email pass_word
				//Display all values
				txtFullName.setText(staff.getFullName());
				txtAddress.setText(staff.getAddress());
				txtPhoneNumber.setText(staff.getPhone_number());
				txtRoles.setText(staff.getRole());
				txtEmail.setText(staff.getEmail());
				
				//Gender
				if(staff.getGender().equals("Male")) {
					rbMale.setSelected(true);
				}
				else {
					rbFemale.setSelected(true);
				}				
				
				
				txtLoginPassword.setText(staff.getPass_word());
				
				System.out.println("Record found");
			}
			else {
				System.out.println("Record not found");
			}
		});
		
		Button btnUpdate=new Button("Update");
		btnUpdate.setOnAction((event)->{
			//Reading values from UI
			int sid = Integer.parseInt(txtSID.getText());//string->int
			String fullName = txtFullName.getText();
			String address = txtAddress.getText();
			String gender ="Female";
			if(rbMale.isSelected()==true) {
				gender="Male";
			}			
			
			String phone = txtPhoneNumber.getText();
			String roles = txtRoles.getText();
			String email = txtEmail.getText();
			String loginPass = txtLoginPassword.getText();
			
			Staff staff=new Staff(sid, fullName, address, phone, gender, roles, email, loginPass);			
			boolean res = updateRecord(staff); //call method
			if(res==true) {
				System.out.println("Record Updated Successfully");
			}
			else {
				System.out.println("Error: to update record");
			}
		});
		
		Button btnClose=new Button("Close");
		btnClose.setOnAction((event)->{
			primaryStage.close(); //close the window
		});
		
		GridPane pane = new GridPane();
		pane.setConstraints(lblSID, 0, 0);//col, row
		pane.setConstraints(txtSID, 1, 0);
		pane.setConstraints(lblFullName, 0, 1);
		pane.setConstraints(txtFullName, 1, 1);
		pane.setConstraints(lblAddress, 0, 2);
		pane.setConstraints(txtAddress, 1, 2);
		
		pane.setConstraints(lblPhoneNumber, 0, 3);
		pane.setConstraints(txtPhoneNumber, 1, 3);
		
		pane.setConstraints(lblGender, 0, 4);
		pane.setConstraints(rbMale, 1, 5);
		pane.setConstraints(rbFemale, 1, 6);
		
		pane.setConstraints(lblRoles, 0, 7);
		pane.setConstraints(txtRoles, 1, 7);
		
		pane.setConstraints(lblEmail, 0, 9);
		pane.setConstraints(txtEmail, 1, 9);
		
		pane.setConstraints(lblLoginPassword, 0, 10);
		pane.setConstraints(txtLoginPassword, 1, 10);
		
		pane.setConstraints(btnSearch, 0, 11);
		pane.setConstraints(btnUpdate, 1, 11);
		pane.setConstraints(btnClose, 2, 11);
		
		pane.getChildren().add(lblSID);
		pane.getChildren().add(txtSID);
		pane.getChildren().add(lblFullName);
		pane.getChildren().add(txtFullName);
		pane.getChildren().add(lblAddress);
		pane.getChildren().add(txtAddress);
		pane.getChildren().add(lblPhoneNumber);
		pane.getChildren().add(txtPhoneNumber);
		pane.getChildren().add(lblGender);
		pane.getChildren().add(rbMale);
		pane.getChildren().add(rbFemale);
		pane.getChildren().add(lblRoles);
		pane.getChildren().add(txtRoles);
		pane.getChildren().add(lblEmail);
		pane.getChildren().add(txtEmail);
		pane.getChildren().add(lblLoginPassword);
		pane.getChildren().add(txtLoginPassword);
		pane.getChildren().add(btnSearch);
		pane.getChildren().add(btnUpdate);
		pane.getChildren().add(btnClose);
		
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);		
		primaryStage.setTitle("Update Staff");
		primaryStage.setWidth(650);
		primaryStage.setHeight(450);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	public Staff searchRecord(int sid) {
		//sid, fullName, address, gender,phone, email, pass_word
		Staff staff = null;
		String DRIVER ="com.mysql.cj.jdbc.Driver";
		String HOST ="localhost";
		int PORT=3306;
		String DATABASE ="SMS";
		String DBUSER="root";
		String DBPASS="@arun123";
		String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
		String sql="SELECT * FROM Staffs WHERE sid=?";
		try {
			Class.forName(DRIVER); //loading driver
			Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);//connection with database server
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, sid);			
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				String fullName = rs.getString("fullName");
				String address = rs.getString("address");
				String phone_number=rs.getString("phone_number");
				String gender = rs.getString("gender");
				String roles=rs.getString("roles");
				String email= rs.getString("email");
				String pass_word = rs.getString("pass_word");
				staff = new Staff(sid, fullName, address, phone_number, gender, roles, email, pass_word);				
			}
			pstat.close();
			conn.close();			
		}
		catch(Exception ex) {
			System.out.println("Error : "+ex.getMessage());
		}
		return staff;
	}
	public boolean updateRecord(Staff staff) {
		//sid, fullName, address, gender, phone number email, pass_word
		boolean result = false;
		String DRIVER ="com.mysql.cj.jdbc.Driver";
		String HOST ="localhost";
		int PORT=3306;
		String DATABASE ="SMS";
		String DBUSER="root";
		String DBPASS="@arun123";
		String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
		String sql="UPDATE Staffs  SET fullName=?, address=?, phone_number=?, gender=?, roles=?, email=?, pass_word=? where sid=?";
		try {
			Class.forName(DRIVER); //loading driver
			Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);//connection with database server
			PreparedStatement pstat = conn.prepareStatement(sql);			
			pstat.setString(1, staff.getFullName());
			pstat.setString(2, staff.getAddress());
			pstat.setString(3, staff.getPhone_number());
			pstat.setString(4, staff.getGender());
			pstat.setString(5, staff.getRole());
			pstat.setString(6, staff.getEmail());
			pstat.setString(7, staff.getPass_word());
			pstat.setInt(8, staff.getSid());
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