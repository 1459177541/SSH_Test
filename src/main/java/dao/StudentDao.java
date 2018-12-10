package dao;


import entity.Course;
import entity.collective.Organize;
import entity.collective.StudentClass;
import entity.user.Student;

import java.util.Collection;
import java.util.Optional;

public interface StudentDao extends UserDao<Student> {

    boolean register(String name, String password, StudentClass studentClass);

    boolean setClass(Student student, StudentClass studentClass);

    Collection<Course> getCourse(int id);

    Collection<Organize> getOrganize(int id);

    Optional<Student> load(int id);

}
