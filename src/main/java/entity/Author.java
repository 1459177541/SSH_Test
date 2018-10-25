package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {

    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name", length = 15)
    private String name;

    @Basic
    @Column(name = "birthday")
    private Date birthday;

    @Basic
    @Column(name = "address", length = 127)
    private String address;

    @Basic
    @Column(name = "introduction", length = 511)
    private String introduction;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "author")
    private Set<Book> books;

    public int getId() {
        return id;
    }

    public Author setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Author setName(String name) {
        this.name = name;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Author setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Author setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getIntroduction() {
        return introduction;
    }

    public Author setIntroduction(String introduction) {
        this.introduction = introduction;
        return this;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Author setBooks(Set<Book> books) {
        this.books = books;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id &&
                Objects.equals(name, author.name) &&
                Objects.equals(birthday, author.birthday) &&
                Objects.equals(address, author.address) &&
                Objects.equals(introduction, author.introduction);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthday, address, introduction);
    }
}
