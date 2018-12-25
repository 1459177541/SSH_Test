package service.impl;

import dao.TeacherDao;
import dao.RoleDao;
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
public class TeacherServiceImpl extends BaseRoleServiceImpl<Teacher> implements TeacherService {

    @Override
    @Autowired
    @Qualifier("abstractRoleDaoImpl")
    public BaseRoleServiceImpl setDao(RoleDao<Teacher> dao) {
        this.dao = dao;
        return this;
    }

    @Override
    public Collection<Teacher> get() {
        return dao.get();
    }

    @Override
    public Collection<Course> getCourse(int id) {
        return ((TeacherDao) dao).getCourse(id);
    }
}
