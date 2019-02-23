package entity.po;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Entity(name = "RoleGroup")
//@Data
//@ToString(exclude = {"info", "roles", "cGroup"})
public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer gid;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pid", foreignKey = @ForeignKey(name = "pid", foreignKeyDefinition = "parent"))
    private Group pid;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pid")
    private Set<Group> cGroup;

    @Column(length = 16, nullable = false)
    private String name;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date registerDate;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "GroupInfo",
            joinColumns = @JoinColumn(name = "gid",
                    foreignKey = @ForeignKey(name = "info_group_id", foreignKeyDefinition = "info_group_id")))
    @Column(name = "value", length = 64)
    @MapKeyJoinColumn(name = "tid", referencedColumnName = "tid",
            foreignKey = @ForeignKey(name = "info_task_id", foreignKeyDefinition = "info_task_id"))
    private Map<InfoType, String> info;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Role> roles;

    public Integer getGid() {
        return gid;
    }

    public Group setGid(Integer gid) {
        this.gid = gid;
        return this;
    }

    public Group getPid() {
        return pid;
    }

    public Group setPid(Group pid) {
        this.pid = pid;
        return this;
    }

    public Set<Group> getcGroup() {
        return cGroup;
    }

    public Group setcGroup(Set<Group> cGroup) {
        this.cGroup = cGroup;
        return this;
    }

    public String getName() {
        return name;
    }

    public Group setName(String name) {
        this.name = name;
        return this;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public Group setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
        return this;
    }

    public Map<InfoType, String> getInfo() {
        return info;
    }

    public Group setInfo(Map<InfoType, String> info) {
        this.info = info;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public Group setRoles(Set<Role> roles) {
        this.roles = roles;
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
        Group group = (Group) o;
        return gid.equals(group.gid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gid);
    }
}
