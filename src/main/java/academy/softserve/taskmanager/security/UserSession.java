package academy.softserve.taskmanager.security;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class UserSession {

    private static Map<String, String> userSession = new HashMap<>();

    public static void addToSession(String email, HttpServletRequest request) {
        userSession.put(email, request.getSession().getId());
        request.getSession().setAttribute("email", email);
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
