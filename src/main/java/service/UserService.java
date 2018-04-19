package service;

import entity.User;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private static final String USER = "user";
    
    public User getUserFromSession(HttpSession session){
        return (User)session.getAttribute(USER);
    }
}
