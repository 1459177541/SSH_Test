package entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Teacher extends User {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Course> courses;

    public Teacher() {
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public Teacher setCourses(Set<Course> courses) {
        this.courses = courses;
        return this;
    }
}
