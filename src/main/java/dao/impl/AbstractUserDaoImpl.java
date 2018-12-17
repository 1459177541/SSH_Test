package dao.impl;


import dao.UserDao;
import entity.user.User;
import org.springframework.stereotype.Repository;

@Repository
public abstract class AbstractUserDaoImpl<T extends User> extends AbstractDaoImpl<T> implements UserDao<T> {


    @Override
    public boolean delete(int id) {
        return delete(get(id).orElse(null));
    }

}
