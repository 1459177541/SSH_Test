package entity.collective;

import entity.relation.ClassPosition;
import entity.user.Headmaster;
import entity.user.Student;
import entity.user.Teacher;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
public class StudentClass {

    @Id
    @Column(name = "c_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "c_name", length = 31)
    @NotNull
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "college", foreignKey = @ForeignKey(name = "colege"))
    private College college;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "headmaster", foreignKey = @ForeignKey(name = "headmaster"))
    private Headmaster headmaster;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "class", foreignKey = @ForeignKey(name = "student"))
    private Set<Student> students;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "position", foreignKey = @ForeignKey(name = "position"))
    private Set<ClassPosition> position;

    public College getCollege() {
        return college;
    }

    public StudentClass setCollege(College college) {
        this.college = college;
        return this;
    }

    public Headmaster getHeadmaster() {
        return headmaster;
    }

    public StudentClass setHeadmaster(Headmaster headmaster) {
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
