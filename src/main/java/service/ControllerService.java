package service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class ControllerService {
    public ModelAndView getModelAndView(String viewName) {
        return new ModelAndView(viewName);
    }

}
