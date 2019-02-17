package entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Map;
import java.util.Set;

@Entity
@Data
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer gid;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pid", foreignKey = @ForeignKey(name = "pid", foreignKeyDefinition = "parent's id"))
    private Group pid;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Group> cGroup;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "GroupInfo",
            joinColumns = @JoinColumn(name = "gid")
    )
    @Column(name = "value", length = 64)
    @MapKeyJoinColumn(name = "tid", referencedColumnName = "tid")
    private Map<InfoType, String> info;
}
