package entity.user;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class BaseRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @OneToOne
    protected User user = new User();

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
        user.setId(id);
        return this;
    }

    public String getName() {
        return user.getName();
    }

    public BaseRole setName(String name) {
        user.setName(name);
        return this;
    }

    public String getPassword() {
        return user.getPassword();
    }

    public BaseRole setPassword(String password) {
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
}
