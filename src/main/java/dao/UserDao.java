package dao;

import entity.user.User;

import java.util.Optional;

public interface UserDao extends Dao<User> {

    Optional<User> get(int id);

    Optional<User> get(String name);

    boolean delete(int id);

}
