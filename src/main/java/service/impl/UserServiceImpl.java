package service.impl;

import dao.UserDao;
import entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserDao dao;

    @Autowired
    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public User login(User user) {
        return dao.login(user);
    }

    @Override
    public boolean register(User user) {
        return dao.register(user);
    }

    @Override
    public Optional<User> get(int id) {
        return Optional.ofNullable(dao.get(id));
    }

    @Override
    public boolean add(User user) {
        return dao.add(user);
    }

    @Override
    public boolean delete(User user) {
        return dao.delete(user);
    }

    @Override
    public boolean update(User user) {
        return dao.update(user);
    }

    @Override
    public Collection<User> get() {
        return null;
    }
}
