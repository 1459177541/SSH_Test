package dao.api;

import entity.po.LoginInfo;
import entity.po.User;

public interface LoginDao {

    User login(LoginInfo loginInfo);

}
