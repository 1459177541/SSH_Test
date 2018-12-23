package entity.user;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
public class BaseRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user", foreignKey = @ForeignKey(name = "role's_user"))
    protected User user;

    public BaseRole() {
    }

    public BaseRole(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public BaseRole setUser(User user) {
        this.user = user;
        return this;
    }

    public int getId() {
        return user.getId();
    }

    public BaseRole setId(int id) {
        if (user == null) {
            user = new User();
        }
        user.setId(id);
        return this;
    }

    public String getName() {
        return user.getName();
    }

    public BaseRole setName(String name) {
        if (user == null) {
            user = new User();
        }
        user.setName(name);
        return this;
    }

    public String getPassword() {
        return user.getPassword();
    }

    public BaseRole setPassword(String password) {
        if (user == null) {
            user = new User();
        }
        user.setPassword(password);
        return this;
    }

    public String getEmail() {
        return user.getEmail();
    }

    public BaseRole setEmail(String email) {
        user.setEmail(email);
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
        BaseRole baseRole = (BaseRole) o;
        return Objects.equals(user, baseRole.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }
}
