package controller;

import dao.ItemDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.AuthenticationService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    private static final String MAIN_URL = "/main";
    private static final String MAIN = "main";
    private static final String EXIT = "exit";
    private static final String USER = "user";
    private static final String ITEMS = "items";
    private static final String QUERY = "q";
    private static final String CAT = "cat";
    private static final String ID = "id";

    @Autowired
    private UserService userService;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(name = MAIN_URL, method = RequestMethod.GET)
    public ModelAndView main(HttpServletRequest request,
                             @RequestParam(name = EXIT, required = false) String exit,
                             @RequestParam(name = ID, required = false) String id,
                             @RequestParam(name = QUERY, required = false) String q,
                             @RequestParam(name = CAT, required = false) String cat) {

        authenticationService.removeUserAttributeFromSession(exit, request.getSession());
        User user = userService.getUserFromSession(request.getSession());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(MAIN);
        modelAndView.addObject(USER, user);
        if (q == null && cat == null && id == null) {
            modelAndView.addObject(ITEMS, itemDao.get());
        } else {
            if (id == null) {
                modelAndView.addObject(ITEMS, itemDao.getByNameOrCat(q, cat));
            } else {
                modelAndView.addObject(ITEMS, itemDao.getById(id));
            }
        }
        return modelAndView;
    }
}