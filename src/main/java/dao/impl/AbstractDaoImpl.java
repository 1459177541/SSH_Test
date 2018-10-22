package dao.impl;


import dao.Dao;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public abstract class AbstractDaoImpl<T> extends HibernateDaoSupport implements Dao<T> {

    protected SessionFactory factory;

    public abstract AbstractDaoImpl<T> setFactory(SessionFactory factory) ;

    @Override
    public boolean add(T t) {
//        LOGGER.info("添加{}", t);
//        Session session = factory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.save(t);
//        transaction.commit();
        assert getHibernateTemplate() != null;
        getHibernateTemplate().save(t);
        return true;
    }

    @Override
    public boolean delete(T t) {
        assert getHibernateTemplate() != null;
        getHibernateTemplate().delete(t);
        return true;
    }

    @Override
    public boolean update(T t) {
        assert getHibernateTemplate() != null;
        getHibernateTemplate().update(t);
        return true;
    }

}
