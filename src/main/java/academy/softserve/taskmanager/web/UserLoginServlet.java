package academy.softserve.taskmanager.web;

import academy.softserve.taskmanager.dao.UserAccountDao;
import academy.softserve.taskmanager.entity.dbo.UserAccount;
import academy.softserve.taskmanager.entity.dto.UserDTO;
import academy.softserve.taskmanager.security.UserSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        checkUserLoginDTO(request);
        UserDTO userDTO = (UserDTO) request.getAttribute("userdto");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String errorMessage = "";
        if (email != null && !email.isEmpty() && password != null && !password.isEmpty()) {
            userDTO.setEmail(email);
            userDTO.setPassword(password);

            try {
                errorMessage = validate(userDTO);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (!errorMessage.isEmpty()) {
                userDTO.setMessage(errorMessage);
                userDTO.setError(true);
                request.setAttribute("userDTO", userDTO);
                doGet(request, response);
            }

            try {
                UserAccount userAccount = userAccountDao.getUserAccount(email, password);
                if (userAccount != null) {
                    HttpSession session = request.getSession(true);
                    String userName = userAccount.getUserName();
                    session.setAttribute("userName", userName);
                    UserSession.addToSession(userAccount.getEmail(), request);
                }
                response.sendRedirect("TaskServlet");
            } catch (SQLException e) {
                e.printStackTrace();
                request.getRequestDispatcher("WEB-INF/view/404.jsp").forward(request, response);

            }
        } else {
            userDTO.setMessage(errorMessage);
            userDTO.setError(true);
            doGet(request, response);
        }
    }

    private String validate(UserDTO userDTO) throws SQLException {
        if (!userAccountDao.isUserExist(userDTO.getEmail())) {
            return "Email <b>" + userDTO.getEmail() + "</b> does not exist";
        }

        UserAccount userAccount = userAccountDao.getUserAccount(userDTO.getEmail(), userDTO.getPassword());
        if (userAccount == null) {
            return "Password is not correct";
        }
        return "";
    }

    private void checkUserLoginDTO(HttpServletRequest request) {
        if (request.getAttribute("userdto") == null) {
            UserDTO userDTO = new UserDTO();
            request.setAttribute("userdto", userDTO);
        }
    }
}
