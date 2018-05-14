package controller;

import counter.LoginedCounter;
import counter.OnlineCounter;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/profile")
public class ProfileController {

    private static final String PROFILE = "profile";
    private static final String OLD_PASS = "oldPass";
    private static final String PASS1 = "pass1";
    private static final String PASS2 = "pass2";
    private static final String PHONE = "phone";
    private static final String EMAIL = "email";
    private static final String CITY = "city";
    private static final String USER = "user";
    private static final String MAIN_PAGE = "/main";
    private static final String PROFILE_PAGE = "/profile";
    private static final String ONLINE_COUNTER = "onlineCounter";
    private static final String LOGINED_COUNTER = "loginedCounter";

    @Autowired
    private UserService userService;
     @Autowired
    private OnlineCounter onlineCounter;
    @Autowired
    private LoginedCounter loginedCounter;

    @GetMapping
    public ModelAndView defaultView(HttpServletRequest request,
                                    HttpServletResponse response) throws IOException {
        if(!userService.isLoginedUser(request.getSession())){
            response.sendRedirect(MAIN_PAGE);
        }
        User u = userService.getUserFromSession(request.getSession());
        ModelAndView mav = new ModelAndView(PROFILE);
        mav.addObject(USER, u);
        mav.addObject(ONLINE_COUNTER, onlineCounter);
        mav.addObject(LOGINED_COUNTER, loginedCounter);
        return mav;
    }

    @PostMapping
    public void register(HttpServletRequest request, HttpServletResponse response,
                         @RequestParam(name = OLD_PASS, required = false) String oldPass,
                         @RequestParam(name = PASS1, required = false) String pass1,
                         @RequestParam(name = PASS2, required = false) String pass2,
                         @RequestParam(name = PHONE, required = false) String phone,
                         @RequestParam(name = EMAIL, required = false) String email,
                         @RequestParam(name = CITY, required = false) String city) throws IOException {
        User u = userService.getUserFromSession(request.getSession());
        userService.changeProfile(u, oldPass, pass1, pass2, phone, email, city);
        response.sendRedirect(PROFILE_PAGE);
    }

}