package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.Set;

@Entity
public class Press {
    private int id;
    private String name;
    private Set<Book> books;

    public Set<Book> getBooks() {
        return books;
    }

    public Press setBooks(Set<Book> books) {
        this.books = books;
        return this;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public Press setId(int id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public Press setName(String name) {
        this.name = name;
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
}
