package entity.relation;

import entity.Course;
import entity.user.Student;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class StudentCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "student")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "course")
    private Course course;

    @Column(name = "score")
    private double score;

    public StudentCourse() {
    }

    public int getId() {
        return id;
    }

    public StudentCourse setId(int id) {
        this.id = id;
        return this;
    }

    public Student getStudent() {
        return student;
    }

    public StudentCourse setStudent(Student student) {
        this.student = student;
        return this;
    }

    public Course getCourse() {
        return course;
    }

    public StudentCourse setCourse(Course course) {
        this.course = course;
        return this;
    }

    public double getScore() {
        return score;
    }

    public StudentCourse setScore(double score) {
        this.score = score;
        return this;
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "student=" + student +
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentCourse that = (StudentCourse) o;
        return Objects.equals(student, that.student) &&
                Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, course);
    }
}
