package service.impl;

import dao.RoleDao;
import dao.UserDao;
import entity.*;

import static entity.RoleStatus.COMMIT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.function.Consumer;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final RoleDao roleDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }


    @Override
    public boolean joinGroup(User user, Group group, RoleType type) {
        if (group == null) {
            return false;
        }
        return addRole(user, type, role -> role.setGroup(group));
    }

    @Override
    public boolean joinTask(User user, Task task, RoleType type) {
        if (task == null) {
            return false;
        }
        return addRole(user, type, role -> role.setJoinTask(task));
    }

    private boolean addRole(User user, RoleType type, Consumer<Role> consumer) {
        if (null == user || null == type) {
            return false;
        }
        final Role role = new Role();
        role.setUid(user);
        consumer.accept(role);
        role.setRid(type);
        role.setStatus(COMMIT);
        roleDao.add(role);
        return true;
    }
    
    @Override
    public Collection<Role> getRole(User user) {
        return user.getRoles();
    }

    @Override
    public Collection<LoginInfo> getLoginInfo(User user) {
        return userDao.getLoginInfo(user);
    }

    @Override
    public Map<InfoType, String> getInfo(User user) {
        return userDao.getInfo(user);
    }

    @Override
    public User login(User user, String ip) {
        User user1 = userDao.get(user.getId());
        if (null == user1
                || user1.getStatus() == UserStatus.COMMIT
                || user1.getStatus() == UserStatus.WRITTEN_OFF
                || user1.getStatus() == UserStatus.REJECT) {
            return user1;
        }
        user.setStatus(UserStatus.ON_LINE);
        LoginInfo info = new LoginInfo();
        info.setUser(user);
        info.setDate(new Date());
        info.setIp(ip);
        if (userDao.login(info)) {
            return userDao.get(user.getUid());
        }
        return null;
    }

    @Override
    public boolean register(User user) {
        if (null == user.getId()
                || "".equals(user.getId())
                || null == user.getPassword()
                || "".equals(user.getPassword())) {
            return false;
        }
        user.setRegisterDate(new Date());
        user.setStatus(UserStatus.COMMIT);
        return userDao.register(user);
    }
}
