package dao.impl;

import dao.TeacherDao;
import entity.user.Teacher;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Repository
@Transactional
public class TeacherDaoImpl extends UserDaoImpl<Teacher> implements TeacherDao {

    @Override
    public Optional<Teacher> get(int id) {
        return Optional
                .ofNullable(getHibernateTemplate())
                .map(hibernateTemplate -> hibernateTemplate.get(Teacher.class, id));
    }

    @Override
    public Teacher login(int id, String password) {
        assert getHibernateTemplate() != null;
        return getHibernateTemplate().execute(session -> session
                .createQuery("select Teacher from Teacher where id=:id and password=:password", Teacher.class)
                .setParameter("id", id)
                .setParameter("password", password)
                .uniqueResult());
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
