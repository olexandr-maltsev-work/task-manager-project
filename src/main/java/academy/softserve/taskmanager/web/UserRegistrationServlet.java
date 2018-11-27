package academy.softserve.taskmanager.web;

import academy.softserve.taskmanager.dao.UserAccountDao;
import academy.softserve.taskmanager.entity.UserAccount;
import academy.softserve.taskmanager.entity.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/UserRegistrationServlet")
public class UserRegistrationServlet extends HttpServlet {

    private UserAccountDao userAccountDao;

    public UserRegistrationServlet() throws SQLException, ClassNotFoundException {
        userAccountDao = new UserAccountDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        checkUserDTO(req);
        UserDTO userDTO = (UserDTO) req.getAttribute("userdto");
        req.getRequestDispatcher("WEB-INF/view/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        checkUserDTO(req);
        UserDTO userDTO = (UserDTO) req.getAttribute("userdto");
        userDTO.setEmail(req.getParameter("email"));
        userDTO.setPassword(req.getParameter("password"));
        userDTO.setConfirmPassword(req.getParameter("confirmPassword"));
        userDTO.setName(req.getParameter("userName"));

        String errorMessage = "";
        try {
            errorMessage = validate(userDTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (errorMessage.isEmpty()) {
            UserAccount userAccount = new UserAccount();
            userAccount.setEmail(userDTO.getEmail());
            userAccount.setPassword(userDTO.getPassword());
            userAccount.setUserName(userDTO.getName());
            try {
                userAccountDao.createUserAccount(userAccount);
                userDTO.setMessage("User successfully created");
                userDTO.setError(false);
                req.getRequestDispatcher("WEB-INF/view/login.jsp").forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
                req.getRequestDispatcher("WEB-INF/view/404.jsp").forward(req, resp);
            }

        } else {
            userDTO.setMessage(errorMessage);
            userDTO.setError(true);
            System.out.println(userDTO);
        }
        req.setAttribute("userDTO", userDTO);
        doGet(req, resp);
    }

    private String validate(UserDTO userDTO) throws SQLException {

        if (userDTO.getEmail().isEmpty()) {
            return "Please, fill email";
        }

        if (!userDTO.getEmail().contains("@")
                || !userDTO.getEmail().contains(".")) {
            return "Please, fill correct email";
        }

        if (userDTO.getPassword().isEmpty()) {
            return "Please fill password";
        }

        if (userDTO.getConfirmPassword().isEmpty()) {
            return "Please fill password confirmation";
        }

        if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
            System.out.println(userDTO);
            return "Passwords are not match";
        }

        if (userDTO.getName().isEmpty()) {
            return "Please fill the name";
        }

        if (userAccountDao.isUserExist(userDTO.getEmail())) {
            return "This email is already registered";
        }

            return "";
    }

    private void checkUserDTO(HttpServletRequest req) {
        if (req.getAttribute("userdto") == null) {
            UserDTO userDTO = new UserDTO();
            req.setAttribute("userdto", userDTO);
        }
    }
}
