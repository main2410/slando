package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    private static final String MAIN_URL = "/main";
    private static final String MAIN = "main";
    private static final String EXIT = "exit";
    private static final String QUERY = "q";
    private static final String CAT = "cat";
    private static final String ID = "id";
    private static final String OWNER = "owner";

    public MainController() {

    }

    @RequestMapping(name = MAIN_URL, method = RequestMethod.GET)
    public ModelAndView main(HttpServletRequest request,
            @RequestParam(name = EXIT, required = false) String exit,
            @RequestParam(name = ID, required = false) String id,
            @RequestParam(name = QUERY, required = false) String q,
            @RequestParam(name = CAT, required = false) String cat,
            @RequestParam(name = OWNER, required = false) String owner) {

        ModelAndView mav = new ModelAndView();
        mav.setViewName(MAIN);
        return mav;

    }
}
