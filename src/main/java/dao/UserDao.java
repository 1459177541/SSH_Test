package dao;

import entity.user.User;

import java.util.Optional;

public interface UserDao extends Dao<User> {

    Optional<User> get(int id);

    boolean delete(int id);

}
