package entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import entity.po.InfoType;
import entity.po.LoginInfo;
import entity.po.Role;
import entity.po.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;
import java.util.Set;

@Data
@NoArgsConstructor
public class UserDto {

    private Integer uid;

    private String id;

    private LoginStatus status;

    private String name;

    private String ip;

    @JsonIgnore
    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm", locale = "zh", timezone = "GMT+8")
    private Date loginDate;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm", locale = "zh", timezone = "GMT+8")
    private Date registerDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<LoginInfo> loginInfo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<Role> roles;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<InfoType, String> info;

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
