package entity.po;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

@Entity(name = "UserRole")
@IdClass(Role.RoleId.class)
//@Data
//@ToString(exclude = "info")
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

    //    @Data
    public static class RoleId implements Serializable{
        private User uid;
        private RoleType rid;

        public User getUid() {
            return uid;
        }

        public RoleId setUid(User uid) {
            this.uid = uid;
            return this;
        }

        public RoleType getRid() {
            return rid;
        }

        public RoleId setRid(RoleType rid) {
            this.rid = rid;
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
            RoleId roleId = (RoleId) o;
            return Objects.equals(uid, roleId.uid) &&
                    Objects.equals(rid, roleId.rid);
        }

        @Override
        public int hashCode() {
            return Objects.hash(uid, rid);
        }
    }

    public User getUid() {
        return uid;
    }

    public Role setUid(User uid) {
        this.uid = uid;
        return this;
    }

    public RoleType getRid() {
        return rid;
    }

    public Role setRid(RoleType rid) {
        this.rid = rid;
        return this;
    }

    public RoleStatus getStatus() {
        return status;
    }

    public Role setStatus(RoleStatus status) {
        this.status = status;
        return this;
    }

    public Map<InfoType, String> getInfo() {
        return info;
    }

    public Role setInfo(Map<InfoType, String> info) {
        this.info = info;
        return this;
    }

    public Task getJoinTask() {
        return joinTask;
    }

    public Role setJoinTask(Task joinTask) {
        this.joinTask = joinTask;
        return this;
    }

    public Group getGroup() {
        return group;
    }

    public Role setGroup(Group group) {
        this.group = group;
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
        Role role = (Role) o;
        return Objects.equals(uid, role.uid) &&
                Objects.equals(rid, role.rid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, rid);
    }
}
