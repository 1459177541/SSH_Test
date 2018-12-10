package service;

import entity.Course;
import entity.collective.Organize;
import entity.user.Student;

import java.util.Collection;

public interface StudentService extends UserService<Student> {


    Collection<Course> getCourse(int id);

    Collection<Organize> getOrganize(int id);

    boolean setCourse(int id, Collection<Course> courses);


}
