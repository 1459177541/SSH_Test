package entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;

@Data
@Entity
public class RoleType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer rid;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "pid", foreignKey = @ForeignKey(name = "pid", foreignKeyDefinition = "parent's id"))
    private RoleType pid;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "pid")
    private Set<RoleType> cRoleType;

    @Column(length = 32, nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "group", foreignKey = @ForeignKey(name = "group", foreignKeyDefinition = "group of this"))
    private Group group;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "RoleTypeInfo",
            joinColumns = @JoinColumn(name = "rid")
    )
    @Column(name = "value", length = 64)
    @MapKeyJoinColumn(name = "tid", referencedColumnName = "tid")
    private Map<InfoType, String> info;

}
