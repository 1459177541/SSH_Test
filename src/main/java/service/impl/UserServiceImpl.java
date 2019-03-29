package service.impl;

import dao.LoginDao;
import dao.RoleDao;
import dao.UserDao;
import entity.dto.LoginStatus;
import entity.dto.UserDto;
import entity.po.*;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.UserService;

import java.util.*;
import java.util.function.Consumer;

import static entity.po.RoleStatus.COMMIT;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final RoleDao roleDao;
    private final LoginDao loginDao;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao, LoginDao loginDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.loginDao = loginDao;
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
        roleDao.save(role);
        return true;
    }
    
    @Override
    public Collection<Role> getRole(User user) {
        return user.getRoles();
    }

    @Override
    public Collection<LoginInfo> getLoginInfo(User user) {
        Optional<User> userOptional= userDao.findById(user.getId());
        if (!userOptional.isPresent()) {
            return Set.of();
        }
        user = userOptional.get();
        Hibernate.initialize(user.getLoginInfo());
        return user.getLoginInfo();
    }

    @Override
    public Map<InfoType, String> getInfo(User user) {
        Optional<User> userOptional= userDao.findById(user.getId());
        if (!userOptional.isPresent()) {
            return Map.of();
        }
        user = userOptional.get();
        Hibernate.initialize(user.getInfo());
        return user.getInfo();
    }

    @Override
    public UserDto login(UserDto userDto) {
        Optional<User> userOptional = userDao.findById(userDto.getId());
        if (!userOptional.isPresent()) {
            userDto.setStatus(LoginStatus.USER_NON_EXISTENT);
            userDto.setInfo(userDto.getStatus().getNote());
            return userDto;
        }
        User user = userOptional.get();
        if (!Objects.equals(userDto.getPassword(), user.getPassword())) {
            userDto.setStatus(LoginStatus.PASSWORD_ERROR);
        } else if (user.getStatus() == UserStatus.REJECT) {
            userDto.setStatus(LoginStatus.USER_NON_ADOPT);
        } else if (user.getStatus() == UserStatus.WRITTEN_OFF) {
            userDto.setStatus(LoginStatus.USER_ALREADY_WRITTEN_OFF);
        } else {
            LoginInfo info = new LoginInfo();
            info.setUser(user);
            info.setDate(new Date());
            info.setIp(userDto.getIp());
            loginDao.save(info);

            userDto.setLoginDate(info.getDate());
            if (user.getStatus() == UserStatus.COMMIT) {
                userDto.setStatus(LoginStatus.WAIT_ADOPT);
            }else {
                userDto.setStatus(LoginStatus.LOGIN_SUCCESS);
            }
        }
        userDto.setInfo(userDto.getStatus().getNote());
        return userDto;
    }

    @Override
    public boolean register(UserDto userDto) {
        if (null == userDto.getId()
                || "".equals(userDto.getId())
                || null == userDto.getPassword()
                || "".equals(userDto.getPassword())) {
            return false;
        }
        if (userDao.existsById(userDto.getId())) {
            return false;
        }
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setRegisterDate(new Date());
        user.setStatus(UserStatus.COMMIT);
        return userDao.save(user) != null;
    }

    @Override
    public boolean adoptRegister(UserDto userDto) {
        Optional<User> user = userDao.findById(userDto.getId());
        if (!user.isPresent()) {
            return false;
        }
        user.get().setStatus(UserStatus.ADOPT);
        userDao.saveAndFlush(user.get());
        return true;
    }

    @Override
    public UserDto getUserDto(String id) {
        Optional<User> user = userDao.findById(id);
        return user.map(UserDto::new).orElse(null);
    }
}
