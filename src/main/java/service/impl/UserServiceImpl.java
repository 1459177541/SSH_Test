package service.impl;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import service.UserService;

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
        return dao.get(user.getId()).isPresent()
                || (null != user.getName() && dao.get(user.getName()).isPresent());
    }

    @Override
    public boolean register(User user) {
        return dao.add(user);
    }
}
