package action;

import com.opensymphony.xwork2.ModelDriven;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import service.UserService;

@Component
@Scope("prototype")
public class LoginAction implements ModelDriven<User> {

    @Autowired
    private UserService userService;

    public LoginAction setUserService(UserService userService) {
        this.userService = userService;
        return this;
    }

    private User user = new User();

    @Override
    public User getModel() {
        return user;
    }


    public String login(){
        if (userService.login(user)) {
            return "success";
        }else {
            return "input";
        }
    }

    public String register(){
        userService.register(user);
        return "login";
    }
}
