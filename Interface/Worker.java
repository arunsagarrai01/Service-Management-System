package Interface;

public class Worker {

			int wid;
			String fullName;
			String address;
			String email;
			String phone_number;
			String gender;
			String role;
			String plumber;
			String electrician;
			String cleaner;
			String login_id;
			String pass_word;
			
			public Worker() {
			
				this.wid = 0;
				this.fullName = "";
				this.address = "";
				this.email = "";
				this.phone_number = "";
				this.gender = "";
				this.role = "";
				this.login_id = "";
				this.pass_word = "";
			}
			
			public Worker(int wid, String fullName, String address, String email, String phone_number, String gender,
					String role, String login_id, String pass_word) {
				this.wid = wid;
				this.fullName = fullName;
				this.address = address;
				this.email = email;
				this.phone_number = phone_number;
				this.gender = gender;
				this.role = role;
				this.login_id = login_id;
				this.pass_word = pass_word;
			}

			public int getWid() {
				return wid;
			}

			public void setWid(int wid) {
				this.wid = wid;
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
			
			public void setRole(String role) {
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
				return "Buyer [wid=" + wid + ", fullName=" + fullName + ", address=" + address + ", email=" + email
						+ ", phone_number=" + phone_number + ", gender=" + gender + ", role=" + role + ", login_id=" + login_id
						+ ", pass_word=" + pass_word + "]";
			}
			
			


			
			
			    
	
}
