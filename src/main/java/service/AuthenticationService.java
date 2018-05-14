package service;

import counter.LoginedCounter;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    
    private static final String USER = "user";
    
    @Autowired
    private LoginedCounter loginedCounter;

    public void removeUserIfExitPressed(String exit, HttpSession session) {
        if (exit != null && session.getAttribute(USER) != null) {
            removeUserFromSession(session);
        }
    }
    
    public void removeUserAfterSessionOver(HttpSession session) {
        if (session.getAttribute(USER) != null) {
            removeUserFromSession(session);
        }
    }
    
    private void removeUserFromSession(HttpSession session){
        session.removeAttribute(USER);
        loginedCounter.decrement();
    }
}
