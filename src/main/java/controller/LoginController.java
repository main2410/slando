package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    private static final String LOGIN = "login";

    @GetMapping
    public ModelAndView defaultView() {
        ModelAndView mav = new ModelAndView(LOGIN);
        return mav;
    }

    @PostMapping
    public void login() {

    }
}
