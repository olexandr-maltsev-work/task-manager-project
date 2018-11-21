package academy.softserve.taskmanager.web;

import academy.softserve.taskmanager.dao.TaskDao;
import academy.softserve.taskmanager.entity.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TaskEdit")
public class TaskEdit extends HttpServlet {

    TaskDao taskDao;

    public TaskEdit() throws Exception {
        super();
        taskDao = new TaskDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String taskId = req.getParameter("taskId");
        Task task = null;
        try {
            if (taskId == null || taskId.isEmpty()) {
                task = new Task();
                task.setId(-1);
            } else {
                task = taskDao.getTaskById(Integer.parseInt(taskId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (task == null) {
            req.getRequestDispatcher("WEB-INF/view/404.jsp").forward(req, resp);
        } else {
            req.setAttribute("task", task);
            req.getRequestDispatcher("WEB-INF/view/taskEdit.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Task task = new Task();
        task.setId(Integer.parseInt(req.getParameter("id")));
        task.setDescription(req.getParameter("description"));
        System.out.println(task);
        try {
            if (task.getId() == -1) {
                taskDao.saveTask(task);
            } else {
                taskDao.updateTask(task);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(task);
        resp.sendRedirect("TaskServlet");
    }
}
