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
import service.ControllerService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    
    private static final String LOGIN = "login";
    private static final String PASS = "pass";
    private static final String MAIN_PAGE = "/main";
    private static final String LOGIN_PAGE = "/login";
    private static final String ONLINE_COUNTER = "onlineCounter";
    private static final String LOGINED_COUNTER = "loginedCounter";
    
    @Autowired
    private UserService userService;

    @Autowired
    private ControllerService controllerService;
     @Autowired
    private OnlineCounter onlineCounter;
    @Autowired
    private LoginedCounter loginedCounter;

    @GetMapping
    public ModelAndView defaultView(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(userService.isLoginedUser(request.getSession())){
            response.sendRedirect(MAIN_PAGE);
        }
        ModelAndView mav = controllerService.getModelAndView(LOGIN);
        mav.addObject(ONLINE_COUNTER, onlineCounter);
        mav.addObject(LOGINED_COUNTER, loginedCounter);
        return mav;
    }

    @PostMapping
    public void login(HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(name = LOGIN) String login,
            @RequestParam(name = PASS) String pass) throws IOException {

        if (userService.isLoginedUser(request.getSession()) || userService.login(login, pass, request.getSession())) {
            response.sendRedirect(MAIN_PAGE);
        }else{
            response.sendRedirect(LOGIN_PAGE);
        }
    }
}
