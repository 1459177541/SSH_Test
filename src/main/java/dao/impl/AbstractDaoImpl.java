package dao.impl;

import dao.Dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public abstract class AbstractDaoImpl<T> implements Dao<T> {

    private Logger LOGGER = LoggerFactory.getLogger(AbstractDaoImpl.class);

    protected SessionFactory factory;

    public abstract AbstractDaoImpl<T> setFactory(SessionFactory factory) ;

    @Override
    public boolean add(T t) {
        if (t == null) {
            return false;
        }
        LOGGER.info("添加{}", t);
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(t);
        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(T t) {
        if (t == null) {
            return false;
        }
        LOGGER.info("删除{}", t);
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(t);
        transaction.commit();
        return true;
    }

    @Override
    public boolean update(T t) {
        if (t == null) {
            return false;
        }
        LOGGER.info("更新{}", t);
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(t);
        transaction.commit();
        return true;
    }

    @Override
    public Collection<T> get() {
        Session session = factory.openSession();
        Query query = session.createQuery("from User");
        //noinspection unchecked
        return (Collection<T>) query.list();
    }

}
