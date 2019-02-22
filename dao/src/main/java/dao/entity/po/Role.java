package dao.entity.po;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

@Entity(name = "UserRole")
@IdClass(Role.RoleId.class)
@Data
@ToString(exclude = "info")
public class Role implements Serializable {

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User uid;

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private RoleType rid;

    @Column
    private RoleStatus status;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "RoleInfo",
            joinColumns = {
                    @JoinColumn(name = "uid",
                            foreignKey = @ForeignKey(name = "info_user_id", foreignKeyDefinition = "info_user_id")),
                    @JoinColumn(name = "rid",
                            foreignKey = @ForeignKey(name = "info_role_id", foreignKeyDefinition = "info_role_id"))}
    )
    @Column(name = "value", length = 64)
    @MapKeyJoinColumn(name = "tid", referencedColumnName = "tid",
            foreignKey = @ForeignKey(name = "info_task_id", foreignKeyDefinition = "info_task_id"))
    private Map<InfoType, String> info;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "task", foreignKey = @ForeignKey(name = "join_task", foreignKeyDefinition = "join_task"))
    private Task joinTask;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_group", foreignKey = @ForeignKey(name = "join_group", foreignKeyDefinition = "join_group"))
    private Group group;

    @Data
    public static class RoleId implements Serializable{
        private User uid;
        private RoleType rid;
    }

}
