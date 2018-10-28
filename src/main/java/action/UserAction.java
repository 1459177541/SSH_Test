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
import java.util.regex.Pattern;

@Component
@Scope("prototype")
public class UserAction extends DefaultActionSupport implements ModelDriven<User> {


    @Autowired
    private UserService userService;

    public String getPassword() {
        return password;
    }

    public UserAction setPassword(String password) {
        this.password = password;
        return this;
    }

    private String password;

    public UserAction setUserService(UserService userService) {
        this.userService = userService;
        return this;
    }

    private User user = new User();

    public User getUser() {
        return user;
    }

    public UserAction setUser(User user) {
        this.user = user;
        return this;
    }

    //失败
    @Override
    public User getModel() {
        return user;
    }


    public String login(){
        if (userService.login(user)) {
            ServletActionContext.getRequest().getSession().setAttribute("user", user);
            return SUCCESS;
        }else {
            addFieldError("login", "用户名或密码错误");
            return INPUT;
        }
    }

    public String register(){
        if (!Objects.equals(password, user.getPassword())){
            return INPUT;
        }
        userService.register(user);
        ServletActionContext.getRequest().getSession().setAttribute("user", user);
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
        userService.update(user);
        return SUCCESS;
    }

    public void validateLogin() {
        if ("".equals(user.getName())){
            addFieldError("user.name","用户名不能为空");
        }
        if ("".equals(user.getPassword())){
            addFieldError("user.password","密码不能为空");
        }
    }

    public void validateRegister(){
        validateLogin();
        if (!user.getPassword().equals(password)){
            addFieldError("password","两次密码不一样");
        }
        final String emailRegex = "^[0-9a-z]+\\w*@([0-9a-z]+\\.)+[0-9a-z]+$";
        if (!("".equals(user.getEmail()) || Pattern.compile(emailRegex).matcher(user.getEmail()).matches())) {
            addFieldError("user.email","请输入正确的邮箱");
        }
    }

    public String registerView() {
        return SUCCESS;
    }
}
