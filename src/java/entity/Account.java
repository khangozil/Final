package entity;

/**
 *
 * @author ADMIN
 */
public class Account {

    private String acc_id;
    private String password;
    private String acc_name;
    private String phone;
    private String address;
    private String mail;
    private String gender;
    private int isAdmin;

    public Account() {
    }

    public Account(String acc_id, String password, String acc_name, String phone, String address, String mail, String gender, int isAdmin) {
        this.acc_id = acc_id;
        this.password = password;
        this.acc_name = acc_name;
        this.phone = phone;
        this.address = address;
        this.mail = mail;
        this.gender = gender;
        this.isAdmin = isAdmin;
    }

    public String getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(String acc_id) {
        this.acc_id = acc_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAcc_name() {
        return acc_name;
    }

    public void setAcc_name(String acc_name) {
        this.acc_name = acc_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

}
