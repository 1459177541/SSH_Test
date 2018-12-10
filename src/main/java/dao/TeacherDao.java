package dao;

import entity.Course;
import entity.user.Teacher;

import java.util.Collection;

public interface TeacherDao extends UserDao<Teacher> {

    boolean register(String name, String password);

    Collection<Course> getCourse(int id);

}
