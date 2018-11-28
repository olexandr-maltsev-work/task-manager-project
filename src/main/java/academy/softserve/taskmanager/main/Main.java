package academy.softserve.taskmanager.main;

import academy.softserve.taskmanager.security.PasswordEncryption;


public class Main {
    public static void main(String[] args) {
        String password = "password";
        String encryptedPassword = PasswordEncryption.encryptWithMD5(password);
        System.out.println(password + "\n"  + encryptedPassword);
    }
}
