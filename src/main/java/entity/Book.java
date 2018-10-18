package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Book {
    private int id;
    private String name;
    private Author author;

    @Column(name = "author")
    public Author getAuthor() {
        return author;
    }

    public Book setAuthor(Author author) {
        this.author = author;
        return this;
    }

    @Column(name = "press")
    public Press getPress() {
        return press;
    }

    public Book setPress(Press press) {
        this.press = press;
        return this;
    }

    private Press press;
    private Integer tag;
    private Integer price;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public Book setId(int id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    @Basic
    @Column(name = "tag")
    public Integer getTag() {
        return tag;
    }

    public Book setTag(Integer tag) {
        this.tag = tag;
        return this;
    }

    @Basic
    @Column(name = "price")
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
                ", tag=" + tag +
                ", price=" + price +
                '}';
    }
}
