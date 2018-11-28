package academy.softserve.taskmanager.main;

import academy.softserve.taskmanager.dao.TaskDao;
import academy.softserve.taskmanager.entity.Task;
import academy.softserve.taskmanager.security.PasswordEncryption;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String password = "password";
        String encryptedPassword = PasswordEncryption.encryptWithMD5(password);
        System.out.println(password + "\n"  + encryptedPassword);
    }
}
