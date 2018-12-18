package service;

import entity.user.User;

import javax.validation.Valid;
import java.util.Optional;

public interface UserService<T extends User> extends Service<T>{

    Optional<T> get(int id);

    T login(T user);

    T login(int id, String password);

    @Valid
    boolean register(T user);

    boolean register(int id, String name, String password);

}
