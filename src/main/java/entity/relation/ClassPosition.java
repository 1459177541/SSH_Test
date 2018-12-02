package entity.relation;

import entity.Position;
import entity.collective.StudentClass;
import entity.user.Student;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class ClassPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "class")
    private StudentClass studentClass;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "student")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "position")
    private Position position;

    public ClassPosition() {
    }

    public Integer getId() {
        return id;
    }

    public ClassPosition setId(int id) {
        this.id = id;
        return this;
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public ClassPosition setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
        return this;
    }

    public Student getStudent() {
        return student;
    }

    public ClassPosition setStudent(Student student) {
        this.student = student;
        return this;
    }

    public Position getPosition() {
        return position;
    }

    public ClassPosition setPosition(Position position) {
        this.position = position;
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
        ClassPosition that = (ClassPosition) o;
        return id.equals(that.id) &&
                Objects.equals(studentClass, that.studentClass) &&
                Objects.equals(student, that.student) &&
                Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentClass, student, position);
    }

    @Override
    public String toString() {
        return "ClassPosition{" +
                "id=" + id +
                ", studentClass=" + studentClass +
                ", student=" + student +
                ", position=" + position +
                '}';
    }
}
