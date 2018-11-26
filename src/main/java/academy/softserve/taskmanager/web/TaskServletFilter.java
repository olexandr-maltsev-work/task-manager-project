package academy.softserve.taskmanager.web;

import academy.softserve.taskmanager.security.UserSession;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = { "/TaskServlet", "/TaskCreateServlet", "/TaskEditServlet", "/TaskDeleteServlet"})
public class TaskServletFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = ((HttpServletRequest) request);
        Object attribute = httpServletRequest.getSession().getAttribute("user");
        if (attribute == null) {
            request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(request, response);
            return;
        }

        String userId = (String) attribute;
        if (!UserSession.isSessionValid(userId, httpServletRequest)) {
            request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(request, response);
            return;
        }

        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
