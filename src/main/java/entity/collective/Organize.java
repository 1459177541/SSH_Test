package entity.collective;

import entity.relation.OrganizePosition;
import entity.user.Student;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
public class Organize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "o_name", nullable = false, length = 31)
    @NotNull
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "Organize_member",
            joinColumns = @JoinColumn(name = "o_id"),
            inverseJoinColumns = @JoinColumn(name = "s_id")
    )
    private Set<Student> member;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "position")
    private Set<OrganizePosition> positions;

    public Integer getId() {
        return id;
    }

    public Organize setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Organize setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Student> getMember() {
        return member;
    }

    public Organize setMember(Set<Student> member) {
        this.member = member;
        return this;
    }

    public Set<OrganizePosition> getPositions() {
        return positions;
    }

    public Organize setPositions(Set<OrganizePosition> positions) {
        this.positions = positions;
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
        Organize organize = (Organize) o;
        return id.equals(organize.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Organize{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
