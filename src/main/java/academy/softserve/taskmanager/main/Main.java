package academy.softserve.taskmanager.main;

import academy.softserve.taskmanager.dao.TaskDao;
import academy.softserve.taskmanager.entity.Task;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        TaskDao taskDao = new TaskDao();
        Task task = new Task();
        task.setId(3);
        task.setDescription("Cool Task");
        try {
            taskDao.saveTask(task);

            List<Task> allTasks = taskDao.getAllTasks();
            System.out.println(allTasks.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
