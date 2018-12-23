package entity.user;


import entity.collective.StudentClass;
import entity.relation.ClassPosition;
import entity.relation.StudentCourse;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Student extends BaseRole {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "class", foreignKey = @ForeignKey(name = "class"))
    private StudentClass studentClass;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<StudentCourse> courses;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "classPosition", foreignKey = @ForeignKey(name = "position"))
    private ClassPosition classPosition;

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

    public ClassPosition getClassPosition() {
        return classPosition;
    }

    public Student setClassPosition(ClassPosition classPosition) {
        this.classPosition = classPosition;
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
