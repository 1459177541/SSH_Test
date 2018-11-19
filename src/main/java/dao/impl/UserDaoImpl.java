package dao.impl;


import dao.UserDao;
import entity.user.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Repository
@Transactional
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {


    @Override
    public Optional<User> get(int id) {
        assert getHibernateTemplate() != null;
        return Optional.ofNullable(getHibernateTemplate().get(User.class, id));
    }

    @Override
    public boolean delete(int id) {
        return delete(get(id).orElse(null));
    }

    @Override
    public Collection<User> get() {
        assert getHibernateTemplate() != null;
        return getHibernateTemplate().loadAll(User.class);
    }
}
