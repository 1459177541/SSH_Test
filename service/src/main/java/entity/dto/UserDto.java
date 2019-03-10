package entity.dto;


import entity.po.User;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

//@Data
//@NoArgsConstructor
public class UserDto implements Serializable {

    private Integer uid;

    private String id;

    private LoginStatus status;

    private String info;

    private String name;

    private String ip;

    private String password;

    private Date loginDate;

    private Date registerDate;

    public UserDto() {
    }

    public UserDto(User user) {
        this.uid = user.getUid();
        this.id = user.getId();
        this.name = user.getName();
        this.registerDate = user.getRegisterDate();
        this.password = user.getPassword();
    }

    public boolean loginSuccess() {
        return LoginStatus.LOGIN_SUCCESS == status;
    }

    public Integer getUid() {
        return uid;
    }

    public UserDto setUid(Integer uid) {
        this.uid = uid;
        return this;
    }

    public String getId() {
        return id;
    }

    public UserDto setId(String id) {
        this.id = id;
        return this;
    }

    public LoginStatus getStatus() {
        return status;
    }

    public UserDto setStatus(LoginStatus status) {
        this.status = status;
        return this;
    }

    public String getInfo() {
        return info;
    }

    public UserDto setInfo(String info) {
        this.info = info;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public UserDto setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public UserDto setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
        return this;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public UserDto setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
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
        UserDto userDto = (UserDto) o;
        return Objects.equals(uid, userDto.uid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid);
    }
}
