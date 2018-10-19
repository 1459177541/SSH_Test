package service;

import entity.User;

import java.util.Optional;

public interface UserService extends Service<User>{

    Optional<User> get(int id);

    boolean login(User user);

    boolean register(User user);

}
