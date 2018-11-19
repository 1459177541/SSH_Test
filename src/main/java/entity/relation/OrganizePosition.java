package entity.relation;

import entity.Position;
import entity.collective.Organize;
import entity.user.Student;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class OrganizePosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "organize")
    private Organize organize;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "student")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "position")
    private Position position;

    public int getId() {
        return id;
    }

    public OrganizePosition setId(int id) {
        this.id = id;
        return this;
    }

    public Organize getOrganize() {
        return organize;
    }

    public OrganizePosition setOrganize(Organize organize) {
        this.organize = organize;
        return this;
    }

    public Student getStudent() {
        return student;
    }

    public OrganizePosition setStudent(Student student) {
        this.student = student;
        return this;
    }

    public Position getPosition() {
        return position;
    }

    public OrganizePosition setPosition(Position position) {
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
        OrganizePosition that = (OrganizePosition) o;
        return id == that.id &&
                Objects.equals(organize, that.organize) &&
                Objects.equals(student, that.student) &&
                Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, organize, student, position);
    }

    @Override
    public String toString() {
        return "OrganizePosition{" +
                "id=" + id +
                ", organize=" + organize +
                ", student=" + student +
                ", position=" + position +
                '}';
    }
}
