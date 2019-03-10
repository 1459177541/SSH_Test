package dao;

import entity.po.LoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginDao extends JpaRepository<LoginInfo, LoginInfo.LoginInfoId> {

}
