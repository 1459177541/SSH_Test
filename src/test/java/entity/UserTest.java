package entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

import java.util.Set;

class UserTest {

    private static Logger LOGGER = LoggerFactory.getLogger(UserTest.class);

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
        user.setName("test2");
        user.setPassword("123456");
        user.getPowers().add(new Power().setId(1).setName("test"));
        user.getPowers().add(new Power().setName("test3"));
        Assertions.assertTrue(userService.add(user));
    }

    @Test
    void alter(){
        User user = userService.get(1).orElseThrow();
        Set<Power> powers = user.getPowers();
//        powers.add(new Power().setName("test1"));
        powers.clear();
        powers.add(new Power().setId(1).setName("testAlter"));
        Assertions.assertTrue(userService.update(user));
    }

    @Test
    void info(){
        userService.get().forEach(user -> LOGGER.info("用户：{}, 权限:{}", user, user.getPowers()));
        User user = userService.get(1).orElseThrow();
        LOGGER.info("UserClass:{}, SetClass:{}", user.getClass(), user.getPowers().getClass());
    }

}
