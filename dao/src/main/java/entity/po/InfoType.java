package entity.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
//@Data
public class InfoType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tid;

    @Column(length = 16, nullable = false, unique = true)
    private String name;

    public Integer getTid() {
        return tid;
    }

    public InfoType setTid(Integer tid) {
        this.tid = tid;
        return this;
    }

    public String getName() {
        return name;
    }

    public InfoType setName(String name) {
        this.name = name;
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
        InfoType infoType = (InfoType) o;
        return Objects.equals(tid, infoType.tid) &&
                Objects.equals(name, infoType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tid, name);
    }
}
