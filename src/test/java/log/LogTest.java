package log;

import action.LoginAction;
import entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LogTest {

    private static Logger LOGGER = LoggerFactory.getLogger(LogTest.class);
    private static ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

    @Test
    public void loginSuccessTest(){
        LoginAction loginAction = context.getBean(LoginAction.class);
        loginAction.getModel()
                .setName("test1").setPassword("123456");
        Assertions.assertEquals("success", loginAction.login());
    }

    @Test
    public void loginFailTest(){
        LoginAction loginAction1 = context.getBean(LoginAction.class);
        loginAction1.getModel().setName("test1").setPassword("123");
        Assertions.assertEquals("input", loginAction1.login());
    }

    @Test
    public void registerTest(){
        LoginAction loginAction = context.getBean(LoginAction.class);
        User user = loginAction.getModel();
        user.setId(0);
        user.setName("test1");
        user.setPassword("123456");
        user.setGround(0);
        loginAction.register();
    }

}
