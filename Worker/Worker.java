package Worker;

public class Worker {

			int wid;
			String fullName;
			String address;
			String phone_number;
			String gender;
			String role;
			String email;
			String pass_word;
			public Worker(int wid, String fullName, String address, String phone_number, String gender, String role,
					String email, String pass_word) {
				super();
				this.wid = wid;
				this.fullName = fullName;
				this.address = address;
				this.phone_number = phone_number;
				this.gender = gender;
				this.role = role;
				this.email = email;
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
			public String getRole() {
				return role;
			}
			public void setRole(String role) {
				this.role = role;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public String getPass_word() {
				return pass_word;
			}
			public void setPass_word(String pass_word) {
				this.pass_word = pass_word;
			}
			@Override 
			public String toString() {
				return "Worker [wid=" + wid + ", fullName=" + fullName + ", address=" + address + ", phone_number="
						+ phone_number + ", gender=" + gender + ", role=" + role + ", email=" + email + ", pass_word="
						+ pass_word + "]";
			}
		
		
			

			
			


			
			
			    
	
}
