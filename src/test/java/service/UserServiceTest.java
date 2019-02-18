package service;


import config.ContextConfig;
import dto.UserDto;
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

        UserDto user1 = new UserDto();
        user1.setId("super admin");
        user1.setPassword("admin");
        user1.setIp("127.0.0.1");
        Assertions.assertFalse(service.login(user1).loginSuccess());

        Assertions.assertTrue(service.adoptRegister(user1));
        Assertions.assertTrue(service.login(user1).loginSuccess());

        UserDto user2 = new UserDto();
        user2.setId("super admin");
        user2.setPassword("fail");
        user2.setIp("127.0.0.1");
        Assertions.assertFalse(service.login(user2).loginSuccess());
    }

    @Test
    void openTest(){
        
    }

}
