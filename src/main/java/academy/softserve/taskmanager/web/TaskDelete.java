package academy.softserve.taskmanager.web;

import academy.softserve.taskmanager.dao.TaskDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/TaskDelete")
public class TaskDelete extends HttpServlet {

    private TaskDao taskDao;

    public TaskDelete() throws Exception {
        super();
        taskDao = new TaskDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String taskId = req.getParameter("taskId");
        if (taskId == null || taskId.isEmpty()) {
            req.getRequestDispatcher("WEB-INF/view/404.jsp").forward(req, resp);
        } else {
            try {
                taskDao.deleteTask(Integer.parseInt(taskId));

            } catch (SQLException e) {
                req.getRequestDispatcher("WEB-INF/view/404.jsp").forward(req, resp);
            }
            resp.sendRedirect("tasks");
        }
    }
}
