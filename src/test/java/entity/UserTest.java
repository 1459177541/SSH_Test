package entity;

import action.LoginAction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Set;

class UserTest {

//    private static Logger LOGGER = LoggerFactory.getLogger(UserTest.class);
    private static ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

    @Test
    void loginSuccessTest(){
        LoginAction loginAction = context.getBean(LoginAction.class);
        loginAction.getModel()
                .setName("test1").setPassword("123456");
        Assertions.assertEquals("success", loginAction.login());
    }

    @Test
    void loginFailTest(){
        LoginAction loginAction1 = context.getBean(LoginAction.class);
        loginAction1.getModel().setName("test1").setPassword("123");
        Assertions.assertEquals("input", loginAction1.login());
    }

    @Test
    void registerTest(){
        LoginAction loginAction = context.getBean(LoginAction.class);
        User user = loginAction.getModel();
        user.setName("test1");
        user.setPassword("123456");
        loginAction.setPassword("123456");
        Power power = new Power();
        power.setName("test");
        user.getPowers().add(power);
//        user.setPowers(Set.of(power));
        Assertions.assertEquals("success",loginAction.register());
    }

    @Test
    void alter(){
        LoginAction loginAction = context.getBean(LoginAction.class);
        User user = loginAction.getModel();
        user.setId(2);
        user.setName("test2");
        Set<Power> powers = user.getPowers();
        powers.add(new Power().setName("test"));
        powers.add(new Power().setName("test2"));
        Assertions.assertEquals("success",loginAction.alterUser());
    }

}
