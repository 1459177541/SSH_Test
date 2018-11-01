package entity;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Student extends User {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "class")
    private StudentClass studentClass;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "coursesMap",
            joinColumns = @JoinColumn(name = "s_id"),
            inverseJoinColumns = @JoinColumn(name = "c_id")
    )
    private Set<Course> courses;



}
