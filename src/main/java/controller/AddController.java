package controller;

import counter.LoginedCounter;
import counter.OnlineCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.ItemService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping(value = "/additem")

public class AddController {

    private static final String ADDITEM = "additem";
    private static final String CAT = "cat";
    private static final String NAME = "name";
    private static final String ABOUT = "about";
    private static final String PRICE = "price";
    private static final String PIC = "pic";
    private static final String MAIN_PAGE = "/main";
//    private static final String ADD_ITEM_PAGE = "/additem";
    private static final String ONLINE_COUNTER = "onlineCounter";
    private static final String LOGINED_COUNTER = "loginedCounter";

    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;
     @Autowired
    private OnlineCounter onlineCounter;
    @Autowired
    private LoginedCounter loginedCounter;

    @GetMapping
    public ModelAndView defaultView(HttpServletRequest request,
                                    HttpServletResponse response) throws IOException {
        if (!userService.isLoginedUser(request.getSession())) {
            response.sendRedirect(MAIN_PAGE);
        }
        ModelAndView mav = new ModelAndView(ADDITEM);
        mav.addObject(ONLINE_COUNTER, onlineCounter);
        mav.addObject(LOGINED_COUNTER, loginedCounter);
        return mav;
    }

    @PostMapping
    public void register(@RequestParam(name = CAT, required = false) String cat,
                         @RequestParam(name = NAME, required = false) String name,
                         @RequestParam(name = ABOUT, required = false) String about,
                         @RequestParam(name = PRICE, required = false) Integer price,
                         @RequestParam(name = PIC, required = false) String pic,
                         HttpServletRequest request) throws IOException {

        itemService.addItem(cat, name, about, price, pic, userService.getUserFromSession(request.getSession()));
    }
}
