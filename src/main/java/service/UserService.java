package service;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

@Service
public class UserService {

    private static final String USER = "user";

//    @Autowired
//    private UserRepository userRepository;

    @Autowired
    private UserDao userDao;

    public User getUserFromSession(HttpSession session) {
        return (User) session.getAttribute(USER);
    }

    public boolean register(String login, String pass1, String pass2, String phone, String email, String city) {
        if (pass1.equals(pass2)) {
            User user = userDao.getByLogin(login);
            if (user == null) {
                userDao.add(User.builder().
                        login(login).
                        pass(pass2).
                        phone(phone).
                        email(email).
                        city(city).
                        createDate(new Timestamp(System.currentTimeMillis())).build());
//                userRepository.save(User.builder().
//                        login(login).
//                        pass(pass2).
//                        phone(phone).
//                        email(email).
//                        city(city).
//                        createDate(new Timestamp(System.currentTimeMillis())).build());
                return true;
            }
        }
        return false;
    }

    public boolean login(String login, String pass, HttpSession session) {
        User u = userDao.getByLogin(login);
        if (pass.equals(u.getPass())) {
            session.setAttribute(USER, u);
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
            if (phone != null && !phone.equals("")) {
                u.setPhone(phone);
            }
            if (email != null && !email.equals("")) {
                u.setEmail(email);
            }
            if (city != null && !city.equals("")) {
                u.setCity(city);
            }
            userDao.update(u);
        }
    }

}
