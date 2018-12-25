package service;

import entity.user.BaseRole;
import entity.user.User;

import javax.validation.Valid;
import java.util.Optional;

public interface RoleService<T extends BaseRole> extends Service<T>{

    Optional<T> get(int id);

}
