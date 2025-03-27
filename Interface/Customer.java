package Interface;

public class Customer {

			int bid;
			String fullName;
			String address;
			String email;
			String phone_number;
			String gender;
			String login_id;
			String pass_word;
			
			public Customer() {
			
				this.bid = 0;
				this.fullName = "";
				this.address = "";
				this.email = "";
				this.phone_number = "";
				this.gender = "";
				this.login_id = "";
				this.pass_word = "";
			}
			
			public Customer(int bid, String fullName, String address, String email, String phone_number, String gender,
					String login_id, String pass_word) {
				this.bid = bid;
				this.fullName = fullName;
				this.address = address;
				this.email = email;
				this.phone_number = phone_number;
				this.gender = gender;
				this.login_id = login_id;
				this.pass_word = pass_word;
			}

			public int getBid() {
				return bid;
			}

			public void setBid(int bid) {
				this.bid = bid;
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
				return "Buyer [bid=" + bid + ", fullName=" + fullName + ", address=" + address + ", email=" + email
						+ ", phone_number=" + phone_number + ", gender=" + gender + ", login_id=" + login_id
						+ ", pass_word=" + pass_word + "]";
			}
			
			


			
			
			    
	
}
