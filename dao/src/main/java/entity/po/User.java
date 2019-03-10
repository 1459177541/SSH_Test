package entity.po;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Entity
//@Data
//@ToString(exclude = {"loginInfo", "roles", "info"})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer uid;

    @Column(length = 32, nullable = false, unique = true)
    private String id;

    @Column(nullable = false)
    private UserStatus status;

    @Column(length = 32, nullable = false)
    private String name;

    @Column(length = 64, nullable = false)
    private String password;

    @Column(updatable = false, nullable = false)
    @CreationTimestamp
    private Date registerDate;

    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<LoginInfo> loginInfo;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Role> roles;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "UserInfo",
            joinColumns = @JoinColumn(name = "uid",
                    foreignKey = @ForeignKey(name = "info_user_id", foreignKeyDefinition = "info_user_id"))
    )
    @Column(name = "value", length = 64)
    @MapKeyJoinColumn(name = "tid", referencedColumnName = "tid",
            foreignKey = @ForeignKey(name = "info_task_id", foreignKeyDefinition = "info_task_id"))
    private Map<InfoType, String> info;

    public Integer getUid() {
        return uid;
    }

    public User setUid(Integer uid) {
        this.uid = uid;
        return this;
    }

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public UserStatus getStatus() {
        return status;
    }

    public User setStatus(UserStatus status) {
        this.status = status;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public User setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
        return this;
    }

    public Set<LoginInfo> getLoginInfo() {
        return loginInfo;
    }

    public User setLoginInfo(Set<LoginInfo> loginInfo) {
        this.loginInfo = loginInfo;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public User setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    public Map<InfoType, String> getInfo() {
        return info;
    }

    public User setInfo(Map<InfoType, String> info) {
        this.info = info;
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
        User user = (User) o;
        return Objects.equals(uid, user.uid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid);
    }
}
