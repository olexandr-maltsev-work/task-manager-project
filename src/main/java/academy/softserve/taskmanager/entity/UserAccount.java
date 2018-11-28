package academy.softserve.taskmanager.entity;

import academy.softserve.taskmanager.security.PasswordEncryption;

public class UserAccount {

    private int id;
    private String email;
    private String password;
    private String userName;

    public UserAccount() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = PasswordEncryption.encryptWithMD5(password) ;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
