package entity.po;

//import lombok.Data;
//import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Group_Task")
//@Data
//@ToString(exclude = {"info", "join"})
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
    @CreationTimestamp
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

    public Integer getTid() {
        return tid;
    }

    public Task setTid(Integer tid) {
        this.tid = tid;
        return this;
    }

    public Group getGroup() {
        return group;
    }

    public Task setGroup(Group group) {
        this.group = group;
        return this;
    }

    public String getName() {
        return name;
    }

    public Task setName(String name) {
        this.name = name;
        return this;
    }

    public Schemas getSchemas() {
        return schemas;
    }

    public Task setSchemas(Schemas schemas) {
        this.schemas = schemas;
        return this;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public Task setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Task setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Task setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    public Map<InfoType, String> getInfo() {
        return info;
    }

    public Task setInfo(Map<InfoType, String> info) {
        this.info = info;
        return this;
    }

    public Set<Role> getJoin() {
        return join;
    }

    public Task setJoin(Set<Role> join) {
        this.join = join;
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
        Task task = (Task) o;
        return Objects.equals(tid, task.tid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tid);
    }
}
