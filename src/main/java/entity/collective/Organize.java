package entity.collective;

import entity.relation.OrganizePosition;
import entity.user.OrganizeMember;

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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "organize", foreignKey = @ForeignKey(name = "member"))
    private Set<OrganizeMember> member;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "position", foreignKey = @ForeignKey(name = "position"))
    private Set<OrganizePosition> positions;

    public String getName() {
        return name;
    }

    public Organize setName(String name) {
        this.name = name;
        return this;
    }

    public Organize setId(Integer id) {
        this.id = id;
        return this;
    }

    public Set<OrganizeMember> getMember() {
        return member;
    }

    public Organize setMember(Set<OrganizeMember> member) {
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
