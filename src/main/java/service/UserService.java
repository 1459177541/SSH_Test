package service;

import entity.*;

import java.util.Collection;
import java.util.Map;

public interface UserService {

    boolean joinGroup(User user, Group group, RoleType type);

    boolean joinTask(User user, Task task, RoleType type);

    Collection<Role> getRole(User user);

    Collection<LoginInfo> getLoginInfo(User user);

    Map<InfoType, String> getInfo(User user);

    User login(User user, String ip);

    boolean register(User user);

}
