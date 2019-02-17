package entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class RoleTypeInfo implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    private RoleType rid;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    private InfoType tid;

    @Column(length = 32, nullable = false)
    private String value;

}
