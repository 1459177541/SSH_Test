package dao.impl;

import dao.StudentDao;
import entity.collective.StudentClass;
import entity.user.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.Optional;

@Repository
@Transactional
public class StudentDaoImpl extends AbstractUserDaoImpl<Student> implements StudentDao {

    @Override
    public Optional<Student> get(int id) {
        return Optional
                .ofNullable(getHibernateTemplate())
                .map(hibernateTemplate -> hibernateTemplate.get(Student.class, id));
    }


    @Override
    public Student login(int id, String password) {
        assert getHibernateTemplate() != null;
        return getHibernateTemplate().execute(session -> {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
            Root<Student> root = criteria.from(Student.class);
            criteria.where(builder.equal(root.get("id"), id),
                    builder.and(builder.equal(root.get("password"), password)));
            return session.createQuery(criteria).uniqueResult();
        });
    }

    @Override
    public boolean register(String name, String password, StudentClass studentClass) {
        return register(((Student)new Student()
                .setName(name)
                .setPassword(password))
                .setStudentClass(studentClass));
    }

    @Override
    public boolean register(Student user) {
        return add(user);
    }

    @Override
    public Collection<Student> get() {
        assert getHibernateTemplate() != null;
        return getHibernateTemplate().loadAll(Student.class);
    }
}