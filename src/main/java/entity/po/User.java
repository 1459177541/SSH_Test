package entity.po;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@Entity
@Data
@ToString(exclude = {"loginInfo", "roles", "info"})
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

}
