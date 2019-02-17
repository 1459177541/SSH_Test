package entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

@Entity(name = "UserRole")
@Data
@IdClass(Role.RoleId.class)
public class Role implements Serializable {

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User uid;

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private RoleType rid;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "RoleInfo",
            joinColumns = {
                    @JoinColumn(name = "uid", foreignKey = @ForeignKey(foreignKeyDefinition = "info_uid")),
                    @JoinColumn(name = "rid", foreignKey = @ForeignKey(foreignKeyDefinition = "info_rid"))}
    )
    @Column(name = "value", length = 64)
    @MapKeyJoinColumn(name = "tid", referencedColumnName = "tid",
            foreignKey = @ForeignKey(foreignKeyDefinition = "info_tid"))
    private Map<InfoType, String> info;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "task", foreignKey = @ForeignKey(foreignKeyDefinition = "join_task"))
    private Task joinTask;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_group", foreignKey = @ForeignKey(foreignKeyDefinition = "join_group"))
    private Group groupRole;

    @Data
    public static class RoleId implements Serializable{
        private User uid;
        private RoleType rid;
    }

}
