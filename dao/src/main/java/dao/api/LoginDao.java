package dao.api;

import dao.entity.po.LoginInfo;
import dao.entity.po.User;

public interface LoginDao {

    User login(LoginInfo loginInfo);

}
