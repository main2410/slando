package service;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    
    private static final String USER = "user";

    public void removeUserAttributeFromSession(String exit, HttpSession session) {
        if (exit != null && session.getAttribute(USER) != null) {
            session.removeAttribute(USER);
        }
    }
}
