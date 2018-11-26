package academy.softserve.taskmanager.web;

import academy.softserve.taskmanager.entity.UserAccount;
import academy.softserve.taskmanager.security.UserSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LogOutServlet")
public class LogOutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            String userName = (String) session.getAttribute("user");
            UserSession.clearSession(userName);
            session.invalidate();
        }
        req.getRequestDispatcher("WEB-INF/view/goodbye.jsp").forward(req, resp);
    }
}
