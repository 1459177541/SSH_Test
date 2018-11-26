package dao;

import entity.user.Teacher;

public interface TeacherDao extends UserDao<Teacher> {

    boolean register(String name, String password);

}
