package entity;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    private static ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

    private SessionFactory sessionFactory = context.getBean(SessionFactory.class);

    @Test
    void testShemExport(){

    }
}
