package service.impl;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.Optional;

@Service
@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    public UserServiceImpl setDao(UserDao dao) {
        this.dao = dao;
        return this;
    }

    @Override
    public boolean login(User user) {
        Optional<User> userOptional = dao.get(user.getId());
        if (userOptional.isPresent()){
            User user1 = userOptional.get();
            if (user1.getPassword().equals(user.getPassword())) return true;
        }
        userOptional = dao.get(user.getName());
        if (userOptional.isPresent()){
            User user1 = userOptional.get();
            return user1.getPassword().equals(user.getPassword());
        }
        return false;
    }

    @Override
    public boolean register(User user) {
        return dao.add(user);
    }
}
