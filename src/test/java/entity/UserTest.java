package entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

import java.util.Set;

class UserTest {

    private static ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

    private UserService userService = context.getBean(UserService.class);

    @Test
    void loginSuccessTest(){
        User user = new User().setName("test1").setPassword("123456");
        Assertions.assertTrue(userService.login(user));
    }

    @Test
    void loginFailTest(){
        User user = new User().setName("test1").setPassword("123");
        Assertions.assertFalse(userService.login(user));
    }

    @Test
    void registerTest(){
        User user = new User();
        user.setName("test1");
        user.setPassword("123456");
        Power power = new Power();
        power.setName("test");
        user.getPowers().add(power);
        Assertions.assertTrue(userService.add(user));
    }

    @Test
    void alter(){
        User user = new User();
        user.setId(0);
        user.setName("test2");
        user.setPassword("123");
        Set<Power> powers = user.getPowers();
        powers.add(new Power().setId(0).setName("test"));
        powers.add(new Power().setId(1).setName("test2"));
        Assertions.assertTrue(userService.update(user));
    }

}
