package entity.user;

import entity.collective.Organize;
import entity.relation.OrganizePosition;

import javax.persistence.*;
import java.util.Set;

@Entity
public class OrganizeMember extends Student {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "organize", foreignKey = @ForeignKey(name = "organize"))
    private Organize organize;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OrganizePosition> organizePositions;

    public Organize getOrganize() {
        return organize;
    }

    public OrganizeMember setOrganize(Organize organize) {
        this.organize = organize;
        return this;
    }

    public Set<OrganizePosition> getOrganizePositions() {
        return organizePositions;
    }

    public OrganizeMember setOrganizePositions(Set<OrganizePosition> organizePositions) {
        this.organizePositions = organizePositions;
        return this;
    }

}
