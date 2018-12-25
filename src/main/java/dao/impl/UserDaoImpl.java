package dao.impl;

import dao.UserDao;
import entity.user.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao{

    @Override
    public User login(User user) {
        assert getHibernateTemplate() != null;
        User user1 = getHibernateTemplate().load(User.class, user.getId());
        if (user1.getPassword().equals(user.getPassword())) {
            return user1;
        }
        return null;
    }

    @Override
    public boolean register(User user) {
        return add(user);
    }

    @Override
    public User get(int id) {
        assert getHibernateTemplate() != null;
        return getHibernateTemplate().load(User.class, id);
    }

    @Override
    public Collection<User> get() {
        assert getHibernateTemplate() != null;
        return getHibernateTemplate().loadAll(User.class);
    }

}
