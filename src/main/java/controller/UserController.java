package controller;

import model.Login;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

@Controller
public class UserController {

    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("login", new Login());
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute Login login){
        User user = UserService.checkLogin(login);
        ModelAndView modelAndView;
        if (user == null){
            modelAndView = new ModelAndView("error");
        } else {
            modelAndView = new ModelAndView("user");
            modelAndView.addObject("user", user);
        }
        return modelAndView;
    }
}
