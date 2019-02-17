package entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
public class Role implements Serializable {

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User uid;

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private RoleType rid;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<RoleInfo> infos;

}
