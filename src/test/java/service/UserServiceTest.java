package service;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class UserServiceTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    void testShemExport(){
        
    }
}
