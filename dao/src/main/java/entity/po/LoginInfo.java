package entity.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
//@Data
@IdClass(LoginInfo.LoginInfoId.class)
public class LoginInfo {

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    @Id
    private Date date;

    @Column(length = 16)
    private String ip;

    //    @Data
    public static class LoginInfoId implements Serializable {

        private User user;

        private Date date;

        public User getUser() {
            return user;
        }

        public LoginInfoId setUser(User user) {
            this.user = user;
            return this;
        }

        public Date getDate() {
            return date;
        }

        public LoginInfoId setDate(Date date) {
            this.date = date;
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
            LoginInfoId that = (LoginInfoId) o;
            return Objects.equals(user, that.user) &&
                    Objects.equals(date, that.date);
        }

        @Override
        public int hashCode() {
            return Objects.hash(user, date);
        }
    }

    public User getUser() {
        return user;
    }

    public LoginInfo setUser(User user) {
        this.user = user;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public LoginInfo setDate(Date date) {
        this.date = date;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public LoginInfo setIp(String ip) {
        this.ip = ip;
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
        LoginInfo loginInfo = (LoginInfo) o;
        return Objects.equals(user, loginInfo.user) &&
                Objects.equals(date, loginInfo.date) &&
                Objects.equals(ip, loginInfo.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, date, ip);
    }
}
