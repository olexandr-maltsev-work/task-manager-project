package academy.softserve.taskmanager.dao;

import academy.softserve.taskmanager.entity.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDao {

    private Connection connection;

    public TaskDao() {
        connection = new DBConnection().getConnection();
    }

    public void saveTask(Task task) throws SQLException {
        String sql = "INSERT INTO task(id, description) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, task.getId());
        preparedStatement.setString(2, task.getDescription());
    }

    public List<Task> getAllTasks() throws SQLException {
        List<Task> result = new ArrayList<>();
        String sql = "SELECT id, description FROM task";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Task task = new Task();
            task.setId(resultSet.getInt(1));
            task.setDescription(resultSet.getString(2));
            result.add(task);
        }
        return result;
    }

}
