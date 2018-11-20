package academy.softserve.taskmanager.web;

import academy.softserve.taskmanager.dao.TaskDao;
import academy.softserve.taskmanager.entity.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/tasks")
public class TaskServlet extends HttpServlet {

    TaskDao taskDao;

    public TaskServlet() {
        super();
        try {
            taskDao = new TaskDao();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Task> tasks = new ArrayList<>();
        try {
            tasks.addAll(taskDao.getAllTasks());
            for (Task task: tasks) {
                System.out.println(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("tasks", tasks);
        request.getRequestDispatcher("WEB-INF/view/tasks.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
