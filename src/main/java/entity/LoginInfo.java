package entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@IdClass(LoginInfo.LoginInfoId.class)
public class LoginInfo {

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    @Id
    private Date date;

    @Column(length = 16)
    private String ip;

    @Data
    public static class LoginInfoId implements Serializable {

        private User user;

        private Date date;
    }
}
