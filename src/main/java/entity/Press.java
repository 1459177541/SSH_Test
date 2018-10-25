package entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Press {

    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name", length = 15)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Book> books;

    public int getId() {
        return id;
    }

    public Press setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Press setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Press setBooks(Set<Book> books) {
        this.books = books;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Press press = (Press) o;
        return id == press.id &&
                Objects.equals(name, press.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Press{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
