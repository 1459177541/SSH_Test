package entity.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Entity
//@Data
//@ToString(exclude = {"cRoleType", "info"})
public class RoleType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer rid;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "pid",
            foreignKey = @ForeignKey(name = "pid", foreignKeyDefinition = "parent"))
    private RoleType pid;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "pid")
    private Set<RoleType> cRoleType;

    @Column(length = 32, nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_group",
            foreignKey = @ForeignKey(name = "role_group", foreignKeyDefinition = "role_group"))
    private Group group;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "RoleTypeInfo",
            joinColumns = @JoinColumn(name = "rid",
                    foreignKey = @ForeignKey(name = "info_role_id", foreignKeyDefinition = "info_role_id"))
    )

    @Column(name = "value", length = 64)
    @MapKeyJoinColumn(name = "tid", referencedColumnName = "tid",
            foreignKey = @ForeignKey(foreignKeyDefinition = "info_tid"))
    private Map<InfoType, String> info;

    public Integer getRid() {
        return rid;
    }

    public RoleType setRid(Integer rid) {
        this.rid = rid;
        return this;
    }

    public RoleType getPid() {
        return pid;
    }

    public RoleType setPid(RoleType pid) {
        this.pid = pid;
        return this;
    }

    public Set<RoleType> getcRoleType() {
        return cRoleType;
    }

    public RoleType setcRoleType(Set<RoleType> cRoleType) {
        this.cRoleType = cRoleType;
        return this;
    }

    public String getName() {
        return name;
    }

    public RoleType setName(String name) {
        this.name = name;
        return this;
    }

    public Group getGroup() {
        return group;
    }

    public RoleType setGroup(Group group) {
        this.group = group;
        return this;
    }

    public Map<InfoType, String> getInfo() {
        return info;
    }

    public RoleType setInfo(Map<InfoType, String> info) {
        this.info = info;
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
        RoleType roleType = (RoleType) o;
        return Objects.equals(rid, roleType.rid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rid);
    }
}
