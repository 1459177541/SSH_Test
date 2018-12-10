package entity;

import entity.relation.StudentCourse;
import entity.user.Teacher;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
public class Course {

    @Id
    @Column(name = "c_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "c_name", length = 31, nullable = false)
    @NotNull
    private String name;

    @Column(name = "credit")
    @NotNull
    private double credit;

    @Column(name = "period")
    @NotNull
    private int period;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher")
    private Teacher teacher;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "course")
    private Set<StudentCourse> course;

    public Course() {
    }

    public Integer getId() {
        return id;
    }

    public Course setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Course setName(String name) {
        this.name = name;
        return this;
    }

    public double getCredit() {
        return credit;
    }

    public Course setCredit(double credit) {
        this.credit = credit;
        return this;
    }

    public int getPeriod() {
        return period;
    }

    public Course setPeriod(int period) {
        this.period = period;
        return this;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Course setTeacher(Teacher teacher) {
        this.teacher = teacher;
        return this;
    }

    public Set<StudentCourse> getCourse() {
        return course;
    }

    public Course setCourse(Set<StudentCourse> course) {
        this.course = course;
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
        Course course = (Course) o;
        return Objects.equals(id, course.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
