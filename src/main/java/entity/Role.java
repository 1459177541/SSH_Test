package entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

@Entity
@Data
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
            joinColumns = {@JoinColumn(name = "uid"), @JoinColumn(name = "rid")}
    )
    @Column(name = "value", length = 64)
    @MapKeyJoinColumn(name = "tid", referencedColumnName = "tid")
    private Map<InfoType, String> info;

}
