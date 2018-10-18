package service.impl;

import dao.PowerDao;
import dao.UserDao;
import entity.Power;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

@Service
@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PowerDao powerDao;

    public UserServiceImpl setPowerDao(PowerDao powerDao) {
        this.powerDao = powerDao;
        return this;
    }
    public UserServiceImpl setUserDao(UserDao userDao) {
        this.userDao = userDao;
        return this;
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
        Set<Power> powers = user.getPowers();
        Optional optional = powers.stream().map(powerDao::add).filter(Predicate.isEqual(false)).findAny();
        if (optional.isPresent()) return false;
        return userDao.add(user);
    }
}
