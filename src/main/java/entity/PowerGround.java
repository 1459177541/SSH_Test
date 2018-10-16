package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class PowerGround {
    private Integer powerId;

    @Basic
    @Column(name = "powerId")
    public Integer getPowerId() {
        return powerId;
    }

    public PowerGround setPowerId(Integer powerId) {
        this.powerId = powerId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PowerGround that = (PowerGround) o;
        return Objects.equals(powerId, that.powerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerId);
    }

    private String id;

    @Id
    public String getId() {
        return id;
    }

    public PowerGround setId(String id) {
        this.id = id;
        return this;
    }
}
