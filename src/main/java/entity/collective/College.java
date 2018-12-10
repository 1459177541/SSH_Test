package entity.collective;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "c_name", length = 31, nullable = false)
    @NotNull
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "college")
    private Set<StudentClass> classes;

    public College() {
    }

    public Integer getId() {
        return id;
    }

    public College setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public College setName(String name) {
        this.name = name;
        return this;
    }

    public Set<StudentClass> getClasses() {
        return classes;
    }

    public College setClasses(Set<StudentClass> classes) {
        this.classes = classes;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        College college = (College) o;
        return id.equals(college.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "College{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
