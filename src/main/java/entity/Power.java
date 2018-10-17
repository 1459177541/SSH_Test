package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Power {
    private int id;
    private String name;

    private Set<User> users = new HashSet<>();

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public Power setId(int id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public Power setName(String name) {
        this.name = name;
        return this;
    }

    @Basic
    public Set<User> getUsers() {
        return users;
    }

    public Power setUsers(Set<User> users) {
        this.users = users;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Power power = (Power) o;
        return id == power.id &&
                Objects.equals(name, power.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
