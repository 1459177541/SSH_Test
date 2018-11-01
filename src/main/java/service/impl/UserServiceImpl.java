package service.impl;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.Collection;
import java.util.Optional;

@Service
@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    public UserServiceImpl setUserDao(UserDao userDao) {
        this.userDao = userDao;
        return this;
    }

    @Override
    public Optional<User> get(int id) {
        return userDao.get(id);
    }

    @Override
    public boolean login(User user) {
        Optional<User> userOptional = userDao.get(user.getId());
        if (userOptional.isPresent()){
            User user1 = userOptional.get();
            if (user1.getPassword().equals(user.getPassword())) return true;
        }
        userOptional = userDao.get(user.getName());
        if (userOptional.isPresent()){
            User user1 = userOptional.get();
            return user1.getPassword().equals(user.getPassword());
        }
        return false;
    }

    @Override
    public boolean register(User user) {
        return userDao.add(user);
    }


    @Override
    public boolean add(User user) {
        return register(user);
    }

    @Override
    public boolean delete(User user) {
        return userDao.delete(user.getId());
    }

    @Override
    public boolean update(User user) {
        return userDao.update(user);
    }

    @Override
    public Collection<User> get() {
        return userDao.get();
    }
}
