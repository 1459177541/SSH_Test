package service.impl;

import dao.StudentDao;
import dao.UserDao;
import entity.Course;
import entity.collective.Organize;
import entity.relation.StudentCourse;
import entity.user.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import service.StudentService;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Repository
public class StudentServiceImpl extends BaseUserServiceImpl<Student> implements StudentService {

    @Override
    @Autowired
    @Qualifier("studentDaoImpl")
    public BaseUserServiceImpl setDao(UserDao<Student> dao) {
        this.dao = dao;
        return this;
    }

    @Override
    public Collection<Student> get() {
        return dao.get();
    }

    @Override
    public boolean login(int id, String password) {
        return dao.login(id, password) != null;
    }

    @Override
    public boolean register(String name, String password) {
        return register((Student) new Student().setName(name).setPassword(password));
    }

    @Override
    public Collection<Course> getCourse(int id) {
        return ((StudentDao) dao).getCourse(id);
    }

    @Override
    public Collection<Organize> getOrganize(int id) {
        return ((StudentDao)dao).getOrganize(id);
    }

    @Override
    public boolean setCourse(int id, Collection<Course> courses) {
        Optional<Student> studentOptional = ((StudentDao)dao).loadCourse(id);
        if (!studentOptional.isPresent()) {
            return false;
        }
        Student student = studentOptional.get();
        return dao.update(
                student.setCourses(courses.stream()
                        .filter(course -> student
                                .getCourses()
                                .stream()
                                .map(StudentCourse::getCourse)
                                .noneMatch(course1 -> Objects.equals(course1, course)))
                        .map(course -> new StudentCourse().setCourse(course).setStudent(student))
                        .collect(Collectors.toSet())
                ));
    }

}
