package Worker;
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

public class SearchWorker extends Application{	
	
	public static void main(String[] args) {
		//System.out.println("Hello");
		launch(args);//call start()
	}

	@Override
	public void start(Stage primaryStage) throws Exception {		
		Label lblWID = new Label("Worker ID : ");
		Label lblFullName = new Label("Full Name : ");
		Label lblAddress = new Label("Address : ");
		Label lblGender = new Label("Gender : ");
		Label lblEmail = new Label("Email : ");
		Label lblRole = new Label("Role : ");
		Label lblPhoneNumber = new Label("Phone Number : ");
		Label lblLoginPassword = new Label("Login Password : ");
		
		TextField txtWID = new TextField();
		TextField txtFullName = new TextField();
		TextArea txtAddress = new TextArea();
		TextField txtGender = new TextField();
		TextArea txtPhoneNumber = new TextArea();
		TextField txtEmail = new TextField();
		TextField txtRole = new TextField();
		TextField txtLoginPassword = new TextField();
		
		RadioButton rbMale=new RadioButton("Male");
		RadioButton rbFemale=new RadioButton("Female");
		ToggleGroup genderGroup = new ToggleGroup();
		rbMale.setToggleGroup(genderGroup);
		rbFemale.setToggleGroup(genderGroup);
		
		Button btnSearch=new Button("Search");
		btnSearch.setOnAction((event)->{
			//Reading values from UI
			int wid = Integer.parseInt(txtWID.getText());//String->int			
			Worker worker= searchRecord(wid);						
			if(worker!=null) {
				//aid, fullName, address, gender,  phone, email pass_word
				//Display all values
				txtFullName.setText(worker.getFullName());
				txtAddress.setText(worker.getAddress());
				txtPhoneNumber.setText(worker.getPhone_number());
				txtGender.setText(worker.getGender());
				txtRole.setText(worker.getRole());
				
				
				//Gender
				if(worker.getGender().equals("Male")) {
					rbMale.setSelected(true);
				}
				else {
					rbFemale.setSelected(true);
				}				
				
				
				txtLoginPassword.setText(worker.getPass_word());
				
				System.out.println("Record found");
			}
			else {
				System.out.println("Record not found");
			}
		});
		
		Button btnClose=new Button("Close");
		btnClose.setOnAction((event)->{
			primaryStage.close(); //close the window
		});
		
		GridPane pane = new GridPane();
		pane.setConstraints(lblWID, 0, 0);//col, row
		pane.setConstraints(txtWID, 1, 0);
		pane.setConstraints(lblFullName, 0, 1);
		pane.setConstraints(txtFullName, 1, 1);
		pane.setConstraints(lblAddress, 0, 2);
		pane.setConstraints(txtAddress, 1, 2);
		
		pane.setConstraints(lblPhoneNumber, 0, 3);
		pane.setConstraints(txtPhoneNumber, 1, 3);
		
		pane.setConstraints(lblGender, 0, 4);
		pane.setConstraints(rbMale, 1, 5);
		pane.setConstraints(rbFemale, 1, 6);
		
		pane.setConstraints(lblRole, 0, 7);
		pane.setConstraints(txtRole, 1, 7);
		
		pane.setConstraints(lblEmail, 0, 9);
		pane.setConstraints(txtEmail, 1, 9);
		
		pane.setConstraints(lblLoginPassword, 0, 10);
		pane.setConstraints(txtLoginPassword, 1, 10);
		
		pane.setConstraints(btnSearch, 1, 11);
		pane.setConstraints(btnClose, 2, 11);
		
		pane.getChildren().add(lblWID);
		pane.getChildren().add(txtWID);
		pane.getChildren().add(lblFullName);
		pane.getChildren().add(txtFullName);
		pane.getChildren().add(lblAddress);
		pane.getChildren().add(txtAddress);
		pane.getChildren().add(lblGender);
		pane.getChildren().add(rbMale);
		pane.getChildren().add(rbFemale);
		pane.getChildren().add(lblPhoneNumber);
		pane.getChildren().add(txtPhoneNumber);
		pane.getChildren().add(lblRole);
		pane.getChildren().add(txtRole);
		pane.getChildren().add(lblEmail);
		pane.getChildren().add(txtEmail);
		pane.getChildren().add(lblLoginPassword);
		pane.getChildren().add(txtLoginPassword);
		pane.getChildren().add(btnSearch);
		pane.getChildren().add(btnClose);
		
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);		
		primaryStage.setTitle("Search Worker Details");
		primaryStage.setWidth(650);
		primaryStage.setHeight(450);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	public Worker searchRecord(int wid) {
		//aid, fullName, address, gender,phone, email, pass_word
		Worker worker = null;
		String DRIVER ="com.mysql.cj.jdbc.Driver";
		String HOST ="localhost";
		int PORT=3306;
		String DATABASE ="SMS";
		String DBUSER="root";
		String DBPASS="@arun123";
		String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
		String sql="SELECT * FROM Workers WHERE wid=?";
		try {
			Class.forName(DRIVER); //loading driver
			Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);//connection with database server
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, wid);			
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				String fullName = rs.getString("fullName");
				String address = rs.getString("address");
				String gender = rs.getString("gender");
				String phone_number=rs.getString("phone_number");
				String roles= rs.getString("roles");
				String email= rs.getString("email");
				String pass_word = rs.getString("pass_word");
			    worker = new Worker(wid, fullName, address, gender, phone_number, roles, email, pass_word);				
			}
			pstat.close();
			conn.close();			
		}
		catch(Exception ex) {
			System.out.println("Error : "+ex.getMessage());
		}
		return worker;
	}
}