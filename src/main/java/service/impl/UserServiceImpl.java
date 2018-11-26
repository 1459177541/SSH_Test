package service.impl;

import dao.UserDao;
import entity.user.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.Optional;

@Service
@Repository
public abstract class UserServiceImpl<T extends User> implements UserService<T> {

    protected UserDao<T> userDao;
    public abstract UserServiceImpl setUserDao(UserDao<T> userDao);

    @Override
    public Optional<T> get(int id) {
        return userDao.get(id);
    }

    @Override
    public boolean login(T user) {
        Optional<T> userOptional = userDao.get(user.getId());
        if (userOptional.isPresent()){
            User user1 = userOptional.get();
            return user1.getPassword().equals(user.getPassword());
        }
        return false;
    }

    @Override
    public boolean register(T user) {
        return userDao.register(user);
    }

    @Override
    public boolean add(T user) {
        return register(user);
    }

    @Override
    public boolean delete(T user) {
        return userDao.delete(user.getId());
    }

    @Override
    public boolean update(T user) {
        return userDao.update(user);
    }


}
