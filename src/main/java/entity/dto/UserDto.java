package entity.dto;

import entity.po.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
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
}
