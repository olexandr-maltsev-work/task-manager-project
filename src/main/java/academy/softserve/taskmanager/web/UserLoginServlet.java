package academy.softserve.taskmanager.web;

import academy.softserve.taskmanager.dao.UserAccountDao;
import academy.softserve.taskmanager.entity.UserAccount;
import academy.softserve.taskmanager.security.UserSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {

    private UserAccountDao userAccountDao;

    public UserLoginServlet() throws SQLException, ClassNotFoundException {
        userAccountDao = new UserAccountDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (email != null && !email.isEmpty() && password != null && !password.isEmpty()) {
            try {
                UserAccount userAccount = userAccountDao.getUserAccount(email, password);
                if (userAccount != null) {
                    UserSession.addToSession(userAccount.getEmail(), request);
                }

                response.sendRedirect("TaskServlet");
            } catch (SQLException e) {
                e.printStackTrace();
                request.getRequestDispatcher("WEB-INF/view/404.jsp").forward(request, response);

            }
        }
    }

}
