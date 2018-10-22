package entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class BookTag {

    @Id
    private Integer id;

    @Basic
    @Column(name = "name", length = 16)
    private String name;

    @ManyToMany(mappedBy = "tid")
    private Set<Book> books;

}
