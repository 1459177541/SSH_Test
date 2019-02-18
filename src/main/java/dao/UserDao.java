package dao;

import entity.InfoType;
import entity.LoginInfo;
import entity.Role;
import entity.User;

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