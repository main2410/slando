package controller;

import counter.LoginedCounter;
import counter.OnlineCounter;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;
import static constants.StringConstants.*;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {

   
    
    @Autowired
    private UserService userService;
     @Autowired
    private OnlineCounter onlineCounter;
    @Autowired
    private LoginedCounter loginedCounter;

    @GetMapping
    public ModelAndView defaultView(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        if(userService.isLoginedUser(request.getSession())){
            response.sendRedirect(MAIN_PAGE);
        }
        ModelAndView mav = new ModelAndView(REGISTER);
        mav.addObject(ONLINE_COUNTER, onlineCounter);
        mav.addObject(LOGINED_COUNTER, loginedCounter);
        return mav;
    }

    @PostMapping
    public void register(@RequestParam(name = LOGIN, required = false) String login,
            @RequestParam(name = PASS1, required = false) String pass1,
            @RequestParam(name = PASS2, required = false) String pass2,
            @RequestParam(name = PHONE, required = false) String phone,
            @RequestParam(name = EMAIL, required = false) String email,
            @RequestParam(name = CITY, required = false) String city,
            HttpServletResponse response) throws IOException {
        
        if (userService.register(login, pass1, pass2, phone, email, city)) {
            response.sendRedirect(MAIN_PAGE);
        } else {
            response.sendRedirect(REGISTER_PAGE);
        }
    }
}
