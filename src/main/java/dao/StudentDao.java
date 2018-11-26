package dao;

import entity.collective.StudentClass;
import entity.user.Student;

public interface StudentDao extends UserDao<Student> {

    boolean register(String name, String password, StudentClass studentClass);

}
