package service;

import entity.User;

public interface UserService {

    boolean login(User user);

    boolean register(User user);

}
