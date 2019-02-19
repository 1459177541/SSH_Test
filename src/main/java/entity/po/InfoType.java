package entity.po;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class InfoType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tid;

    @Column(length = 16, nullable = false, unique = true)
    private String name;

}
