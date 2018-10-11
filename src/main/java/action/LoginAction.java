package action;

import com.opensymphony.xwork2.ModelDriven;
import entity.User;
import org.apache.struts2.dispatcher.DefaultActionSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import service.UserService;

@Component
@Scope("prototype")
public class LoginAction extends DefaultActionSupport implements ModelDriven<User> {

    private static Logger LOGGER = LoggerFactory.getLogger(LoginAction.class);

    @Autowired
    private UserService userService;

    public LoginAction setUserService(UserService userService) {
        this.userService = userService;
        return this;
    }

    private User user = new User();

    public User getUser() {
        return user;
    }

    public LoginAction setUser(User user) {
        this.user = user;
        return this;
    }

    //失败
    @Override
    public User getModel() {
        return user;
    }


    public String login(){
        LOGGER.info(user+"尝试登录");
        if (userService.login(user)) {
            return SUCCESS;
        }else {
            return INPUT;
        }
    }

    public String register(){
        userService.register(user);
        return "login";
    }
}
