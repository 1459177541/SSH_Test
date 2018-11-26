package dao.impl;

import dao.StudentDao;
import entity.collective.StudentClass;
import entity.user.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Repository
@Transactional
public class StudentDaoImpl extends UserDaoImpl<Student> implements StudentDao {

    @Override
    public Optional<Student> get(int id) {
        return Optional
                .ofNullable(getHibernateTemplate())
                .map(hibernateTemplate -> hibernateTemplate.get(Student.class, id));
    }


    @Override
    public Student login(int id, String password) {
        assert getHibernateTemplate() != null;
        return getHibernateTemplate().execute(session -> session
                .createQuery("select Student from Student where id=:id and password = :password", Student.class)
                .setParameter("id", id)
                .setParameter("password", password)
                .uniqueResult());
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