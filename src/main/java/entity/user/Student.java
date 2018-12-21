package entity.user;


import entity.collective.Organize;
import entity.collective.StudentClass;
import entity.relation.ClassPosition;
import entity.relation.OrganizePosition;
import entity.relation.StudentCourse;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Student extends BaseRole {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "class")
    private StudentClass studentClass;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<StudentCourse> courses;

    @ManyToMany(mappedBy = "member")
    private Set<Organize> organizes;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "classPosition")
    private ClassPosition classPosition;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OrganizePosition> organizePositions;

    public Student() {
        super();
        getUser().setRole(Role.STUDENT);
        getUser().setRoleInfo(this);
    }

    public Student(User user) {
        super(user);
        getUser().setRole(Role.STUDENT);
        getUser().setRoleInfo(this);
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public Student setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
        return this;
    }

    public Set<StudentCourse> getCourses() {
        return courses;
    }

    public Student setCourses(Set<StudentCourse> courses) {
        this.courses = courses;
        return this;
    }

    public Set<Organize> getOrganizes() {
        return organizes;
    }

    public Student setOrganizes(Set<Organize> organizes) {
        this.organizes = organizes;
        return this;
    }

    public ClassPosition getClassPosition() {
        return classPosition;
    }

    public Student setClassPosition(ClassPosition classPosition) {
        this.classPosition = classPosition;
        return this;
    }

    public Set<OrganizePosition> getOrganizePositions() {
        return organizePositions;
    }

    public Student setOrganizePositions(Set<OrganizePosition> organizePositions) {
        this.organizePositions = organizePositions;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(studentClass, student.studentClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studentClass);
    }
}
