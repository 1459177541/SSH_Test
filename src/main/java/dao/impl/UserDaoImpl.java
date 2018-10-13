package dao.impl;

import dao.DaoUtil;
import dao.UserDao;
import entity.User;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    private DaoUtil util;

    @Autowired
    public UserDaoImpl setUtil(DaoUtil util) {
        this.util = util;
        return this;
    }

    @Override
    public Optional<User> get(int id) {
        Session session = util.getSession();
        User user = session.get(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> get(String name) {
        Session session = util.getSession();
        Query<User> query = session.createQuery("from User u where u.name=:name", User.class);
        query.setParameter("name", name);
        return Optional.ofNullable(query.getResultList().get(0));
    }

    @Override
    public boolean delete(int id) {
        return delete(get(id).orElse(null));
    }

    @Override
    public boolean add(User user) {
        if (user == null) {
            return false;
        }
        Session session = util.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(User user) {
        if (user == null) {
            return false;
        }
        Session session = util.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        return true;
    }

    @Override
    public boolean update(User user) {
        if (user == null) {
            return false;
        }
        Session session = util.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        return true;
    }

    @Override
    public Collection<User> get() {
        Session session = util.getSession();
        Query query = session.createQuery("from User");
        //noinspection unchecked
        return (Collection<User>) query.list();
    }
}
