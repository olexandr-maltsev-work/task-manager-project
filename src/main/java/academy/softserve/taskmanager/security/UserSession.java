package academy.softserve.taskmanager.security;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class UserSession {

    private static Map<String, String> userSession = new HashMap<>();

    public static void addToSession(String userId, HttpServletRequest request) {
        userSession.put(userId, request.getSession().getId());
        request.getSession().setAttribute("user", userId);
    }

    public static void clearSession(String userId) {
        userSession.remove(userId);
    }

    public static boolean isSessionValid(String userId, HttpServletRequest request) {
        if (!userSession.containsKey(userId)) {
            return false;
        }
        return userSession.get(userId).equals(request.getSession().getId());
    }
}
