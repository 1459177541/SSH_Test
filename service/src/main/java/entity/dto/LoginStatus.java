package entity.dto;

public enum LoginStatus {

    /**
     * 成功
     */
    LOGIN_SUCCESS("登录成功"),
    /**
     * 帐号不存在
     */
    USER_NON_EXISTENT("帐号不存在"),
    /**
     * 密码错误
     */
    PASSWORD_ERROR("密码错误"),
    /**
     * 帐号未验证
     */
    USER_NON_ADOPT("帐号未验证"),
    /**
     * 帐号已注销
     */
    USER_ALREADY_WRITTEN_OFF("帐号已注销"),
    /**
     * 等待通过
     */
    WAIT_ADOPT("等待通过")
    ;

    private final String note;

    LoginStatus(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

}
