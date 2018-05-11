package controller;

import counter.LoginedCounter;
import counter.OnlineCounter;
import dao.ItemCacheDao;
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
    private static final String OWNER = "owner";
    private static final String ONLINE_COUNTER = "onlineCounter";
    private static final String LOGINED_COUNTER = "loginedCounter";

    @Autowired
    private UserService userService;
    @Autowired
    private ItemCacheDao itemCacheDao;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private OnlineCounter onlineCounter;
    @Autowired
    private LoginedCounter loginedCounter;

    public MainController() {

    }

    @RequestMapping(name = MAIN_URL, method = RequestMethod.GET)
    public ModelAndView main(HttpServletRequest request,
            @RequestParam(name = EXIT, required = false) String exit,
            @RequestParam(name = ID, required = false) String id,
            @RequestParam(name = QUERY, required = false) String q,
            @RequestParam(name = CAT, required = false) String cat,
            @RequestParam(name = OWNER, required = false) String owner) {

        authenticationService.removeUserIfExitPressed(exit, request.getSession());
        User user = userService.getUserFromSession(request.getSession());
        ModelAndView mav = new ModelAndView();
        mav.setViewName(MAIN);
        mav.addObject(USER, user);
        if (owner != null) {
            mav.addObject(ITEMS, itemCacheDao.getByOwner(owner));
        } else if (id != null) {
            mav.addObject(ITEMS, itemCacheDao.getById(id));
        } else if (q != null || cat != null) {
            mav.addObject(ITEMS, itemCacheDao.getByNameOrCat(q, cat));
        } else {
            mav.addObject(ITEMS, itemCacheDao.get());
        }
        mav.addObject(OWNER, owner);
        mav.addObject(ONLINE_COUNTER, onlineCounter);
        mav.addObject(LOGINED_COUNTER, loginedCounter);
        return mav;
    }
}
