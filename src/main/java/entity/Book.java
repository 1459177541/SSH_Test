package entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {

    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name", length = 31)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "author")
    private Author author;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "press")
    private Press press;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "BookTagMap",
            joinColumns = @JoinColumn(name = "bid"),
            inverseJoinColumns = @JoinColumn(name = "tid")
    )
    private Set<BookTag> tag;

    @Basic
    @Column(name = "price")
    private Integer price;

    public int getId() {
        return id;
    }

    public Book setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public Author getAuthor() {
        return author;
    }

    public Book setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public Press getPress() {
        return press;
    }

    public Book setPress(Press press) {
        this.press = press;
        return this;
    }

    public Set<BookTag> getTag() {
        return tag;
    }

    public Book setTag(Set<BookTag> tag) {
        this.tag = tag;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public Book setPrice(Integer price) {
        this.price = price;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Objects.equals(name, book.name) &&
                Objects.equals(tag, book.tag) &&
                Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, tag, price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", press=" + press +
                ", price=" + price +
                '}';
    }
}
