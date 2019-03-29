package controller;


import entity.dto.Response;
import entity.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@Slf4j
public class RootController {

    private UserService userService;

    @Autowired
    public RootController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/login",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_UTF8_VALUE)
    public Response<UserDto> loginTo(@RequestBody UserDto user,
                                     HttpServletRequest request){
        user.setIp(request.getHeader("X-Forwarded-For"));
        UserDto userDto = userService.login(user);
        return Response.success(userDto);
    }

    @PostMapping(value = "/register",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_UTF8_VALUE)
    public Response registerTo(@RequestBody UserDto user){
        if (userService.register(user)){
            return Response.success(null);
        }else {
            return Response.refuse(null);
        }
    }

    @PostMapping(value = "/checkUserName",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_UTF8_VALUE)
    public Response checkUserName(@RequestBody UserDto user){
        UserDto userDto = userService.getUserDto(user.getId());
        if (userDto == null) {
            return Response.refuse(null, "non-exist");
        }else {
            return Response.success(userDto, "exist");
        }
    }

}
