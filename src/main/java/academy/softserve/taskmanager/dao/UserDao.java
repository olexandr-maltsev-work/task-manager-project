package academy.softserve.taskmanager.dao;

import academy.softserve.taskmanager.entity.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

    private Connection connection;

    public UserDao() throws SQLException, ClassNotFoundException {
        connection = new DBConnection().getConnection();
    }

    public void saveUserAccount(UserAccount userAccount) throws SQLException {
        String sql = "INSERT INTO user(email, password, user_name) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, userAccount.getEmail());
        preparedStatement.setString(2, userAccount.getPassword());
        preparedStatement.setString(3, userAccount.getUserName());
        preparedStatement.executeUpdate();
    }


}
