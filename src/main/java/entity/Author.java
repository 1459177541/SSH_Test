package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {
    private int id;
    private String name;
    private Date birthday;
    private String address;
    private String introduction;
    private Set<Book> books;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public Author setId(int id) {
        this.id = id;
        return this;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public Author setName(String name) {
        this.name = name;
        return this;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public Author setBirthday(Date brithday) {
        this.birthday = brithday;
        return this;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public Author setAddress(String address) {
        this.address = address;
        return this;
    }

    @Basic
    @Column(name = "introduction")
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
    public int hashCode() {
        return Objects.hash(id, name, birthday, address, introduction);
    }
}
