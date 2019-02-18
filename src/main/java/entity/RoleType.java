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

}
