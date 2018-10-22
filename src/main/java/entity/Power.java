package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Power {

    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name", length = 15)
    private String name;

    @ManyToMany(mappedBy = "powers")
    private Set<User> users = new HashSet<>();

    public int getId() {
        return id;
    }

    public Power setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Power setName(String name) {
        this.name = name;
        return this;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Power setUsers(Set<User> users) {
        this.users = users;
        return this;
    }

    @Override
    public String toString() {
        return "Power{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + users +
                '}';
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
