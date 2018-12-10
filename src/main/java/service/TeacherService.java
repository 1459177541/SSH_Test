package service;

import entity.Course;
import entity.user.Teacher;

import java.util.Collection;

public interface TeacherService extends UserService<Teacher> {

    Collection<Course> getCourse(int id);

}
