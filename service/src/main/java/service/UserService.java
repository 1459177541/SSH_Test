package service;

import dao.entity.po.*;
import entity.dto.UserDto;

import java.util.Collection;
import java.util.Map;

public interface UserService {

    boolean joinGroup(User user, Group group, RoleType type);

    boolean joinTask(User user, Task task, RoleType type);

    Collection<Role> getRole(User user);

    Collection<LoginInfo> getLoginInfo(User user);

    Map<InfoType, String> getInfo(User user);

    UserDto login(UserDto user);

    boolean register(UserDto user);

    boolean adoptRegister(UserDto user);

    UserDto getUserDto(String id);
}
