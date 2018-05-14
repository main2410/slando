package controller;

import counter.LoginedCounter;
import counter.OnlineCounter;
import entity.User;
import entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import service.ItemService;
import service.UserService;

@Controller
@RequestMapping(value = "/edit")
public class EditController {

    private static final String EDIT = "edit";
    private static final String ITEM = "item";
    private static final String ID = "id";
    private static final String USER = "user";
    private static final String CAT = "cat";
    private static final String NAME = "name";
    private static final String ABOUT = "about";
    private static final String PRICE = "price";
    private static final String PIC = "pic";
    private static final String DELETE = "delete";
    private static final String MAIN_PAGE = "/main";
    private static final String ONLINE_COUNTER = "onlineCounter";
    private static final String LOGINED_COUNTER = "loginedCounter";

    @Autowired
    private ItemService itemService;
    @Autowired
    private UserService userService;
     @Autowired
    private OnlineCounter onlineCounter;
    @Autowired
    private LoginedCounter loginedCounter;

    @GetMapping
    public ModelAndView defaultView (HttpServletRequest request, HttpServletResponse response,
                                 @RequestParam(name = ID, required = false) String id) throws IOException {

        if (!userService.isLoginedUser(request.getSession()) || id == null) {
            response.sendRedirect(MAIN_PAGE);
        }
        Item item = itemService.getItemById(id);
        ModelAndView mav = new ModelAndView(EDIT);
        mav.addObject(ONLINE_COUNTER, onlineCounter);
        mav.addObject(LOGINED_COUNTER, loginedCounter);
        mav.addObject(ITEM, item);
        return mav;
    }

    @PostMapping
    public void edit (HttpServletResponse response,
                      @RequestParam(name = DELETE, required = false) String delete,
                      @RequestParam(name = ID, required = false) String id,
                      @RequestParam(name = CAT, required = false) String cat,
                      @RequestParam(name = NAME, required = false) String name,
                      @RequestParam(name = ABOUT, required = false) String about,
                      @RequestParam(name = PRICE, required = false) Integer price,
                      @RequestParam(name = PIC, required = false) String pic) throws IOException {
        Item item = itemService.getItemById(id);
        if (delete != null) {
            itemService.deleteItem(item);
        } else {
            itemService.changeItem(item, cat, name, about,  pic, price);
        }
        response.sendRedirect(MAIN_PAGE);
    }

}
