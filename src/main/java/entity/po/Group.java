package entity.po;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@Entity(name = "RoleGroup")
@Data
@ToString(exclude = {"info", "roles", "cGroup"})
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
}
