package Interface;

public class Staff {

			int sid;
			String fullName;
			String address;
			String email;
			String phone_number;
			String gender;
			String role;
			String login_id;
			String pass_word;
			
			public Staff(int sid2, String fullName2, String address2, String phone, String gender2, String roles, String email2, String loginPass) {
			
				this.sid = 0;
				this.fullName = "";
				this.address = "";
				this.email = "";
				this.phone_number = "";
				this.gender = "";
				this.role = "";
				this.login_id = "";
				this.pass_word = "";
			}
			
			public Staff(int sid, String fullName, String address, String email, String phone_number, String gender,
					 String role, String login_id, String pass_word) {
				this.sid = sid;
				this.fullName = fullName;
				this.address = address;
				this.email = email;
				this.phone_number = phone_number;
				this.gender = gender;
				this.role = role;
				this.login_id = login_id;
				this.pass_word = pass_word;
			}

			public int getSid() {
				return sid;
			}

			public void setSid(int sid) {
				this.sid = sid;
			}

			public String getFullName() {
				return fullName;
			}

			public void setFullName(String fullName) {
				this.fullName = fullName;
			}

			public String getAddress() {
				return address;
			}

			public void setAddress(String address) {
				this.address = address;
			}

			public String getEmail() {
				return email;
			}

			public void setEmail(String email) {
				this.email = email;
			}

			public String getPhone_number() {
				return phone_number;
			}

			public void setPhone_number(String phone_number) {
				this.phone_number = phone_number;
			}

			public String getGender() {
				return gender;
			}

			public void setGender(String gender) {
				this.gender = gender;
			}
			
			public String getOperator() {
				return role;
			}

			public void setOperator(String gender) {
				this.role = role;
			}
			
			public String getLogin_id() {
				return login_id;
			}

			public void setLogin_id(String login_id) {
				this.login_id = login_id;
			}

			public String getPass_word() {
				return pass_word;
			}

			public void setPass_word(String pass_word) {
				this.pass_word = pass_word;
			}

			@Override
			public String toString() {
				return "Buyer [sid=" + sid + ", fullName=" + fullName + ", address=" + address + ", email=" + email
						+ ", phone_number=" + phone_number + ", gender=" + gender + ", role=" + role + ", login_id=" + login_id
						+ ", pass_word=" + pass_word + "]";
			}

			public String getRole() {
				// TODO Auto-generated method stub
				return null;
			}
			
			


			
			
			    
	
}
