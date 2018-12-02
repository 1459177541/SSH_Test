package service.impl;

import dao.UserDao;
import entity.user.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import service.StudentService;

import java.util.Collection;

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
}
