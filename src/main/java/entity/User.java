package entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@Entity
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer uid;

    @Column(length = 32, nullable = false)
    private String name;

    @Column(length = 32, nullable = false)
    private String password;

    @Column(updatable = false, nullable = false)
    private Date registerDate;

    @Column(nullable = false)
    private Date lastLogin;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Role> roleTypes;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "UserInfo",
            joinColumns = @JoinColumn(name = "uid")
    )
    @Column(name = "value", length = 64)
    @MapKeyJoinColumn(name = "tid", referencedColumnName = "tid")
    private Map<InfoType, String> info;

}
