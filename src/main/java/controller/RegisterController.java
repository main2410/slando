package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    private static final String REGISTER = "register";

    @GetMapping
    public ModelAndView defaultView() {
        ModelAndView mav = new ModelAndView(REGISTER);
        return mav;
    }

    @PostMapping
    public void register() {

    }
}
