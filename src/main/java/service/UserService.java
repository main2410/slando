package service;

import counter.LoginedCounter;
import dao.UserDao;
import dao.UserRepository;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static constants.StringConstants.*;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

@Service
public class UserService {
    
    @Autowired
    private LoginedCounter loginedCounter;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationService verificationService;

    public User getUserFromSession(HttpSession session) {
        return (User) session.getAttribute(USER);
    }

    public boolean register(String login, String pass1, String pass2, String phone, String email, String city) {
        if (pass1.equals(pass2) && verificationService.isCorrectUserData(login, phone, email)) {
            User user = userRepository.findByLogin(login);
            if (user == null) {
                userRepository.save(User.builder().
                        login(login).
                        pass(pass2).
                        phone(phone).
                        email(email).
                        city(city).
                        createDate(new Timestamp(System.currentTimeMillis())).build());
                return true;
            }
        }
        return false;
    }

    public boolean login(String login, String pass, HttpSession session) {
        User u = userRepository.findByLogin(login);
        if (pass.equals(u.getPass())) {
            session.setAttribute(USER, u);
            loginedCounter.increment();
            return true;
        }
        return false;
    }

    public boolean isLoginedUser(HttpSession session) {
        return getUserFromSession(session) != null;
    }

    public void changeProfile (User u, String oldPass, String pass1,
                                String pass2, String phone, String email, String city) {
        if (u != null) {
            if (u.getPass().equals(oldPass) && pass1 != null && pass1.equals(pass2)){
                u.setPass(pass2);
            }
            if (verificationService.isCorrectPhone(phone)) {
                u.setPhone(phone);
            }
            if (verificationService.isCorrectEmail(email)) {
                u.setEmail(email);
            }
            if (city != null && !city.equals("")) {
                u.setCity(city);
            }
            userRepository.save(u);
        }
    }

}
