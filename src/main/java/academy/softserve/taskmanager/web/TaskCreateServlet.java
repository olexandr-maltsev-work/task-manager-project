package academy.softserve.taskmanager.web;

import academy.softserve.taskmanager.dao.TaskDao;
import academy.softserve.taskmanager.entity.dbo.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/TaskCreateServlet")
public class TaskCreateServlet extends HttpServlet {

    private TaskDao taskDao;

    public TaskCreateServlet() throws Exception {
        super();
        taskDao = new TaskDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        Task task = new Task();
        try {
            if (description == null || description.isEmpty()) {
                req.getRequestDispatcher("WEB-INF/view/404.jsp").forward(req, resp);
            } else {
                int id = taskDao.getNewId();
                task.setId(id);
                task.setDescription(description);
                taskDao.saveTask(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("TaskServlet");
    }
}
