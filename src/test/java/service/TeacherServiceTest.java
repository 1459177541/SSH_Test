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
        Assertions.assertNotNull(service.login(2018401, "123"));
        Assertions.assertNull(service.login(2018401, "456"));
    }

    @Test
    void registerTest() {
        Teacher teacher = (Teacher) new Teacher()
                .setId(2018401)
                .setName("teacher1")
                .setPassword("123");
        Assertions.assertTrue(service.register(teacher));
        Assertions.assertNotNull(service.login(teacher));
    }
}
