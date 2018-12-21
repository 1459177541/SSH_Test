package service;


import config.ContextConfig;
import entity.Course;
import entity.user.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ContextConfig.class)
class StudentServiceTest {

    @Autowired
    StudentService service;

    @Test
    void loginTest() {
        Assertions.assertNotNull(service.login(2018101, "123"));
        Assertions.assertNull(service.login(2018101, "456"));
    }

    @Test
    void registerTest(){
        Student student = (Student) new Student()
                .setId(2018101)
                .setName("student1")
                .setPassword("123");
        Assertions.assertTrue(service.register(student));
        Assertions.assertNotNull(service.login(student));
    }

    @Test
    void setCourse(){
        List<Course> courses = List.of(
                new Course().setName("Course1").setCredit(1).setPeriod(15)
        );
        Assertions.assertTrue(service.setCourse(1, courses));
        Assertions.assertEquals(1, service.getCourse(1).size());
    }


}
