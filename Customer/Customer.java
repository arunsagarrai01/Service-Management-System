package Customer;

import java.time.LocalDate;

public class Customer {
    private int cid;
    private String fullname;
    private String address;  
    private String gender;
    private String phone;
    private String email;
    private String pass_word;
   

   public Customer(int cid, String fullname, String address, String gender, String phone, String email, String pass_word) {
        this.cid = cid;
        this.fullname = fullname;
        this.address = address;
        
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.pass_word = pass_word;
    
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

}