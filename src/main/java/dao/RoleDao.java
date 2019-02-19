package dao;

import entity.po.InfoType;
import entity.po.Role;

import java.util.Map;

public interface RoleDao extends Dao<Role> {

    Role alterStatus(Role role);

    Map<InfoType, String> getInfo(Role role);

}
