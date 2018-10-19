package action;

import com.opensymphony.xwork2.ModelDriven;
import entity.User;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.DefaultActionSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import service.UserService;

import java.util.Objects;
import java.util.Optional;

@Component
@Scope("prototype")
public class LoginAction extends DefaultActionSupport implements ModelDriven<User> {

    private static Logger LOGGER = LoggerFactory.getLogger(LoginAction.class);

    @Autowired
    private UserService userService;

    public String getPassword() {
        return password;
    }

    public LoginAction setPassword(String password) {
        this.password = password;
        return this;
    }

    private String password;

    public LoginAction setUserService(UserService userService) {
        LOGGER.info("setService={}", userService);
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
        LOGGER.info("{}尝试登录",user);
        if (userService.login(user)) {
//            ServletActionContext.getRequest().getSession().setAttribute("user", user);
            return SUCCESS;
        }else {
            return INPUT;
        }
    }

    public String register(){
        if (!Objects.equals(password, user.getPassword())){
            return INPUT;
        }
        LOGGER.info("{}注册",user);
        userService.register(user);
//        ServletActionContext.getRequest().getSession().setAttribute("user", user);
        return SUCCESS;
    }

    public String alterUser(){
        Optional<User> oldUser = userService.get(user.getId());
        if (!oldUser.isPresent()) {
            return INPUT;
        }
        if (user.getName() == null) {
            user.setPassword(oldUser.get().getName());
        }
        if (user.getPassword() == null) {
            user.setPassword(oldUser.get().getPassword());
        }
        if (user.getEmail() == null) {
            user.setPassword(oldUser.get().getEmail());
        }
        LOGGER.info("{}修改",user);
        userService.update(user);
        return SUCCESS;
    }
}
