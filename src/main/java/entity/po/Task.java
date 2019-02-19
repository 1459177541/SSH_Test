package entity.po;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@Entity(name = "Group_Task")
@Data
@ToString(exclude = {"info", "join"})
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tid;

    @ManyToOne
    @JoinColumn(name = "task_group", nullable = false
            , foreignKey = @ForeignKey(name = "tack_group", foreignKeyDefinition = "task_group"))
    private Group group;

    @Column(length = 32, nullable = false)
    private String name;

    @Column(name = "task_schemas")
    private Schemas schemas;

    @Column(nullable = false, updatable = false)
    private Date creatTime;

    @Column
    private Date startTime;

    @Column
    private Date endTime;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "TaskInfo",
            joinColumns = @JoinColumn(name = "tid"
                    , foreignKey = @ForeignKey(name = "info_task_id", foreignKeyDefinition = "info_task_id"))
    )
    @Column(name = "value", length = 64)
    @MapKeyJoinColumn(name = "iid", referencedColumnName = "tid",
            foreignKey = @ForeignKey(foreignKeyDefinition = "info_type_id"))
    private Map<InfoType, String> info;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Role> join;

}
