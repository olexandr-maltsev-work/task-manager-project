package academy.softserve.taskmanager.dao;

import academy.softserve.taskmanager.entity.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAccountDao {

    private Connection connection;

    public UserAccountDao() throws SQLException, ClassNotFoundException {
        connection = new DBConnection().getConnection();
    }

    public void createUserAccount(UserAccount userAccount) throws SQLException {
        String sql = "INSERT INTO userAccount(email, password, user_name) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, userAccount.getEmail());
        preparedStatement.setString(2, userAccount.getPassword());
        preparedStatement.setString(3, userAccount.getUserName());
        preparedStatement.executeUpdate();
    }

    public UserAccount getUserAccount(String email, String password) throws SQLException {
        String sql = "SELECT id, email, password, user_name FROM userAccount where email = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            UserAccount userAccount = new UserAccount();
            userAccount.setId(resultSet.getInt(1));
            userAccount.setEmail(resultSet.getString(2));
            userAccount.setPassword(resultSet.getString(3));
            userAccount.setUserName(resultSet.getString(4));
            return userAccount;
        }
        return null;
    }

    public boolean isUserExist(String email) throws SQLException {
        String sql = "SELECT id FROM userAccount where email = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

}
