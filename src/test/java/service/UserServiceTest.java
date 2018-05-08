package service;

import dao.UserDao;
import entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    private static final String USER = "user";

    @InjectMocks
    private UserService userService;

    @Mock
    private UserDao userDao;
    @Mock
    private HttpSession httpSession;
    @Mock
    private User user;

    @Before
    public void init() {
        when(httpSession.getAttribute(USER)).thenReturn(user);
    }

    @Test
    public void getUserFromSessionTest() {
        User result = userService.getUserFromSession(httpSession);

        assertNotNull(result);
        assertEquals(user, result);

        verify(httpSession, times(1)).getAttribute(USER);

        when(httpSession.getAttribute(USER)).thenReturn(null);
        result = userService.getUserFromSession(httpSession);
        assertNull(result);
    }

}
