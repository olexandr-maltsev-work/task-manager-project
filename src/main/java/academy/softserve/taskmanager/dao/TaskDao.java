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
        preparedStatement.executeUpdate();
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

    public Task getTaskById(int taskId) throws SQLException {
        String sql = "SELECT id, description FROM task WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, taskId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Task task = new Task();
            task.setId(resultSet.getInt(1));
            task.setDescription(resultSet.getString(2));
            return task;
        }
        return null;
    }

    public int getNewId() throws SQLException {
        String sql = "SELECT COALESCE (MAX(id), 0) + 1 FROM task";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return -1;
    }

    public void deleteTask(int itemId) throws SQLException {
        String sql = "DELETE FROM task WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, itemId);
        preparedStatement.executeUpdate();
    }

    public void updateTask(Task task) throws SQLException {
        Task exist = getTaskById(task.getId());
        task.setDescription(task.getDescription());
        deleteTask(task.getId());
        saveTask(exist);
    }
}
