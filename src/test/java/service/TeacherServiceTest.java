package service;

import config.ContextConfig;
import entity.user.Teacher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ContextConfig.class)
class TeacherServiceTest {

    @Autowired
    TeacherService service;

    @Test
    void loginTest(){
        Assertions.assertTrue(service.login(1, "123"));
        Assertions.assertFalse(service.login(1, "456"));
    }

    @Test
    void registerTest() {
        Teacher teacher = (Teacher) new Teacher()
                .setName("teacher1")
                .setPassword("123");
        Assertions.assertTrue(service.register(teacher));
        Assertions.assertTrue(service.login(teacher));
    }
}
