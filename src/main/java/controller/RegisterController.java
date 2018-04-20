package controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    private static final String REGISTER = "register";
    private static final String LOGIN = "login";
    private static final String PASS1 = "pass1";
    private static final String PASS2 = "pass2";
    private static final String PHONE = "phone";
    private static final String EMAIL = "email";
    private static final String CITY = "city";
    private static final String MAIN_PAGE = "/main";
    private static final String REGISTER_PAGE = "/register";
    
    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView defaultView() {
        ModelAndView mav = new ModelAndView(REGISTER);
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
