package service;


import config.ContextConfig;
import entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ContextConfig.class)
class UserServiceTest {

    @Autowired
    UserService service;

    @Test
    void registerTest(){
        User user = new User();
        user.setId("super admin");
        user.setName("super admin");
        user.setPassword("admin");
        Assertions.assertTrue(service.register(user));
        Assertions.assertFalse(service.register(user));
        User user1 = new User();
        user1.setId("super admin");
        user1.setPassword("admin");
        Assertions.assertNotNull(service.login(user1, "127.0.0.1"));
        user1.setPassword("fail");
        Assertions.assertNull(service.login(user1, "127.0.0.1"));
    }

    @Test
    void test(){
        
    }

}
