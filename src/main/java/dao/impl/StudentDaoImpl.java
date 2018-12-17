package dao.impl;

import dao.StudentDao;
import entity.Course;
import entity.collective.Organize;
import entity.collective.StudentClass;
import entity.relation.StudentCourse;
import entity.user.Student;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
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
    public boolean setClass(Student student, StudentClass studentClass) {
        return update(student.setStudentClass(studentClass));
    }

    @Override
    public Collection<Course> getCourse(int id) {
        assert getHibernateTemplate() != null;
        return Objects.requireNonNull(getHibernateTemplate()
                .get(Student.class, id))
                .getCourses()
                .stream()
                .map(StudentCourse::getCourse)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Organize> getOrganize(int id) {
        assert getHibernateTemplate() != null;
        return Objects.requireNonNull(getHibernateTemplate()
                .get(Student.class, id))
                .getOrganizes();
    }

    @Override
    public Optional<Student> loadCourse(int id) {
        return Optional
                .ofNullable(getHibernateTemplate())
                .map(hibernateTemplate -> hibernateTemplate.execute(session -> {
                    Student student = session.get(Student.class, id);
                    Hibernate.initialize(student.getCourses());
                    return student;
                }));
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