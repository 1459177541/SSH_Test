package service.impl;

import dao.RoleDao;
import dao.UserDao;
import dto.LoginStatus;
import dto.UserDto;
import entity.*;

import static entity.RoleStatus.COMMIT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
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
    public UserDto login(UserDto userDto) {
        User user = userDao.get(userDto.getId());
        if (user == null) {
            userDto.setStatus(LoginStatus.USER_NON_EXISTENT);
            return userDto;
        }
        if (!Objects.equals(userDto.getPassword(), user.getPassword())) {
            userDto.setStatus(LoginStatus.PASSWORD_ERROR);
        } else if (user.getStatus() == UserStatus.COMMIT) {
            userDto.setStatus(LoginStatus.WAIT_ADOPT);
        } else if (user.getStatus() == UserStatus.REJECT) {
            userDto.setStatus(LoginStatus.USER_NON_ADOPT);
        } else if (user.getStatus() == UserStatus.WRITTEN_OFF) {
            userDto.setStatus(LoginStatus.USER_ALREADY_WRITTEN_OFF);
        } else {
            LoginInfo info = new LoginInfo();
            info.setUser(user);
            info.setDate(new Date());
            info.setIp(userDto.getIp());
            userDao.login(info);

            userDto.setLoginDate(info.getDate());
            userDto.setStatus(LoginStatus.LOGIN_SUCCESS);
        }
        return userDto;
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

    @Override
    public boolean adoptRegister(UserDto userDto) {
        User user = userDao.get(userDto.getId());
        if (user == null) {
            return false;
        }
        user.setStatus(UserStatus.ADOPT);
        userDao.update(user);
        return true;
    }


}
