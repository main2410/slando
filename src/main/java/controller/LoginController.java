package controller;

import entity.User;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping(value = "/login")
public class LoginController {
    
    private static final String LOGIN = "login";
    private static final String PASS = "pass";
    private static final String MAIN_PAGE = "/main";
    private static final String LOGIN_PAGE = "/login";
    
    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView defaultView(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        if(userService.isLoginedUser(request.getSession())){
            response.sendRedirect(MAIN_PAGE);
        }
        ModelAndView mav = new ModelAndView(LOGIN);
        return mav;
    }

    @PostMapping
    public void login(HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(name = LOGIN) String login,
            @RequestParam(name = PASS) String pass) throws IOException {

        User u = userService.getUserFromSession(request.getSession());
        if(u != null || userService.login(login, pass, request.getSession())){
            response.sendRedirect(MAIN_PAGE);
        }else{
            response.sendRedirect(LOGIN_PAGE);
        }
    }
}
