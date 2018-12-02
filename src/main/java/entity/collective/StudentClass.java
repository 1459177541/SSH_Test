package entity.collective;

import entity.relation.ClassPosition;
import entity.user.Student;
import entity.user.Teacher;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class StudentClass {

    @Id
    @Column(name = "c_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "c_name", length = 31)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "college")
    private College college;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "headmaster")
    private Teacher headmaster;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "class")
    private Set<Student> students;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "position")
    private Set<ClassPosition> position;

    public College getCollege() {
        return college;
    }

    public StudentClass setCollege(College college) {
        this.college = college;
        return this;
    }

    public Teacher getHeadmaster() {
        return headmaster;
    }

    public StudentClass setHeadmaster(Teacher headmaster) {
        this.headmaster = headmaster;
        return this;
    }

    public StudentClass() {
    }

    public Integer getId() {
        return id;
    }

    public StudentClass setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StudentClass setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public StudentClass setStudents(Set<Student> students) {
        this.students = students;
        return this;
    }

    public Set<ClassPosition> getPosition() {
        return position;
    }

    public StudentClass setPosition(Set<ClassPosition> position) {
        this.position = position;
        return this;
    }

    @Override
    public String toString() {
        return "StudentClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StudentClass that = (StudentClass) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
