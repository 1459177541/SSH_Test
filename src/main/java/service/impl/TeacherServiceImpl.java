package service.impl;

import dao.TeacherDao;
import dao.UserDao;
import entity.Course;
import entity.user.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import service.TeacherService;

import java.util.Collection;
import java.util.Objects;

@Service
@Repository
public class TeacherServiceImpl extends BaseUserServiceImpl<Teacher> implements TeacherService {

    @Override
    @Autowired
    @Qualifier("teacherDaoImpl")
    public BaseUserServiceImpl setDao(UserDao<Teacher> dao) {
        this.dao = dao;
        return this;
    }

    @Override
    public Collection<Teacher> get() {
        return dao.get();
    }

    @Override
    public boolean login(int id, String password) {
        Objects.requireNonNull(password);
        return dao.login(id, password) != null;
    }

    @Override
    public boolean register(int id, String name, String password) {
        return register((Teacher) new Teacher().setId(id).setName(name).setPassword(password));
    }

    @Override
    public Collection<Course> getCourse(int id) {
        return ((TeacherDao) dao).getCourse(id);
    }
}
