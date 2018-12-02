package dao.impl;

import dao.TeacherDao;
import entity.user.Teacher;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.Optional;

@Repository
@Transactional
public class TeacherDaoImpl extends AbstractUserDaoImpl<Teacher> implements TeacherDao {

    @Override
    public Optional<Teacher> get(int id) {
        return Optional
                .ofNullable(getHibernateTemplate())
                .map(hibernateTemplate -> hibernateTemplate.get(Teacher.class, id));
    }

    @Override
    public Teacher login(int id, String password) {
        assert getHibernateTemplate() != null;
        return getHibernateTemplate().execute(session -> {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Teacher> criteria = builder.createQuery(Teacher.class);
            Root<Teacher> root = criteria.from(Teacher.class);
            criteria.where(builder.equal(root.get("id"), id),
                    builder.and(builder.equal(root.get("password"), password)));
            return session.createQuery(criteria).uniqueResult();
        });
    }

    @Override
    public boolean register(Teacher user) {
        return add(user);
    }

    @Override
    public boolean register(String name, String password) {
        return register((Teacher) new Teacher().setName(name).setPassword(password));
    }

    @Override
    public Collection<Teacher> get() {
        assert getHibernateTemplate() != null;
        return getHibernateTemplate().loadAll(Teacher.class);
    }

}
