package dao.impl;


import dao.UserDao;
import entity.User;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
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
    public Optional<User> get(String name) {
        assert getHibernateTemplate() != null;
        List<User> list = getHibernateTemplate().execute(session -> {
            Query<User> query = session.createQuery("from User u where u.name=:name", User.class);
            query.setParameter("name", name);
            return query.getResultList();
        });
        if (list == null || list.size() == 0) {
            return Optional.empty();
        }
        return Optional.ofNullable(list.get(0));
    }

    @Override
    public boolean delete(int id) {
        return delete(get(id).orElse(null));
    }

    @Override
    public boolean update(User user) {
        if (user == null) {
            return false;
        }
        assert getHibernateTemplate() != null;
        getHibernateTemplate().execute(session -> {
//            user.getPowers().forEach(session::update);
            session.update(user);
            return null;
        });
        return true;

    }

    @Override
    public Collection<User> get() {
        assert getHibernateTemplate() != null;
        return getHibernateTemplate().loadAll(User.class);
    }
}
