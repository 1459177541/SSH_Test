package dao;

import entity.user.BaseRole;
import entity.user.User;

import java.util.Optional;

public interface UserDao<T extends BaseRole> extends Dao<T> {

    Optional<T> get(int id);

    boolean delete(int id);

    T login(int id, String password);

    boolean register(T user);

}
