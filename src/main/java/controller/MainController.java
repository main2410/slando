package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private static final String MAIN_URL = "/main";
    private static final String MAIN = "main";
    private static final String EXIT = "exit";
    private static final String USER = "user";

    @RequestMapping(name = MAIN_URL, method = RequestMethod.GET)
    public ModelAndView main(@RequestParam(name = EXIT, required = false) String exit) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(MAIN);
        return modelAndView;
    }
}