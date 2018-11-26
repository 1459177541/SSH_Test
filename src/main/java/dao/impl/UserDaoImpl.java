package dao.impl;


import dao.UserDao;
import entity.user.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public abstract class UserDaoImpl<T extends User> extends AbstractDaoImpl<T> implements UserDao<T> {


    @Override
    public boolean delete(int id) {
        return delete(get(id).orElse(null));
    }

}
