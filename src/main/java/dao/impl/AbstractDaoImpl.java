package dao.impl;


import dao.Dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Optional;

@Repository
@Transactional(rollbackFor = Exception.class)
public abstract class AbstractDaoImpl<T> implements Dao<T> {

    private HibernateTemplate hibernateTemplate;

    private SessionFactory sessionFactory;

    @Resource
    public void setFactory(SessionFactory sessionFactory) {
        this.sessionFactory = Objects.requireNonNull(sessionFactory);
        hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    protected synchronized HibernateTemplate getHibernateTemplate(){
        hibernateTemplate = Optional.ofNullable(hibernateTemplate).orElse(new HibernateTemplate(sessionFactory));
        return hibernateTemplate;
    }

    protected SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    @Override
    public boolean add(T t) {
        getHibernateTemplate().save(t);
        return true;
    }

    @Override
    public boolean delete(T t) {
        if (t == null) {
            return false;
        }
        getHibernateTemplate().delete(t);
        return true;
    }

    @Override
    public boolean update(T t) {
        getHibernateTemplate().update(t);
        return true;
    }


}
