package entity;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Student extends User {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "class")
    private StudentClass studentClass;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "coursesMap",
            joinColumns = @JoinColumn(name = "s_id"),
            inverseJoinColumns = @JoinColumn(name = "c_id")
    )
    private Set<Course> courses;

    @ManyToMany(mappedBy = "member")
    private Set<Organize> organizes;

    public Set<Organize> getOrganizes() {
        return organizes;
    }

    public Student setOrganizes(Set<Organize> organizes) {
        this.organizes = organizes;
        return this;
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public Student setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
        return this;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public Student setCourses(Set<Course> courses) {
        this.courses = courses;
        return this;
    }
}
