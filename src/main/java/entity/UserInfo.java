package entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class UserInfo implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "uid", nullable = false, foreignKey = @ForeignKey(name = "uid", foreignKeyDefinition = "info of user"))
    private User uid;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tid", nullable = false, foreignKey = @ForeignKey(name = "tid", foreignKeyDefinition = "info of type"))
    private InfoType tid;

    @Column(length = 32, nullable = false)
    private String value;

}
