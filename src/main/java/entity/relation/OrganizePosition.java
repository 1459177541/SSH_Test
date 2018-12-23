package entity.relation;

import entity.Position;
import entity.collective.Organize;
import entity.user.OrganizeMember;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class OrganizePosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "organize", foreignKey = @ForeignKey(name = "organize"))
    private Organize organize;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "student", foreignKey = @ForeignKey(name = "student"))
    private OrganizeMember student;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "position", foreignKey = @ForeignKey(name = "position"))
    private Position position;

    public Organize getOrganize() {
        return organize;
    }

    public OrganizePosition setOrganize(Organize organize) {
        this.organize = organize;
        return this;
    }

    public OrganizePosition setId(Integer id) {
        this.id = id;
        return this;
    }

    public OrganizeMember getStudent() {
        return student;
    }

    public OrganizePosition setStudent(OrganizeMember student) {
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
        return id.equals(that.id) &&
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
