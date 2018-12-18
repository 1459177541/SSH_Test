package dao.impl;


import dao.Dao;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Repository
@Transactional(rollbackFor = Exception.class)
public abstract class AbstractDaoImpl<T> extends HibernateDaoSupport implements Dao<T> {

    @Resource
    public void setFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public boolean add(T t) {
        assert getHibernateTemplate() != null;
        getHibernateTemplate().save(t);
        return true;
    }

    @Override
    public boolean delete(T t) {
        assert getHibernateTemplate() != null;
        if (t == null) {
            return false;
        }
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
