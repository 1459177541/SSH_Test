package entity.user;

import entity.Course;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Teacher extends BaseRole {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Course> courses;

    public Set<Course> getCourses() {
        return courses;
    }

    public Teacher setCourses(Set<Course> courses) {
        this.courses = courses;
        return this;
    }

}
