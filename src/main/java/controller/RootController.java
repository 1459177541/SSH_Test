package controller;


import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

import java.util.Objects;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class RootController {

    private UserService userService;

    @Autowired
    public RootController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"", "index"}, method = GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "login", method = GET)
    public String login(){
        return "login/login";
    }

    @RequestMapping(value = "/loginTo", method = POST)
    public String loginTo(@NotNull User user,
                          Errors errors,
                          Model model,
                          HttpServletRequest request) {
            if (errors.hasErrors()) {
                return "login/login";
            }
            User user1 = userService.login(user, request.getHeader("X-Forwarded-For"));
            if (user == null) {
                return "login/login";
            }
            model.addAttribute("user", user1);
            return "index";
        }

    @RequestMapping(value = "register", method = GET)
    public String register(){
        return "login/register";
    }

    @RequestMapping(value = "registerTo", method = POST)
    public String registerTo(@NotNull User user,
                             Errors errors1,
                             @NotNull String password2,
                             Errors errors2) {
        if (errors1.hasErrors() || errors2.hasErrors()) {
            return "login/register";
        }
        if (!Objects.equals(user.getPassword(), password2)){
            return "login/register";
        }
        if (userService.register(user)) {
            return "login/registerSuccess";
        }
        return "login/register";
    }

}
