package service;


import config.ContextConfig;
import entity.user.User;
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
    void loginTest() {
        Assertions.assertNotNull(service.login(1, "123"));
        Assertions.assertNull(service.login(1, "456"));
    }

    @Test
    void registerTest(){
        User student = new User()
                .setName("user1")
                .setPassword("123");
        Assertions.assertTrue(service.register(student));
    }


}
