package service.impl;

import dao.UserDao;
import entity.user.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import service.TeacherService;

import java.util.Collection;

@Service
@Repository
public class TeacherServiceImpl extends UserServiceImpl<Teacher> implements TeacherService {

    @Override
    @Autowired
    @Qualifier("teacherDaoImpl")
    public UserServiceImpl setUserDao(UserDao<Teacher> userDao) {
        this.userDao = userDao;
        return this;
    }

    @Override
    public Collection<Teacher> get() {
        return userDao.get();
    }
}
