package dao.impl;

import dao.UserDao;
import entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {

    @Override
    @Autowired
    public AbstractDaoImpl<User> setFactory(SessionFactory factory) {
        this.factory = factory;
        return this;
    }

    @Override
    public Optional<User> get(int id) {
        Session session = factory.openSession();
        User user = session.get(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> get(String name) {
        Session session = factory.openSession();
        Query<User> query = session.createQuery("from User u where u.name=:name", User.class);
        query.setParameter("name", name);
        List<User> list = query.getResultList();
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
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        user.getPowers().forEach(session::persist);
        session.update(user);
        transaction.commit();
        return true;

    }
}
