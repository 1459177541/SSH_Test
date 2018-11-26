package service;

import entity.user.User;

import java.util.Optional;

public interface UserService<T extends User> extends Service<T>{

    Optional<T> get(int id);

    boolean login(T user);

    boolean register(T user);

}
