package entity.user;

import entity.Role;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Embeddable
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull
    private Integer id;

    @Column(name = "name", length = 31, nullable = false, unique = true)
    @NotNull
    private String name;

    @Column(name = "password", length = 31, nullable = false)
    @NotNull
    private String password;

    @Column(name = "email", length = 31)
    private String email;

    @Column(name = "mobile", length = 20)
    private String mobile;

    @Column(name = "gen_time")
    private Date gen_time;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "User_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "u_id")
    )
    private Set<Role> roles;

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public User setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public Date getGen_time() {
        return gen_time;
    }

    public User setGen_time(Date gen_time) {
        this.gen_time = gen_time;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public User setRoles(Set<Role> roles) {
        this.roles = roles;
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
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
