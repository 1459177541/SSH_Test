package dao;

import entity.user.BaseRole;

import java.util.Optional;

public interface RoleDao<T extends BaseRole> extends Dao<T> {

    Optional<T> get(int id);

    boolean delete(int id);

    T login(int id, String password);

    boolean register(T user);

}
