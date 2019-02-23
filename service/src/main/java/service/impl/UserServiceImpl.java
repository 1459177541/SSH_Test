package service.impl;

import dao.api.LoginRepository;
import dao.api.RoleRepository;
import dao.api.UserRepository;
import entity.dto.LoginStatus;
import entity.dto.UserDto;

import static entity.po.RoleStatus.COMMIT;

import entity.po.*;
import org.hibernate.Hibernate;
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

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final LoginRepository loginRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, LoginRepository loginRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.loginRepository = loginRepository;
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
        roleRepository.save(role);
        return true;
    }
    
    @Override
    public Collection<Role> getRole(User user) {
        return user.getRoles();
    }

    @Override
    public Collection<LoginInfo> getLoginInfo(User user) {
        user = userRepository.findById(user.getId());
        Hibernate.initialize(user.getLoginInfo());
        return user.getLoginInfo();
    }

    @Override
    public Map<InfoType, String> getInfo(User user) {
        user = userRepository.findById(user.getId());
        Hibernate.initialize(user.getInfo());
        return user.getInfo();
    }

    @Override
    public UserDto login(UserDto userDto) {
        User user = userRepository.findById(userDto.getId());
        if (user == null) {
            userDto.setStatus(LoginStatus.USER_NON_EXISTENT);
            userDto.setInfo(userDto.getStatus().getNote());
            return userDto;
        }
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
            loginRepository.save(info);

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
        if (userRepository.findById(userDto.getId()) != null) {
            return false;
        }
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setRegisterDate(new Date());
        user.setStatus(UserStatus.COMMIT);
        return userRepository.save(user) != null;
    }

    @Override
    public boolean adoptRegister(UserDto userDto) {
        User user = userRepository.findById(userDto.getId());
        if (user == null) {
            return false;
        }
        user.setStatus(UserStatus.ADOPT);
        userRepository.saveAndFlush(user);
        return true;
    }

    @Override
    public UserDto getUserDto(String id) {
        User user = userRepository.findById(id);
        if (user == null) {
            return null;
        }
        return new UserDto(user);
    }
}
