package controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import entity.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@SuppressWarnings("SpringMVCViewInspection")
@Controller
@Slf4j
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
    public String login(Model model){
        model.addAttribute("user", new UserDto());
        return "login/login";
    }

    @RequestMapping(value = "/loginTo", method = POST)
    @ResponseBody
    public void loginTo(@RequestBody UserDto user,
                        HttpServletRequest request,
                        HttpSession session,
                        PrintWriter printWriter) {
        log.trace("注册{}", user);
        user.setIp(request.getHeader("X-Forwarded-For"));
        UserDto userDto = userService.login(user);
//        model.addAttribute("user", userDto);
        session.setAttribute("user", userDto);
        String json = JSON.toJSONString(userDto, SerializerFeature.PrettyFormat);
        printWriter.write(json);
        printWriter.flush();
        printWriter.close();
    }

    @RequestMapping(value = "register", method = GET)
    public String register(Model model){
        model.addAttribute("user", new UserDto());
        return "login/register";
    }

    @RequestMapping(value = "registerTo", method = POST)
    @ResponseBody
    public void registerTo(@RequestBody UserDto user,
                           PrintWriter printWriter) {
        log.trace("注册{}", user);
        if (userService.register(user)) {
            printWriter.write("{'result':'success'}");
        }else {
            printWriter.write("{'result':'fail'}");
        }
        printWriter.flush();
        printWriter.close();
    }

    @RequestMapping(value = "/checkUserName", method = POST)
    @ResponseBody
    public void checkUserName(@RequestBody UserDto user,
                              PrintWriter printWriter) {
        UserDto userDto = userService.getUserDto(user.getId());
        if (userDto == null) {
            printWriter.write("{'result':'non-exist'}");
        } else {
            printWriter.write("{'result':'exist'}");
        }
        printWriter.flush();
        printWriter.close();
    }

}
