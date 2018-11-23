package academy.softserve.taskmanager.web;

import academy.softserve.taskmanager.dao.UserAccountDao;
import academy.softserve.taskmanager.entity.UserAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/UserRegistration")
public class UserRegistrationServlet extends HttpServlet {

    private UserAccountDao userAccountDao;

    public UserRegistrationServlet() throws SQLException, ClassNotFoundException {
        userAccountDao = new UserAccountDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/view/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String userName = req.getParameter("userName");
        if (email != null && password != null && password.equals(confirmPassword)) {
            UserAccount userAccount = new UserAccount();
            userAccount.setEmail(email);
            userAccount.setPassword(password);
            userAccount.setUserName(userName);
            //todo create validation service for user account
            //todo create warning page - this email exist
            try {
                userAccountDao.createUserAccount(userAccount);
            } catch (SQLException e) {
                e.printStackTrace();
                req.getRequestDispatcher("WEB-INF/view/404.jsp").forward(req, resp);
            }
            resp.sendRedirect("TaskServlet");
        } else {
            req.getRequestDispatcher("WEB-INF/view/register.jsp").forward(req, resp);
        }
    }
}
