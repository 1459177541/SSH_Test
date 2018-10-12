package log;

import action.LoginAction;
import entity.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {

    private static Logger LOGGER = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void loginTest(){

    }

    @Test
    public void registerTest(){
        LoginAction loginAction = new LoginAction();
        User user = loginAction.getModel();
        user.setId(0);
        user.setName("test1");
        user.setPassword("123456");
        loginAction.register();
    }

}
