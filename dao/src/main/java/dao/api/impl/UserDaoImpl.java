package dao.api.impl;

import dao.api.LoginDao;
import dao.entity.po.LoginInfo;
import dao.entity.po.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserDaoImpl implements LoginDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public User login(LoginInfo loginInfo) {
        return null;
    }

}
