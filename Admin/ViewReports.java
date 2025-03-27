package Admin;

public class ViewReports {
    private int cid;
    private String fullName;
    private String address;
    private String gender;
    private String phone;
    private String email;
    private String pass_word;

    public ViewReports() {
    }

    public ViewReports(int cid, String fullName, String address, String gender, String phone, String email, String pass_word) {
        this.cid = cid;
        this.fullName = fullName;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.pass_word = pass_word;
    }

    public int getCid() {
        return cid;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPass_word() {
        return pass_word;
    }
}
