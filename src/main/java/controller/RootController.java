package controller;


import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class RootController {
//
//    private UserService userService;
//
//    @Autowired
//    public RootController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @RequestMapping(value = {"", "index"}, method = GET)
//    public String index(){
//        return "index";
//    }
//
//    @RequestMapping(value = "login", method = GET)
//    public String login(){
//        return "login/login";
//    }
//
//    @RequestMapping(value = "/loginTo", method = POST)
//    public String loginTo(@NotNull int id,
//                          @NotNull String password,
//                          @NotNull String type,
//                          Errors errors,
//                          Model model) {
//        if (errors.hasErrors()) {
//            return "login/login";
//        }
//        User user = userService.login(id, password);
//        if (user == null) {
//            return "login/login";
//        }
//        model.addAttribute("user", user);
//        return "index";
//    }
//
//    @RequestMapping(value = "register", method = GET)
//    public String register(){
//        return "login/register";
//    }
//
//    @RequestMapping(value = "registerTo", method = POST)
//    public String registerTo(@NotNull String name,
//                             @NotNull String password,
//                             @NotNull String password2,
//                             String email,
//                             @NotNull String type,
//                             Errors errors) {
//        if (errors.hasErrors()) {
//            return "login/register";
//        }
//        if (!password.equals(password2)){
//            return "login/register";
//        }
//        if (userService.register(new User()
//                .setName(name)
//                .setPassword(password)
//                .setEmail(email)
//        )) {
//            return "login/registerSuccess";
//        }
//        return "login/register";
//    }

}
