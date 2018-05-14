package controller;

import dao.ItemCacheDao;
import entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;
import service.AuthenticationService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MainControllerTest {
    private static final String USER = "user";
    private static final String EXIT = "true";
    private static final String MAIN = "main";
    private static final String OWNER = "owner";
//    private static final String
//    private static final String
//    private static final String
//    private static final String


    @Mock
    private UserService userService;
    @Mock
    private ItemCacheDao itemCacheDao;
    @Mock
    private AuthenticationService authenticationService;
    @Mock
    private HttpSession httpSession;
    @Mock
    private HttpServletRequest httpServletRequest;
    @Mock
    private User user;

    @InjectMocks
    private MainController mainController;

    @Before
    public void init() {
        when(httpServletRequest.getSession()).thenReturn(httpSession);
        when(itemCacheDao.get()).thenReturn(Collections.emptyList());
        when(userService.getUserFromSession(httpSession)).thenReturn(user);
    }

    @Test
    public void mainExitScenario() {
        ModelAndView result = mainController.main(httpServletRequest, EXIT, null, null, null, null);

        assertNotNull(result);
        assertEquals(MAIN, result.getViewName());
        assertNull(result.getModel().get(OWNER));
        assertEquals(user, result.getModel().get(USER));

        verify(authenticationService, times(1)).removeUserIfExitPressed(EXIT, httpSession);
        verify(httpServletRequest, times(2)).getSession();
        verify(itemCacheDao, times(1)).get();
        verify(itemCacheDao, times(0)).getById(anyString());
        verify(userService, times(1)).getUserFromSession(httpSession);
    }

}
