package dao;

import entity.InfoType;
import entity.Role;

import java.util.Map;

public interface RoleDao extends Dao<Role> {

    Role alterStatus(Role role);

    Map<InfoType, String> getInfo(Role role);

}
