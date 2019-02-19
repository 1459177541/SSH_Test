package dao.impl;

import dao.UserDao;
import entity.po.InfoType;
import entity.po.LoginInfo;
import entity.po.Role;
import entity.po.User;
import org.hibernate.Hibernate;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

@Transactional(rollbackFor = Exception.class)
@Repository
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {

    @Override
    public boolean addRole(User user, Role role) {
        return false;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public Collection<Role> getRole(User user) {
        return getHibernateTemplate()
                .execute(session -> {
                    User user1 = session.get(User.class, user.getUid());
                    Hibernate.initialize(user1.getRoles());
                    return user1.getRoles();
                });
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public Collection<LoginInfo> getLoginInfo(User user) {
        return getHibernateTemplate()
                .execute(session -> {
                    User user1 = session.get(User.class, user.getUid());
                    Hibernate.initialize(user1.getLoginInfo());
                    return user1.getLoginInfo();
                });
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public Map<InfoType, String> getInfo(User user) {
        return getHibernateTemplate()
                .execute(session -> {
                    User user1 = session.get(User.class, user.getUid());
                    Hibernate.initialize(user1.getInfo());
                    return user1.getInfo();
                });
    }

    @Override
    public boolean login(LoginInfo info) {
        getHibernateTemplate().save(info);
        return true;
    }

    @Override
    public boolean register(User user) {
        if (((UserDao) AopContext.currentProxy()).get(user.getId()) != null) {
            return false;
        }
        getHibernateTemplate().save(user);
        return true;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public User get(Serializable id) {
        return getHibernateTemplate()
                .execute(session -> {
                    CriteriaBuilder builder = session.getCriteriaBuilder();
                    CriteriaQuery<User> criteria = builder.createQuery(User.class);
                    Root<User> root = criteria.from(User.class);
                    criteria.where(builder.equal(root.get("id"), id));
                    return session.createQuery(criteria).uniqueResult();
                });
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public Collection<User> get() {
        return getHibernateTemplate().loadAll(User.class);
    }
}
