package entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class BookTag {

    @Id
    private Integer id;

    @Basic
    @Column(name = "name", length = 16)
    private String name;

    @ManyToMany(mappedBy = "tag")
    private Set<Book> books;

    public Integer getId() {
        return id;
    }

    public BookTag setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BookTag setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public BookTag setBooks(Set<Book> books) {
        this.books = books;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookTag bookTag = (BookTag) o;
        return Objects.equals(id, bookTag.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "BookTag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
