package dao;

import entity.po.InfoType;
import entity.po.LoginInfo;
import entity.po.Role;
import entity.po.User;

import java.util.Collection;
import java.util.Map;

public interface UserDao extends Dao<User> {

    boolean addRole(User user, Role role);

    Collection<Role> getRole(User user);

    Collection<LoginInfo> getLoginInfo(User user);

    Map<InfoType, String> getInfo(User user);

    boolean login(LoginInfo loginInfo);

    boolean register(User user);

}
