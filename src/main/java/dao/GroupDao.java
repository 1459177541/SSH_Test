package dao;

import entity.po.Group;
import entity.po.InfoType;

import java.util.Map;

public interface GroupDao extends Dao<Group> {

    Map<InfoType, String> getInfo(Group group);
}
